public abstract class Vampiro{
    String nombre;
    int fuerza,velocidad;
    int hambre;
    String ColorOjos;
    boolean alas;
    Vampiro(String n,int f, int v, int h,String c,boolean a){
        this.nombre=n;
        this.fuerza=f;
        this.velocidad=v;
        this.hambre=h;
        this.ColorOjos=c;
        this.alas=a;
    }
    public abstract void comer();
    public abstract void habilidadEspecial();
    //public abstract void comerAnimal();
    //public abstract void chuparSangre();
}