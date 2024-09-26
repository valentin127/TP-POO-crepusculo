import java.util.ArrayList;
import java.util.List;

public abstract class Clan {
    private String nombreClan;
    private List<Vampiro> vampiros;

    public Clan(String nombreClan) {
        this.nombreClan = nombreClan;
        this.vampiros = new ArrayList<>();
    }

    public void admitirVampiro(Vampiro vampiro) {
        vampiros.add(vampiro);
        System.out.println(vampiro.getNombre() + " ha sido admitido en el clan " + nombreClan + ".");
    }

    public void expulsarVampiro(Vampiro vampiro) {
        if (vampiros.remove(vampiro)) {
            System.out.println(vampiro.getNombre() + " ha sido expulsado del clan " + nombreClan + ".");
        } else {
            System.out.println(vampiro.getNombre() + " no pertenece al clan " + nombreClan + ".");
        }
    }

    public void listarVampiros() {
        System.out.println("Vampiros en el clan " + nombreClan + ":");
        for (int i = 0; i < vampiros.size(); i++) {
            Vampiro vampiro = vampiros.get(i);
            System.out.println("- " + vampiro.getNombre());
        }
    }
}
