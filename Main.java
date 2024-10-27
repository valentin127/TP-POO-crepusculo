import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String archivoCSV = "vampiros.csv"; // Ruta del archivo CSV
        ArrayList<Clan> clanes = new ArrayList<>(); // Utilizamos un Set para almacenar clanes únicos
        ArrayList<Vampiro> vampiros = new ArrayList<>();  // Lista para almacenar vampiros

        // Leer el archivo CSV
        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {

            // Se crea el clan "Sin clan"
            Clan sinClan = new ClanComun("Sin clan", 0);
            clanes.add(sinClan);

            String linea;
            boolean primeraLinea = true;
            while ((linea = br.readLine()) != null) {
                if (primeraLinea) {
                    primeraLinea = false;  
                    continue;
                }
                String[] datos = linea.split(",");
                String nombre = datos[0];
                int fuerza = Integer.parseInt(datos[1]);
                int velocidad = Integer.parseInt(datos[2]);
                int hambre = Integer.parseInt(datos[3]);
                //String ColorOjos = datos[4];
                String clanNombre = datos[5];
                String alas = datos[6].equalsIgnoreCase("si") ? "si" : "no";  // Convertir el texto a una respuesta booleana
                int años = Integer.parseInt(datos[7]);

                // Crear vampiro con los datos leídos usando la clase Crear_vampiro
                Crear_vampiro creador = new Crear_vampiro(nombre, fuerza, velocidad, hambre, clanNombre, alas);

                // Obtener el vampiro creado y añadirlo a la lista si no es null
                Vampiro vampiro = creador.obtenerVampiroCreado();
                if (vampiro != null) {
                    vampiros.add(vampiro);  // Añadir vampiro a la lista
                   
                     // Verifica si el clan ya existe
                    Clan clanExistente = null;
                    for (Clan existente : clanes) {
                        if (existente.getNombreClan().equalsIgnoreCase(clanNombre)) {  // Comparar nombres de clanes (ignorar mayúsculas)
                            clanExistente = existente;
                            break;
                        }
                    }
                    // Si el clan existe, admite al vampiro en el clan existente
                    if (clanExistente != null) {
                        clanExistente.admitirVampiro(vampiro);
                    } else {
                        // Si el clan no existe, añade un nuevo clan y admite al vampiro
                        ClanComun nuevoClan = new ClanComun(clanNombre, años);
                        clanes.add(nuevoClan);
                        nuevoClan.admitirVampiro(vampiro);
                    }
                }
            }

            // Menú interactivo
            Scanner sc = new Scanner(System.in);
            boolean ciclo = true;

            while (ciclo) {
                System.out.println("Sistema gestor de crepusculo: \n1. Mostrar clanes\n2. Crear Vampiro\n3. Listar vampiros\n4. Admitir vampiro a un clan\n5. Expulsar vampiro de un clan\n6. Comer\n7. Obtener vampiro más apto\n8. Salir");
                int opcion = sc.nextInt();
                sc.nextLine();  
                switch (opcion) {
                    case 1:
                        // Mostrar clanes
                        System.out.println("Clanes:");
                        for (Clan clan : clanes) {
                            System.out.println("- " + clan);
                        }
                        break;
                    case 2:
                        // Crear nuevo vampiro manualmente
                        System.out.println("Ingresa el nombre del vampiro:");
                        String nombre = sc.nextLine();
                        System.out.println("Ingresa la fuerza del vampiro (entre 1 y 100):");
                        int fuerza = sc.nextInt();
                        System.out.println("Ingresa la velocidad del vampiro:");
                        int velocidad = sc.nextInt();
                        System.out.println("Ingresa el hambre del vampiro:");
                        int hambre = sc.nextInt();
                        sc.nextLine();  
                        System.out.println("¿Tiene alas? (si/no):");
                        String alas = sc.nextLine();
                        Crear_vampiro creador = new Crear_vampiro(nombre, fuerza, velocidad, hambre, alas);
                        Vampiro nuevoVampiro = creador.obtenerVampiroCreado();
                        if (nuevoVampiro != null) {
                            vampiros.add(nuevoVampiro);
                            sinClan.admitirVampiro(nuevoVampiro);
                            System.out.println("Vampiro creado y añadido a la lista.");
                        } else {
                            System.out.println("Error al crear el vampiro. Verifica los valores ingresados.");
                        }
                        break;
                    case 3:
                        // Listar vampiros
                        for(Clan clan:clanes){
                            clan.listarVampiros();
                        }
                        break;
                    case 4:
                        System.out.println("Opcion 4");
                        // Código para admitir vampiro a clan

                        System.out.println("Ingrese el nombre del clan: ");
                        String nombreClan = sc.nextLine();

                        Clan clanExistente = null;
                        for (Clan c : clanes) {
                            if (c.getNombreClan().equals(nombreClan)) {
                                clanExistente = c;
                                break;
                            }
                        }
                        if (clanExistente == null) {
                            System.out.println("El clan indicado no existe");
                            break;
                        }

                        System.out.println("Ingrese el nombre del vampiro: ");
                        String nombreVampiro = sc.nextLine();

                        Vampiro vampiroExistente = null;
                        for (Vampiro v : vampiros) {
                            if (v.getNombre().equals(nombreVampiro)) {
                                vampiroExistente = v;
                                break;
                            }
                        }
                        if (vampiroExistente == null) {
                            System.out.println("El vampiro indicado no existe");
                            break;
                        } else if(!vampiroExistente.getClan().equals("Sin clan")){
                            System.out.println("El vampiro indicado ya se encuentra en un clan");
                        } else {
                            clanExistente.admitirVampiro(vampiroExistente);
                            vampiroExistente.Clan = clanExistente.getNombreClan();
                            sinClan.expulsarVampiro(vampiroExistente);
                        }

                        break;

                    case 5:
                        System.out.println("Opción 5 - Expulsar vampiro de su clan\n");
                        // Código para expulsar vampiro de su clan
                        // Usamos un 2 en las variables porque java da un error raro con la variable definida en otro case
                        
                        System.out.println("Ingrese el nombre del clan: ");
                        String nombreClan2 = sc.nextLine();

                        Clan clanExistente2 = null;
                        for (Clan c : clanes) {
                            if (c.getNombreClan().equals(nombreClan2)) {
                                clanExistente2 = c;
                                break;
                            }
                        }
                        if (clanExistente2 == null) {
                            System.out.println("El clan indicado no existe");
                            break;
                        }
                        if (clanExistente2.getNombreClan().equals("Sin clan")) {
                            System.out.println("No se puede expulsar si no tiene clan");
                            break;
                        }
                        
                        
                        System.out.println("Ingrese el nombre del vampiro: ");
                        String nombreVampiro2 = sc.nextLine();

                        Vampiro vampiroExistente2 = null;
                        for (Vampiro v : vampiros) {
                            if (v.getNombre().equals(nombreVampiro2)) {
                                vampiroExistente2 = v;
                                break;
                            }
                        }
                        if (vampiroExistente2 == null) {
                            System.out.println("El vampiro indicado no existe");
                            break;
                        }
                        clanExistente2.expulsarVampiro(vampiroExistente2);
                        vampiroExistente2.Clan = "Sin clan";
                        sinClan.admitirVampiro(vampiroExistente2);
                        break;
                    
                        case 6:
                        System.out.println("Opción 6 - Comer");
                    
                        // Recorremos la lista de vampiros
                        int index=0;
                        for (int i = 0; i < vampiros.size(); i++) {
                            Vampiro vamp = vampiros.get(i);
                            System.out.println((i + 1) + ". Vampiro: " + vamp.getNombre() + " (Hambre actual: " + vamp.getHambre() + ")");
                            index=i;
                        }
                    
                        // Permitir al usuario elegir un vampiro que va a comer
                        System.out.println("Seleccione el número del vampiro que va a comer:");
                        int vampiroSeleccionado = sc.nextInt() - 1;  // Restamos 1 para que coincida con el índice de la lista
                        sc.nextLine();  // Consumir el salto de línea después del número
                        //boolean comerAnimal = false;
                        if (vampiroSeleccionado >= 0 && vampiroSeleccionado < vampiros.size()) {
                            Vampiro vampiroQueCome = vampiros.get(vampiroSeleccionado);
                            System.out.println("¿El vampiro come solamente animales? Ingrese *si* si es asi: (recuerde que los recien_convertidos solo comen personas) ");
                            String come=sc.nextLine();
                            if (come.equalsIgnoreCase("si") && !(vampiros.get(index).fuerza<=20)){
                                //vampiroQueCome.comerAnimal();
                            }
                            // Aquí puedes implementar la lógica para que el vampiro coma
                            // Ejemplo: disminuir el hambre
                            System.out.println(vampiroQueCome.getNombre() + " va a comer.");
                    
                            // Puedes hacer que su hambre se reduzca de forma aleatoria o en una cantidad fija
                            int hambreAntes = vampiroQueCome.getHambre();
                            vampiroQueCome.comer();  // Asumiendo que tienes un método para que el vampiro coma
                    
                            // Mostramos el hambre antes y después de comer
                            System.out.println("Hambre de " + vampiroQueCome.getNombre() + " antes de comer: " + hambreAntes);
                            System.out.println("Hambre de " + vampiroQueCome.getNombre() + " después de comer: " + vampiroQueCome.getHambre());
                        } else {
                            System.out.println("Selección inválida.");
                        }
                    
                        break;
                    
                    case 7:
                        System.out.println("Opción 7 - Vampiro más apto (fuerza + velocidad): ");
                
                        Vampiro vampiroMasApto = null;
                        int mayorAptitud = 0; 
                        for (Vampiro vamp : vampiros) {
                            int aptitudActual = vamp.fuerza + vamp.velocidad;  // Calcular la suma de fuerza y velocidad
                            if (aptitudActual > mayorAptitud) {
                                mayorAptitud = aptitudActual;  // Actualizar la mayor aptitud
                                vampiroMasApto = vamp;  // Guardar al vampiro más apto hasta ahora
                            }
                        }
                        if (vampiroMasApto != null) {
                            System.out.println("El vampiro más apto es: " + vampiroMasApto.nombre + " con fuerza " + vampiroMasApto.fuerza + " y velocidad " + vampiroMasApto.velocidad + " (Total: " + mayorAptitud + ")" + " , posee un hambre de: "+ vampiroMasApto.hambre);
                        } else {
                            System.out.println("No hay vampiros en la lista.");
                        }
                        break;
                    case 8:
                        System.out.println("Guardando los vampiros y saliendo del programa...");
                
                        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoCSV))) {
                        bw.write("Nombre,Fuerza,Velocidad,Hambre,ColorOjos,Clan,TieneAlas,Antiguedad del clan \n");
                
                        for (Vampiro vamp : vampiros) {
                            bw.write(vamp.nombre + "," 
                                    + vamp.fuerza + "," 
                                    + vamp.velocidad + "," 
                                    + vamp.hambre + "," 
                                    + vamp.ColorOjos + "," 
                                    + vamp.Clan + "," 
                                    + (vamp.alas.equalsIgnoreCase("si") ? "si" : "no") + ","
                                     );
                                     for (Clan clan : clanes) {
                                        if (clan.getNombreClan().equalsIgnoreCase(vamp.Clan)) {
                                            bw.write( clan.getEdad() + "\n");
                                        }
                                     }
                                    }
                        
                        } catch (IOException e) {
                        System.out.println("Error al guardar los vampiros en el archivo CSV: " + e.getMessage());
                        }
                
                        sc.close();
                        ciclo = false;
                        break;
                
                    default:
                        System.out.println("Opción no válida");
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }
}
