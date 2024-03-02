package dd.core;

public interface Ataque {

    int lanzaAtaque(Personaje enemigo);
    String getNombre();
    int getValorAtaque();

    Ataque crearAtaque();


}
