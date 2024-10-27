import java.util.ArrayList;
import java.util.List;
public abstract class Clan {
    protected  String nombreClan;
    protected List<Vampiro> vampiros;
    public Clan(String nombreClan) {
        this.nombreClan = nombreClan;
        this.vampiros = new ArrayList<>();
    }
    public void IniciarClanes(Vampiro vampiro){
        vampiros.add(vampiro);
    }
    public void admitirVampiro(Vampiro vampiro) {
        vampiros.add(vampiro);
        if (!nombreClan.equals("Sin clan")) {
            System.out.println(vampiro.getNombre() + " ha sido admitido en el clan " + nombreClan + ".");
        }
    }
    public void expulsarVampiro(Vampiro vampiro) {
        if (vampiros.remove(vampiro)) {
            if (!nombreClan.equals("Sin clan")) {
                System.out.println(vampiro.getNombre() + " ha sido expulsado del clan " + nombreClan + ".");
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
    @Override
    public String toString(){
        return nombreClan;
    }
}
