public abstract class Vampiro{
    String nombre;
    int fuerza,velocidad;
    int hambre;
    String colorOjos;
    boolean alas;
    Vampiro(String n,int f, int v, int h,String c,boolean a){
        this.nombre=n;
        this.fuerza=f;
        this.velocidad=v;
        this.hambre=h;
        this.colorOjos=c;
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
        return colorOjos;
    }
    public boolean getAlas(){
        return alas;
    }
}