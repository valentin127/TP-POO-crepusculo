public class ClanComun extends Clan{
    private int antiguedadDelClan;
    public ClanComun(String nombreClan, int adc) {
        super(nombreClan);
        this.antiguedadDelClan=adc;
    }


    @Override
    public int getEdad(){
        return antiguedadDelClan;
    }
}