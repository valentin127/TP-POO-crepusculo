public class Maduro extends Vampiro implements ComedorDeAnimales {

    private int autocontrol = 50;
    
    Maduro(String n,int f, int v, int h,String c,String clan, String a){
        super(n, f, v, h,c,clan, a);
    }

    @Override
    public void comer() {
        if (hambre > 0) {
            System.out.println(nombre + " está comiendo para saciar su hambre.");
            autocontrol +=10;
            hambre -= 15;
            if (hambre < 0) {
                hambre = 0;
            }
            if (autocontrol > 100) {
                autocontrol = 100;
            }
        } else {
            System.out.println(nombre + " no tiene hambre en este momento.");
        }
    }

    @Override
    public void habilidadEspecial() {
        System.out.println(nombre + " utiliza su habilidad de vampiro maduro: Fuerza Extrema.");
        fuerza += 50;
        autocontrol -= 10;
        if (fuerza > 100) {
            fuerza = 100;
        }
        if (autocontrol < 0) {
            autocontrol = 0;
        }
    }

    @Override
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
    }
    public int getAutocontrol() {
        return autocontrol;
    }
    
}
