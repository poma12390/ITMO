package lab2.spells;
import ru.ifmo.se.pokemon.*;

public class MilkDrink extends StatusMove{
    public MilkDrink(){
        super(Type.NORMAL,0,0);
    }

    @Override
    protected boolean checkAccuracy(Pokemon pokemon, Pokemon pokemon1) {
        return true;
    }

    @Override
    protected void applySelfEffects(Pokemon pokemon) {
        Effect heal = new Effect();
        heal.stat(Stat.HP, (int)pokemon.getStat(Stat.HP)+(int) pokemon.getStat(Stat.HP)/2);
        pokemon.setCondition(heal);
    }
    @Override
    protected String describe() {
        return "MilkDrink";
    }
}
