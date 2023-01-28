package lab2.spells;
import ru.ifmo.se.pokemon.*;

public class PoisonSting extends PhysicalMove {

    public PoisonSting() {
        super(Type.POISON,15,100);
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        Effect poison = new Effect().chance(0.3).condition(Status.POISON);
        pokemon.addEffect(poison);
    }
    @Override
    protected String describe() {
        return "PoisonSting";
    }
}
