package lab2.spells;
import ru.ifmo.se.pokemon.*;
import ru.ifmo.se.pokemon.PhysicalMove;

import javax.swing.text.EditorKit;


public class Thunderbolt extends SpecialMove {
    public Thunderbolt() {
        super(Type.ELECTRIC, 90, 100);
    }

    @Override
    protected String describe() {
        return "thunderbolt attack";
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        Effect par = (new Effect()).condition(Status.PARALYZE).chance(0.1).turns(1);
        pokemon.addEffect(par);

    }
}
