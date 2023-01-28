package lab2.spells;
import ru.ifmo.se.pokemon.*;

public class Confide extends StatusMove {
    public Confide(){
        super(Type.NORMAL,0,100);

    }
    @Override
    protected boolean checkAccuracy(Pokemon pokemon, Pokemon pokemon1) {
        return true;
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        Effect allstat = new Effect().turns(1).stat(Stat.SPECIAL_ATTACK,-6);
        pokemon.addEffect(allstat);
    }
    @Override
    protected String describe() {
        return "Confide";
    }
}
