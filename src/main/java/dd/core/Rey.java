package dd.core;

public class Rey extends Caballero implements Ataque{
    private int salud;

    public Rey(String nombre) {
        super(nombre);
        setSalud(2000);

    }

    @Override
    public int[] ataca(Personaje enemigo) {
        int []resultados=new int[3];
        for(int i=0;i<3;i++){
            getAtaque().lanzaAtaque(enemigo);
            resultados[i]=getAtaque().getValorAtaque();
        }
        return resultados;
    }

    @Override
    public int lanzaAtaque(Personaje enemigo) {

        return getAtaque().lanzaAtaque(enemigo);
    }

    @Override
    public int getValorAtaque() {
        return getAtaque().getValorAtaque();
    }




}
