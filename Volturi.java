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

    // Nuevo método exclusivo de Volturi
    public void mostrarInfluenciaPolitica() {
        System.out.println("Influencia política de los Volturi: " + influenciaPolitica);
    }
}
