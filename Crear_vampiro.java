public class Crear_vampiro {
    
    // Constructor para la clase Crear_vampiro
    Crear_vampiro(String n, int f, int v, int h, String c, String a) {
        Vampiro nuevoVampiro = crearVampiro(n, f, v, h, c, a);
        if (nuevoVampiro != null) {
            System.out.println("Se ha creado un vampiro de tipo: " + nuevoVampiro.getClass().getSimpleName());
        } else {
            System.out.println("No se pudo crear el vampiro. La fuerza está fuera del rango permitido.");
        }
    }
    
    // Función para determinar qué tipo de vampiro crear
    public Vampiro crearVampiro(String nombre, int fuerza, int velocidad, int hambre, String colorOjos, String alas) {
        if (fuerza < 1 || fuerza > 100) {
            return null;  // Fuerza fuera de rango
        }

        // Según la fuerza, creamos el tipo adecuado de vampiro
        if (fuerza >= 1 && fuerza <= 20) {
            return new RecienConvertido(nombre, fuerza, velocidad, hambre, "rojo", alas);
        } else if (fuerza > 20 && fuerza <= 50) {
            return new Adulto(nombre, fuerza, velocidad, hambre, "amarillo", alas);
        } else if (fuerza > 50 && fuerza <= 100) {
            return new Maduro(nombre, fuerza, velocidad, hambre, "naraja", alas);
        }

        return null;
    }
}
