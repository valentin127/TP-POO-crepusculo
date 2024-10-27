import java.util.Random;
public class RecienConvertido extends Vampiro {

    private int inestabilidad = 50;

    RecienConvertido(String n,int f, int v, int h,String c,String clan, String a){
        super(n, f, v, h,c,clan, a);
        this.inestabilidad = generarInestabilidadAleatorio();
    }

    /*@Override
    public void comerAnimal() {
        if (hambre > 1) {
            Animal animal = new Animal();
            hambre = hambre - animal.getHambre();
            if (hambre<0) {
                hambre = 1;
            }

        } else {
            System.out.println(nombre + " no tiene hambre en este momento.");
        }
    }*/
    @Override
    public void comer(){

    }

    @Override
    public void habilidadEspecial() {
        System.out.println(nombre + " utiliza su habilidad de recién convertido: Velocidad Explosiva.");
        velocidad += 50;
        inestabilidad -= 10;
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

    private int generarInestabilidadAleatorio() {
        Random random = new Random();
        return random.nextInt(99) + 1; 
    }
}