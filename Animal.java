import java.util.Random;

public class Animal {
    private int valorNutritivo; 
    public Animal() {
        this.valorNutritivo = generarValorNutritivo(); 
    }
    public int getValorNutritivo() {
        return valorNutritivo;
    }
    private int generarValorNutritivo() {
        Random random = new Random();
        return random.nextInt(99) + 1; 
    }


}
