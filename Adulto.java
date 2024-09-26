public class Adulto extends Vampiro {
    
    public Adulto(String n,int f, int v, int h,String c,boolean a){
        super(n, f, v, h,c, a);
    }
    @Override
    public void comer() {
        if (hambre > 0) {
            System.out.println(nombre + " está comiendo para saciar su hambre.");
            hambre -= 10; // Reduce el hambre después de comer
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
        System.out.println(nombre + " utiliza su habilidad de recién convertido: Potenciado.");
        velocidad += 25;
        fuerza += 25;
    }

    // Otros métodos específicos para RecienConvertido pueden ir aquí
}
