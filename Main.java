import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Vampiro> vampiros = new ArrayList<>();  // Lista para almacenar vampiros
        boolean ciclo = true;

        while (ciclo) {
            System.out.println("1. Mostrar clanes\n2. Crear Vampiro\n3. Listar vampiros\n4. Admitir vampiro a clan\n5. Expulsar vampiro de clan\n6. Comer\n7. Obtener vampiro más alto\n8. Salir");
            int opcion = sc.nextInt();
            sc.nextLine();  // Consumir el salto de línea después del int
            switch (opcion) {
                case 1:
                    System.out.println("Clanes: ");
                    // Mostrar lista de clanes
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
                    
                    //vampiros.add(nuevoVampiro);
                    //System.out.println("Vampiro creado: " + nuevoVampiro);
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
                    // Código para obtener el vampiro más alto
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
    }
}
