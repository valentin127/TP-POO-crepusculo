import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Volturi clanVolturi = new Volturi();  // Descomentar cuando la clase Volturi esté implementada

        while (true) {
            System.out.println("1. Agregar Vampiro\n2. Listar Vampiros\n3. Salir");
            int opcion = sc.nextInt();
            sc.nextLine();  // Consumir el salto de línea después del int
            switch (opcion) {
                case 1:
                    // Aquí deberías pedir los atributos del vampiro y crear un nuevo vampiro
                    // Por ejemplo:
                    System.out.println("Ingrese el nombre del vampiro:");
                    String nombre = sc.nextLine();
                    // Ingresar otros atributos: fuerza, velocidad, hambre, colorOjos, alas
                    // Vampiro nuevoVampiro = new RecienConvertido(nombre, fuerza, velocidad, hambre, colorOjos, alas);
                    // clanVolturi.agregarVampiro(nuevoVampiro);  // Una vez que implementes la clase Volturi
                    break;
                case 2:
                    // clanVolturi.listarVampiros();  // Descomentar cuando tengas implementada esta función
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
}
