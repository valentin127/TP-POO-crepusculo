import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Volturi clanVolturi = new Volturi();  // Descomentar cuando la clase Volturi esté implementada
        boolean ciclo=true;
        while (ciclo) {
            System.out.println("1. Mostrar clanes\n2. Crear Vampiro\n3.Listar vampiros\n4. Admitir vampiro a clan\n5.Expulsar vampiro de clan\n6.comer\n7.Obtener vampiro más alto\n8.salir");
            int opcion = sc.nextInt();
            sc.nextLine();  // Consumir el salto de línea después del int
            switch (opcion) {
                case 1:
                    System.out.println("Clanes: ");
                    // Mostrar lista de clanes
                    break;
                case 2:
                    System.out.println("Opcion 2");
                    // Código para crear vampiro
                    break;
                case 3:
                    System.out.println("Opcion 3");
                    // Código para listar vampiros
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
                    ciclo=false;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
}
