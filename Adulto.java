public class Adulto extends Vampiro implements ComedorDeAnimales {
    
    private int sabiduria = 10;

    Adulto(String n,int f, int v, int h,String c,String clan, String a){
        super(n, f, v, h,c,clan, a);
    }

    @Override
    public void comer() {
        if (hambre > 0) {
            System.out.println(nombre + " está comiendo para saciar su hambre.");
            hambre -= 10;
            if (hambre < 0) {
                hambre = 0;
            }
        } else {
            System.out.println(nombre + " no tiene hambre en este momento.");
        }
    }

    @Override
    public void habilidadEspecial() {
        System.out.println(nombre + " utiliza su habilidad de vampiro adulto: Agilidad.");
        velocidad += 25;
        fuerza += 25;
        sabiduria += 5;
        if (velocidad > 100) {
            velocidad = 100;
        }
        if (fuerza > 100) {
            fuerza = 100;
        }
        if (sabiduria > 100) {
            sabiduria = 100;
        }
    }

    @Override
    public void ComerAnimal(){
        if (hambre > 0) {
            System.out.println(nombre + " está comiendo un animal para saciar su hambre.");
            hambre -= 15;
            if (hambre < 0) {
                hambre = 0;
            }
        } else {
            System.out.println(nombre + " no tiene hambre en este momento.");
        }
    }

    public int getSabiduria() {
        return sabiduria;
    }
}
