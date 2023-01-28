package lab2.spells;
import ru.ifmo.se.pokemon.*;


public class SandAttack extends StatusMove {

    public SandAttack() {
        super(Type.GROUND, 0, 100);

    }
    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        Effect acc = new Effect().chance(1).turns(1).stat(Stat.ACCURACY, -6);
        pokemon.addEffect(acc);
    }

    @Override
    protected String describe() {
        return "SandAttack";
    }

    @Override
    protected boolean checkAccuracy(Pokemon pokemon, Pokemon pokemon1) {
        return true;
    }
}