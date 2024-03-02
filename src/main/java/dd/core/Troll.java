package dd.core;

import dd.main.ControlLucha;

public class Troll extends Personaje implements Ataque{
    private int salud;
    public Troll(String nombre) {
        super(nombre);
        setSalud(1000);
       setAtaque(ataqueAleatorio());
    }

    @Override
    public int[] ataca(Personaje enemigo) {
        int []resultados=new int[3];
        for(int i=0;i<3;i++){
            resultados[i] = getAtaque().lanzaAtaque(enemigo);
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

    @Override
    public Ataque crearAtaque() {
        return getAtaque();
    }

    public Ataque ataqueAleatorio(){
        int tipoAtaque=(int)(Math.random()*3);
        switch(tipoAtaque){
            case 0:
                return new AtaqueArco();

            case 1:
                return new AtaqueEspada();

            case 2:
                return new AtaqueCuchillo();

            default:
                return new AtaqueCuchillo();
        }
    }
}
