import java.util.Random;

public class Maduro extends Vampiro implements ComedorDeAnimales {

    private int autocontrol = 50;
    
    Maduro(String n,int f, int v, int h,String c,String clan, String a){
        super(n, f, v, h,c,clan, a);
        this.autocontrol = generarAutocontrol();
    }

    @Override
    public void comer() {
        if (hambre>1) {
            
        
        Random random = new Random();
        hambre = hambre - random.nextInt(99)+1;
        autocontrol = 90;
            if (hambre<0) {
                hambre = 1;
            }
        }
        else {
            System.out.println(nombre + " no tiene hambre en este momento.");
        }

    }

    @Override
    public void habilidadEspecial() {
        if (autocontrol>50){
            System.out.println(nombre + " utiliza su habilidad de vampiro maduro: Fuerza Extrema. (Su fuerza aumenta en 50 puntos)");
            fuerza += 50;
        }
        else{
            System.out.println(nombre + " no puede utilizar su habilidad especial ya que su atributo unico (autocontrol) es de:"+autocontrol+". \nDebe ser mayor a 50 puntos, para que el vampiro pueda usarlo, comiendo sube su autocontrol");
        }
    }
    

    @Override
    public void comerAnimal() {
        if (hambre > 1) {
            Animal animal = new Animal();
            hambre = hambre - animal.getHambre();
            autocontrol =60;
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
    private int generarAutocontrol() {
        Random random = new Random();
        return random.nextInt(99) + 1; 
    }
    
}
