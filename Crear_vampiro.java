public class Crear_vampiro {
    
    // Este será el vampiro creado
    private Vampiro vampiroCreado;

    // Constructor para la clase Crear_vampiro
    public Crear_vampiro(String n, int f, int v, int h,String clan, String a) {
        vampiroCreado = crearVampiro(n, f, v, h,clan, a);
        if (vampiroCreado != null) {
            //System.out.println("Se ha creado un vampiro de tipo: " + vampiroCreado.getClass().getSimpleName());
        } else {
            System.out.println("No se pudo crear el vampiro. La fuerza está fuera del rango permitido.");
        }
    }
    public Crear_vampiro(String n, int f, int v, int h, String a) {
        vampiroCreado = crearVampiro(n, f, v, h,"Sin clan", a);
        if (vampiroCreado != null) {
            //System.out.println("Se ha creado un vampiro de tipo: " + vampiroCreado.getClass().getSimpleName());
        } else {
            System.out.println("No se pudo crear el vampiro. La fuerza está fuera del rango permitido.");
        }
    }

    // Función para determinar qué tipo de vampiro crear
    public Vampiro crearVampiro(String nombre, int fuerza, int velocidad, int hambre,String Clan, String alas) {
        if (fuerza < 1 || fuerza > 100) {
            return null;  // Fuerza fuera de rango
        }

        // Según la fuerza, creamos el tipo adecuado de vampiro
        if (fuerza >= 1 && fuerza <= 20) {
            return new RecienConvertido(nombre, fuerza, velocidad, hambre, "rojo",Clan, alas);
        } else if (fuerza > 20 && fuerza <= 50) {
            return new Adulto(nombre, fuerza, velocidad, hambre, "amarillo",Clan, alas);
        } else if (fuerza > 50 && fuerza <= 100) {
            return new Maduro(nombre, fuerza, velocidad, hambre, "naraja",Clan, alas);
        }

        return null;
    }

    // Método para obtener el vampiro creado
    public Vampiro obtenerVampiroCreado() {
        return vampiroCreado;
    }
}
