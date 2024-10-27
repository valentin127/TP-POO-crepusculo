import java.util.Random;

public class Adulto extends Vampiro implements ComedorDeAnimales {
    
    private int condicion = 10;

    Adulto(String n,int f, int v, int h,String c,String clan, String a){
        super(n, f, v, h,c,clan, a);
        this.condicion = GenerarCondicion();
    }

    @Override
    public void comer() {
        if (hambre>1) {
            Random random = new Random();
            hambre = hambre - random.nextInt(99)+1;
            condicion = 80;
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
        if(condicion>70){
            System.out.println(nombre + " utiliza su habilidad de vampiro adulto: Agilidad (su fuerza y su velocidad aumentan 25 puntos temporalmente).");
            System.out.println("Su velocidad antes de es: "+ velocidad);
            System.out.println("Su fuerza antes de es: "+ fuerza);
            velocidad += 25;
            fuerza += 25;
            System.out.println("Su velocidad despues de es: "+ velocidad);
            System.out.println("Su fuerza despues de es: "+ fuerza);
            hambre = 100;
            fuerza = fuerza - 25;
            velocidad = velocidad - 25;
            

            
        }
        else{
            System.out.println(nombre + " no puede utilizar su habilidad especial ya que su atributo unico (condicion) es de:"+condicion+". \nDebe ser mayor a 70 puntos, para que el vampiro pueda usarlo, comiendo sube su condicion");
        }

        
    }

    @Override
    public void comerAnimal(){
        if (hambre > 1) {
            Animal animal = new Animal();
            hambre = hambre - animal.getHambre();
            condicion = 80;
            if (hambre < 0) {
                hambre = 1;
            }
        } else {
            System.out.println(nombre + " no tiene hambre en este momento.");
        }
    }

    
    public int getCoondicon() {
        return condicion;
    }

    private int GenerarCondicion(){
        Random random = new Random();
        return random.nextInt(99) + 1; 
    }
}
