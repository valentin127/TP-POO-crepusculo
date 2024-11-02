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
            int hambreAnterior = hambre;
            Random random = new Random();
            hambre = hambre - random.nextInt(99)+1;
            condicion = 80;
            if (hambre < 1) {
                hambre = 1;
            }
            System.out.println(nombre + " está comiendo.");
            System.out.println("Hambre: " + hambreAnterior + " --> " + hambre);
        }
        else {
            System.out.println(nombre + " no tiene hambre en este momento.");
        }

    }
    @Override
    public void habilidadEspecial() {
        if(condicion>70){
            System.out.println(nombre + " utiliza su habilidad de vampiro adulto: Agilidad (su fuerza y su velocidad aumentan 25 puntos temporalmente).");
            System.out.println("Hambre: " + hambre + " --> " + 100);
            velocidad += 25;
            fuerza += 25;
            System.out.println("Velocidad: " + (velocidad-25) + " --> " + velocidad);
            System.out.println("Fuerza: " + (fuerza-25) + " --> " + fuerza);
            hambre = 100;
            fuerza = fuerza - 25;
            velocidad = velocidad - 25;
        }
        else{
            System.out.println(nombre + " no puede utilizar su habilidad especial ya que su atributo unico (condicion) es de: "+condicion+". \nDebe ser mayor a 70 puntos. (Comer aumenta su condicion)");
        }
    }
    @Override
    public void comerAnimal(){
        if (hambre > 1) {
            int hambreAnterior = hambre;
            Animal animal = new Animal();
            hambre = hambre - animal.getValorNutritivo();
            condicion = 80;
            if (hambre < 1) {
                hambre = 1;
            }
            System.out.println(nombre + " está comiendo un animal.");
            System.out.println("Hambre: " + hambreAnterior + " --> " + hambre);
        } else {
            System.out.println(nombre + " no tiene hambre en este momento.");
        }
    }
    public int getCondicon() {
        return condicion;
    }
    private int GenerarCondicion(){
        Random random = new Random();
        return random.nextInt(99) + 1; 
    }
}
