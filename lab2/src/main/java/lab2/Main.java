package lab2;

import lab2.pokemons.*;
import ru.ifmo.se.pokemon.Battle;
import ru.ifmo.se.pokemon.Pokemon;

public class Main {

    public static void main(String[] args) {
        Pokemon mesprit = new Mesprit("Mesprit", 1);
        Pokemon patrat = new Patrat("Patrat",1);
        Pokemon watchog = new Watchog("Watch",1);
        Pokemon arbok = new Arbok("arbok",1);
        Pokemon pikachu = new Pikachu("pikachu",1);
        Pokemon raichu = new Raichu("raichu",1);
        Battle b = new Battle();
        b.addFoe(pikachu);
        b.addFoe(raichu);
        b.addAlly(mesprit);
        b.addAlly(arbok);
        b.addFoe(patrat);
        b.addFoe(watchog);
        b.go();
    }
}


