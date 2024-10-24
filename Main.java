import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String archivoCSV = "vampiros.csv"; // Ruta del archivo CSV
        Set<String> clanes = new HashSet<>(); // Utilizamos un Set para almacenar clanes únicos

        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
            String linea;
            boolean primeraLinea = true;
            while ((linea = br.readLine()) != null) {
                if (primeraLinea) {
                    primeraLinea = false;
                    continue;
                }
                String[] datos = linea.split(",");
                String nombre = datos[0];
                String clan = datos[6];  // La columna 6 es donde está el clan
                clanes.add(clan);  // Añadimos el clan al conjunto
            }

            Scanner sc = new Scanner(System.in);
            ArrayList<Vampiro> vampiros = new ArrayList<>();  // Lista para almacenar vampiros
            boolean ciclo = true;

            while (ciclo) {
                System.out.println("1. Mostrar clanes\n2. Crear Vampiro\n3. Listar vampiros\n4. Admitir vampiro a un clan\n5. Expulsar vampiro de un clan\n6. Comer\n7. Obtener vampiro más apto\n8. Salir");
                int opcion = sc.nextInt();
                sc.nextLine();  // Consumir el salto de línea después del int
                switch (opcion) {
                    case 1:
                        System.out.println("Clanes:");
                        for (String clan : clanes) {
                            System.out.println(clan);  // Listamos todos los clanes
                        }
                        break;
                    case 2:
                        // Recoger datos para crear el vampiro
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
                        new Crear_vampiro(nombre, fuerza, velocidad, hambre,"", alas);

                        // vampiros.add(nuevoVampiro);
                        // System.out.println("Vampiro creado: " + nuevoVampiro);
                        break;
                    case 3:
                        // Listar vampiros
                        System.out.println("Vampiros:");
                        for (Vampiro vamp : vampiros) {
                            System.out.println(vamp);
                        }
                        break;
                    case 4:
                        System.out.println("Opcion 4");
                        // Código para admitir vampiro a clan
                        break;
                    case 5:
                        System.out.println("Opcion 5");
                        // Código para expulsar vampiro de clan
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
                        System.out.println("Saliendo del programa...");
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
