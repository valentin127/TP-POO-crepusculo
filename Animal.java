import java.util.Random;

public class Animal {
    private int hambre; 
    public Animal() {
        this.hambre = generarHambreAleatorio(); 
    }
    public int getHambre() {
        return hambre;
    }
    private int generarHambreAleatorio() {
        Random random = new Random();
        return random.nextInt(99) + 1; 
    }


}
