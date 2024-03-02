package dd.main;

import dd.core.AtaqueArco;
import dd.core.AtaqueEspada;
import dd.core.Personaje;
import dd.core.Rey;
import dd.core.Troll;

class ControlBasico{
    public static void main(String[] args) {
        ControlLucha control = new ControlLucha();
        for (Personaje personaje : control.getEjercitoCaballero()) {
            if (personaje instanceof Rey) {
                personaje.setAtaque(new AtaqueEspada());
            } else {
                personaje.setAtaque(new AtaqueArco());
            }
        }

        for (Personaje personaje : control.getEjercitoTroll()) {
            personaje.setAtaque(new AtaqueEspada());
        }

        control.luchar();
    }
}