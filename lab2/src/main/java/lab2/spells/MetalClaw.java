package lab2.spells;
import ru.ifmo.se.pokemon.*;


public class MetalClaw extends PhysicalMove {
    public MetalClaw(){
        super(Type.PSYCHIC,50,95);
    }

    @Override
    protected void applySelfEffects(Pokemon pokemon) {
        Effect att = new Effect().chance(0.1).turns(1).stat(Stat.ATTACK, 6);
        pokemon.addEffect(att);
    }
    @Override
    protected String describe() {
        return "metal_claw attack";
    }
}
