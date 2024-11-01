import java.util.ArrayList;
import java.util.List;
public class Clan {
    protected String nombreClan;
    protected List<Vampiro> vampiros;
    protected final int antiguedadDelClan;
    public Clan(String nombreClan, int adc) {
        this.nombreClan = nombreClan;
        this.vampiros = new ArrayList<>();
        this.antiguedadDelClan=adc;
    }
    public void IniciarClanes(Vampiro vampiro){
        vampiros.add(vampiro);
    }
    public void admitirVampiro(Vampiro vampiro) {
        vampiros.add(vampiro);
        vampiro.Clan = nombreClan;
        if (!nombreClan.equals("Sin clan")) {
            System.out.println(vampiro.getNombre() + " ha sido admitido en el clan " + nombreClan + ".");
        }
    }
    public void expulsarVampiro(Vampiro vampiro, Clan sinClan) {
        if (vampiros.remove(vampiro)) {
            if (!nombreClan.equals("Sin clan")) {
                System.out.println(vampiro.getNombre() + " ha sido expulsado del clan " + nombreClan + ".");
                sinClan.admitirVampiro(vampiro);
            }
        } else {
            System.out.println(vampiro.getNombre() + " no pertenece al clan " + nombreClan + ".");
        }
    }
    public void listarVampiros() {
        if (nombreClan.equals("Sin clan")) {
            System.out.println("Vampiros sin clan:");
        } else {
            System.out.println("Vampiros en el clan " + nombreClan + ":");
        }
        for (int i = 0; i < vampiros.size(); i++) {
            Vampiro vampiro = vampiros.get(i);
            System.out.println("- " + vampiro);
        }
    }
    public String getNombreClan(){
        return nombreClan;
    }
    public List<Vampiro> getVampiros() {
        return vampiros;
    }
    public int getAntiguedadDelClan(){
        return antiguedadDelClan;
    }
    @Override
    public String toString(){
        return nombreClan;
    }
}
