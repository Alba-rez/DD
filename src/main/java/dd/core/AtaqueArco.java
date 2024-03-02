package dd.core;

 public class AtaqueArco implements Ataque {
     int acierta;
     double factor;
     final int ATAQUE=50;

     private int ataqueTotal;
    @Override
    public int lanzaAtaque(Personaje enemigo) {
        acierta= (int) (Math.random()*2);
        factor=Math.random()*2;
        ataqueTotal=(int) (ATAQUE*factor*acierta);
        if (acierta > 0) {
            enemigo.reducirSalud(ataqueTotal);
        }
        return ataqueTotal;
    }

     @Override
     public String getNombre() {
         return "Ataque Arco";
     }


     public int getValorAtaque() {
         return ataqueTotal;
     }

     @Override
     public Ataque crearAtaque() {
         return new AtaqueArco();
     }

     public void setValorAtaque(int valorAtaque){
        this.ataqueTotal=valorAtaque;
     }

     @Override
     public String toString() {
         return getNombre();
     }
     int getAtaque(){
        return ATAQUE;
    }




 }
