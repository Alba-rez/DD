package dd.core;

public class AtaqueEspada implements Ataque{
    Personaje enemigo;
    int acierta;
    double factor;
    final int ATAQUE=100;

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
        return "Ataque Espada";
    }

    @Override
    public int getValorAtaque() {
        return ataqueTotal;
    }

    @Override
    public Ataque crearAtaque() {
        return new AtaqueEspada();
    }

    @Override
    public String toString() {
        return getNombre();
    }
    int getAtaque(){
        return ATAQUE;
    }

    public int getAtaqueTotal() {
        return ataqueTotal;
    }

    public void setAtaqueTotal(int ataqueTotal) {
        this.ataqueTotal = ataqueTotal;
    }
}



