public class Maduro extends Vampiro {
    
    Maduro(String n,int f, int v, int h,String c,String a){
        super(n, f, v, h,c, a);
    }

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
        velocidad += 50; // Aumenta temporalmente la velocidad
    }

    // Otros métodos específicos para RecienConvertido pueden ir aquí
}
