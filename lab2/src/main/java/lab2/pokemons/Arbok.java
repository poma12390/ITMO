package lab2.pokemons;

import lab2.spells.PoisonSting;
import lab2.spells.ShadowClaw;
import ru.ifmo.se.pokemon.*;

public class Arbok extends Pokemon{
    public Arbok(String name, int lvl){
        super(name,lvl);
        addType(Type.POISON);
        setStats(60,95,69,65,79,80);
        Move shadowClaw = new ShadowClaw();
        Move poisonSting = new PoisonSting();
        addMove(shadowClaw);
        addMove(poisonSting);
    }
}
