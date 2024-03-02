package dd.core;

public abstract class Personaje {

    private String nombre;
    private Ataque ataque;
    private int salud;

    public Personaje(String nombre){
        this.nombre=nombre;
    }
    public abstract int[] ataca(Personaje enemigo);

    public void setAtaque(Ataque ataque){
        this.ataque=ataque;
    }
    public Ataque getAtaque(){
        return ataque;
    }
    public void asignarAtaque(){
        setAtaque(ataque.crearAtaque());
    }
    public void setSalud(int salud){
        this.salud=salud;

    }
    public int getSalud(){
        return salud;
    }
    public void reducirSalud(int num){
        if(num >= this.salud){
            this.salud = 0;
        } else {
            this.salud -= num;
        }
    }

    public String toString(){
        return "[ "+nombre+":"+salud+"]";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}


