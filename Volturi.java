public class Volturi extends Clan{
    private int influenciaPolitica;
    public Volturi(String nombreClan, int influenciaPolitica) {
        super(nombreClan);
        this.influenciaPolitica = influenciaPolitica;
    }
    @Override
    public void expulsarVampiro(Vampiro vampiro, Clan sinClan) {
        if (influenciaPolitica < 80) {
            if (vampiros.remove(vampiro)) {
                System.out.println(vampiro.getNombre() + " ha sido expulsado del clan " + nombreClan + ".");
                sinClan.admitirVampiro(vampiro);
            } else {
                System.out.println(vampiro.getNombre() + " no pertenece al clan " + nombreClan + ".");
            }
        } else {
            System.out.println("No se puede expulsar vampiros de " + nombreClan + " por su gran influencia politica ("+influenciaPolitica+")\n(Debe ser menor que 80 puntos)");
        }
    }
    @Override
    public void admitirVampiro(Vampiro vampiro) {
        if(vampiro.getFuerza()>30 && vampiro.getVelocidad()>30){
            vampiros.add(vampiro);
            vampiro.Clan = nombreClan;
            System.out.println(vampiro.getNombre() + " ha sido admitido en el clan " + nombreClan + ".");
        } else {
            System.out.println("Para ser admitido a los Volturi, " + vampiro.getNombre() + " debería tener al menos 30 de fuerza y 30 de velocidad");
        }
    }
    public void mostrarInfluenciaPolitica() {
        System.out.println("Influencia política de los Volturi: " + influenciaPolitica);
    }
}
