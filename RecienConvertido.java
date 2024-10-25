public class RecienConvertido extends Vampiro{

    private int inestabilidad = 50;

    RecienConvertido(String n,int f, int v, int h,String c,String clan, String a){
        super(n, f, v, h,c,clan, a);
        // Los recién convertidos podrían tener características específicas al ser creados.
    }

    @Override
    public void comer() {
        if (hambre > 0) {
            System.out.println(nombre + " está comiendo para saciar su hambre.");
            inestabilidad -= 10;
            hambre -= 20;
            if (hambre < 0) {
                hambre = 0;
            }
            if (inestabilidad < 0) {
                inestabilidad = 0;
            }
        } else {
            System.out.println(nombre + " no tiene hambre en este momento.");
        }
    }

    @Override
    public void habilidadEspecial() {
        System.out.println(nombre + " utiliza su habilidad de recién convertido: Velocidad Explosiva.");
        velocidad += 50;
        inestabilidad += 10;
        if (velocidad > 100) {
            velocidad = 100;
        }
        if (inestabilidad > 100) {
            inestabilidad = 100;
        }
    }

    public int getInestabilidad() {
        return inestabilidad;
    }

}