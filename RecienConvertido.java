public class RecienConvertido extends Vampiro {

    // Constructor específico para RecienConvertido
    public RecienConvertido(String n,int f, int v, int h,String c,String a){
        super(n, f, v, h, c, a);
        // Los recién convertidos podrían tener características específicas al ser creados.
        this.fuerza += 10; // Por ejemplo, un bono de fuerza inicial.
        this.hambre = 100; // Al estar recién convertidos, podrían tener mucha hambre.
    }

    // Implementación del método abstracto comer
    @Override
    public void comer() {
        if (hambre > 0) {
            System.out.println(nombre + " está comiendo para saciar su hambre.");
            hambre -= 20; // Reduce el hambre después de comer
            if (hambre < 0) {
                hambre = 0;
            }
        } else {
            System.out.println(nombre + " no tiene hambre en este momento.");
        }
    }

    // Implementación del método abstracto habilidadEspecial
    @Override
    public void habilidadEspecial() {
        System.out.println(nombre + " utiliza su habilidad de recién convertido: Velocidad Explosiva.");
        velocidad += 50;
    }

    // Otros métodos específicos para RecienConvertido pueden ir aquí
}