package lab2.spells;

import ru.ifmo.se.pokemon.*;

public class Foresight extends StatusMove {
    public Foresight (){
        super(Type.NORMAL,0,0  );

    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        pokemon.setMod(Stat.EVASION, 0);
    }

    @Override
    protected boolean checkAccuracy(Pokemon pokemon, Pokemon pokemon1) {
        return true;
    }
    @Override
    protected String describe() {
        return "Foresight attack";
    }
}
