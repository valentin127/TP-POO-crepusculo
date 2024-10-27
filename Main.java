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
            String linea;
            boolean primeraLinea = true;
            while ((linea = br.readLine()) != null) {
                if (primeraLinea) {
                    primeraLinea = false;  // Saltar la primera línea (cabeceras)
                    continue;
                }
                // Suponiendo que las columnas del CSV son: Nombre, Edad, Fuerza, Velocidad, Hambre, ColorOjos, Clan, TieneAlas
                String[] datos = linea.split(",");
                String nombre = datos[0];
                int fuerza = Integer.parseInt(datos[1]);
                int velocidad = Integer.parseInt(datos[2]);
                int hambre = Integer.parseInt(datos[3]);
                //String ColorOjos = datos[4];
                String clan = datos[5];
                String alas = datos[6].equalsIgnoreCase("si") ? "si" : "no";  // Convertir el texto a una respuesta booleana
                int años = Integer.parseInt(datos[7]);

                // Crear vampiro con los datos leídos usando la clase Crear_vampiro
                Crear_vampiro creador = new Crear_vampiro(nombre, fuerza, velocidad, hambre, clan, alas);
                ClanComun cl = new ClanComun(clan, años);

                // Obtener el vampiro creado y añadirlo a la lista si no es null
                Vampiro vampiro = creador.obtenerVampiroCreado();
                if (vampiro != null) {
                    vampiros.add(vampiro);  // Añadir vampiro a la lista
                    boolean existe = false;
                    for (Clan existente : clanes) {
                        if (existente.getNombre().equalsIgnoreCase(cl.getNombre())) {  // Comparar nombres de clanes (ignorar mayúsculas)
                            existe = true;
                            break;
        }
    }

                // Si el clan no existe, añadirlo a la lista de clanes
                if (!existe) {
                    clanes.add(cl);
                }
             }
            }

            // Menú interactivo
            Scanner sc = new Scanner(System.in);
            boolean ciclo = true;

            while (ciclo) {
                System.out.println("Sistema gestor de crepusculo: \n1. Mostrar clanes\n2. Crear Vampiro\n3. Listar vampiros\n4. Admitir vampiro a un clan\n5. Expulsar vampiro de un clan\n6. Comer\n7. Obtener vampiro más apto\n8. Salir");
                int opcion = sc.nextInt();
                sc.nextLine();  // Consumir el salto de línea después del int
                switch (opcion) {
                    case 1:
                        // Mostrar clanes
                        System.out.println("Clanes:");
                        for (Clan clan : clanes) {
                            System.out.println(clan);
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
                        sc.nextLine();  // Consumir el salto de línea

                        System.out.println("¿Tiene alas? (si/no):");
                        String alas = sc.nextLine();

                        // Crear vampiro usando la clase Crear_vampiro
                        Crear_vampiro creador = new Crear_vampiro(nombre, fuerza, velocidad, hambre, alas);

                        // Obtener el vampiro creado y añadirlo a la lista si no es null
                        Vampiro nuevoVampiro = creador.obtenerVampiroCreado();
                        if (nuevoVampiro != null) {
                            vampiros.add(nuevoVampiro);
                            System.out.println("Vampiro creado y añadido a la lista.");
                        } else {
                            System.out.println("Error al crear el vampiro. Verifica los valores ingresados.");
                        }
                        break;
                    case 3:
                        // Listar vampiros
                        System.out.println("Vampiros:");
                        for(Clan clan:clanes){
                            System.out.println("Vampiros del clan "+clan+":");
                            clan.listarVampiros();
                        }
                        break;
                    case 4:
                        System.out.println("Opcion 4");
                        // Código para admitir vampiro a clan
                        boolean creado = true;
                        System.out.println("¿El clan esta en lista o se creara uno nuevo? Ingrese SI para crear uno nuevo de lo contrario ingrese otra cosa: \n");
                        String pal = sc.nextLine();
                        if(pal.equals("SI")){
                            creado = false;
                        }
                        if (!creado) {
                            System.out.println("Ingresa el nombre del vampiro:");
                            //String nombreClan = sc.nextLine();
                            //Aca ya deje la estructura para armar nuevos clanes, debemos hablar que hacemos
                        }

                        break;
                        case 5:
                        System.out.println("Opción 5 - Expulsar vampiro de su clan\n");
                        
                        int i = 0;
                        for (Vampiro vamp : vampiros) {
                            i++;
                            System.out.println(i + " - " + vamp);  // Llamada al método toString() de Vampiro
                        }
                        
                        System.out.println("Seleccione un vampiro a expulsar de su clan (1 - " + vampiros.size() + "):");
                        int seleccion = sc.nextInt() - 1; 
                        
                        if ((seleccion >= 0) && (seleccion < vampiros.size()) && (!(vampiros.get(seleccion).Clan.equals("Sin clan")))) {
                            vampiros.get(seleccion).Clan = "Sin clan";  // Cambiar el clan del vampiro seleccionado
                            System.out.println("El vampiro " + vampiros.get(seleccion).nombre + " ha sido expulsado de su clan.");
                        } else {
                            System.out.println("Selección inválida o el vampiro no tiene clan.");
                        }
                        break;
                    
                    case 6:
                        System.out.println("Opcion 6");
                        // Código para comer
                        break;
                    case 7:
                        System.out.println("Opcion 7");
                        // Código para obtener el vampiro más apto
                        break;
                    case 8:
                    System.out.println("Guardando los vampiros y saliendo del programa...");
                
                    // Guardar los cambios en el archivo CSV
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoCSV))) {
                        // Escribir la cabecera
                        bw.write("Nombre,Fuerza,Velocidad,Hambre,ColorOjos,Clan,TieneAlas,a \n");
                
                        // Escribir cada vampiro en el archivo CSV
                        for (Vampiro vamp : vampiros) {
                            // Acceder directamente a los atributos del vampiro y escribirlos en el archivo
                            bw.write(vamp.nombre + "," 
                                    + vamp.fuerza + "," 
                                    + vamp.velocidad + "," 
                                    + vamp.hambre + "," 
                                    + vamp.ColorOjos + "," 
                                    + vamp.Clan + "," 
                                    + (vamp.alas.equalsIgnoreCase("si") ? "si" : "no") + ","
                                    + vamp.velocidad +"\n" );
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
            e.printStackTrace(); // Imprime la traza del error en la consola
        }
    }
}
