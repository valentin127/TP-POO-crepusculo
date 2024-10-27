public class Volturi extends Clan{
    private int influenciaPolitica;
    public Volturi(String nombreClan, int influenciaPolitica) {
        super(nombreClan);
        this.influenciaPolitica = influenciaPolitica;
    }
    @Override
    public void expulsarVampiro(Vampiro vampiro) {
        if (influenciaPolitica < 80) {
            if (vampiros.remove(vampiro)) {
                System.out.println(vampiro.getNombre() + " ha sido expulsado del clan " + nombreClan + ".");
            } else {
                System.out.println(vampiro.getNombre() + " no pertenece al clan " + nombreClan + ".");
            }
        } else {
            System.out.println("No se puede expulsar vampiros de" + nombreClan + "por su gran influencia politica");
        }
    }
    @Override
    public void admitirVampiro(Vampiro vampiro) {
        if(vampiro.getFuerza()>30 && vampiro.getVelocidad()>30){
            vampiros.add(vampiro);
            System.out.println(vampiro.getNombre() + " ha sido admitido en el clan " + nombreClan + ".");
        } else {
            System.out.println("Para ser admitido a los Volturi, " + vampiro.getNombre() + " debería tener al menos 30 de fuerza y 30 de velocidad");
        }
    }
    public void mostrarInfluenciaPolitica() {
        System.out.println("Influencia política de los Volturi: " + influenciaPolitica);
    }
}
