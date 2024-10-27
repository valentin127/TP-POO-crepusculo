public abstract class Vampiro{
    protected String nombre;
    protected int fuerza,velocidad;
    protected int hambre;
    protected String ColorOjos;
    protected String Clan;
    protected String alas;
    Vampiro(String n,int f, int v, int h,String c,String clan,String a){
        this.nombre=n;
        this.fuerza=f;
        this.velocidad=v;
        this.hambre=h;
        this.ColorOjos=c;
        this.Clan=clan;
        this.alas=a;
    }
    public abstract void comer();
    public abstract void habilidadEspecial();
    //public abstract void comerAnimal();
    //public abstract void chuparSangre();
    public String getNombre() {
        return nombre;
    }
    public String getColorOjos(){
        return ColorOjos;
    }
    public String getAlas(){
        return alas;
    }
    public int getFuerza(){
        return fuerza;
    }
    public int getVelocidad(){
        return velocidad;
    }


    @Override
    public String toString() {
        return nombre + " | Fuerza: " + fuerza + ", Velocidad: " + velocidad +
           ", Hambre: " + hambre + ", Color de Ojos: " + ColorOjos + ", Clan: " + Clan +
           ", Tipo: " + getClass().getSimpleName() + ", Alas: " + alas;
    }
}