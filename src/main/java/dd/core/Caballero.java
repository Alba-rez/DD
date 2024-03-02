package dd.core;

public class Caballero extends Personaje implements Ataque{

    private int salud;

    public Caballero(String nombre) {
        super(nombre);
        setSalud(1500);
    }
    public void setAtaque(Ataque ataque){
        super.setAtaque(ataque);
    }
    @Override
    public int[] ataca(Personaje enemigo) {
        int []resultados=new int[2];
        for(int i=0;i<2;i++){
            resultados[i]=getAtaque().lanzaAtaque(enemigo);
        }
        return resultados;
    }
    @Override
    public int  lanzaAtaque(Personaje enemigo) {
        return getAtaque().lanzaAtaque(enemigo);
    }

    @Override
    public int getValorAtaque() {
        return getAtaque().getValorAtaque();
    }

    @Override
    public Ataque crearAtaque() {
        return getAtaque();
    }


}
