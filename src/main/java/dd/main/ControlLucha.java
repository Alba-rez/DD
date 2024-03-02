package dd.main;

import dd.core.*;

import java.util.Arrays;

public class ControlLucha {
 Personaje []ejercitoTroll;
 Personaje[]ejercitoCaballero;

    public ControlLucha(){
        crearEjercitoCaballeros();
        crearEjercitoTroll();


    }
 public void crearEjercitoCaballeros(){
    ejercitoCaballero=new Caballero[3];

    ejercitoCaballero[0]=  new Rey("Arturo");
     Ataque ataqueEspada1=new AtaqueEspada();
     ejercitoCaballero[0].setAtaque(ataqueEspada1);
     ejercitoCaballero[0].asignarAtaque();


    ejercitoCaballero[1]=new Caballero("Lancelot");
    Ataque ataqueEspada2=new AtaqueEspada();
    ejercitoCaballero[1].setAtaque(ataqueEspada2);
    ejercitoCaballero[1].asignarAtaque();

    ejercitoCaballero[2]=new Caballero("Percival");
     Ataque ataqueArco=new AtaqueArco();
    ejercitoCaballero[2].setAtaque(ataqueArco);
     ejercitoCaballero[2].asignarAtaque();

 }
    public void crearEjercitoTroll(){
        int numTrolls=(int)(Math.random()*10+2);
        ejercitoTroll=new Troll[numTrolls];
        for(int i=0;i<numTrolls;i++){
            Troll troll=new Troll("Troll "+(i+1));
            troll.setAtaque(escogerAtaqueAleatorio());
            ejercitoTroll[i]=troll; // añado las instancias de troll al array
        }
    }

    private Ataque escogerAtaqueAleatorio(){
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


    public void luchar(){
        System.out.println("Tal día como hoy, en una húmeda y fría mañana de finales de primavera,\n" +
                "la partida formada por: [[Rey Arturo], [Lancelot], [Percival]]\n" +
                "hallándose en los frondosos bosques del sitio de Deorham, se topó con una\n" +
                "patrulla de 3 de esas sanguinarias e inhumanas criaturas popularmente\n" +
                "conocidas como trolls.\n" +
                "De la batalla que aconteció, dejo aquí testimonio:");

        while(haySupervivientes(ejercitoTroll) && haySupervivientes(ejercitoCaballero)){
            for(Personaje caballero:ejercitoCaballero){
                if(caballero.getSalud()>0 && ejercitoTroll.length>0){
                    int indiceTroll= (int) (Math.random()*ejercitoTroll.length);
                    System.out.println(caballero + " lucha contra " + ejercitoTroll[indiceTroll]);


                    int[] resultados = caballero.ataca(ejercitoTroll[indiceTroll]);
                    for (int resultado : resultados) {
                        if(resultado > 0){
                            System.out.println(caballero.getAtaque().getNombre() + "(-" + resultado + ")");
                        }else{
                            System.out.println(caballero.getAtaque().getNombre() + " (falla)");
                        }
                    }

                    if(ejercitoTroll[indiceTroll].getSalud()<=0){
                        System.out.println(ejercitoTroll[indiceTroll] + " muere!");
                        ejercitoTroll= eliminarPersonaje(ejercitoTroll,indiceTroll);
                    }
                }
            }

            for(Personaje troll:ejercitoTroll){
                if(ejercitoCaballero.length>0) {
                    int indiceCaballero = (int) (Math.random() * ejercitoCaballero.length);
                    System.out.println(troll + " lucha contra " + ejercitoCaballero[indiceCaballero]);
                    if(troll.getAtaque().lanzaAtaque(ejercitoCaballero[indiceCaballero])>0){
                        System.out.println(troll.getAtaque().getNombre() + "(-" + troll.getAtaque().getValorAtaque() + ")");
                    }else{
                        System.out.println(troll.getAtaque().getNombre() + " (falla)");
                    }
                    if (ejercitoCaballero[indiceCaballero].getSalud() <= 0) {
                        System.out.println(ejercitoCaballero[indiceCaballero] + " muere!");
                        ejercitoCaballero = eliminarPersonaje(ejercitoCaballero, indiceCaballero);
                    }
                }
            }
        }
        System.out.println("Finalmente, el ejército del Rey Arturo venció!!!");
        System.out.println("Los supervivientes de la batalla fueron:");
        System.out.println(Arrays.toString(ejercitoCaballero));
    }

    public boolean haySupervivientes(Personaje[]ejercito){
        for(Personaje personaje:ejercito){
            if(personaje.getSalud()>0){
                return true;
            }
        }
        return false;
    }

    public Personaje[] eliminarPersonaje(Personaje[]ejercito, int indiceEjercito){
    Personaje[]nuevoEjercito=new Personaje[ejercito.length-1];
    for(int i=0,j=0;i<ejercito.length;i++){
        if(i!=indiceEjercito){
            nuevoEjercito[j++]=ejercito[i];
        }
    }
    return nuevoEjercito;
    }

    public Personaje[] getEjercitoTroll() {
        return ejercitoTroll;
    }

    public Personaje[] getEjercitoCaballero() {
        return ejercitoCaballero;
    }
}
