package lab2.pokemons;
import lab2.spells.HornAttack;
import lab2.spells.PoisonSting;
import lab2.spells.ShadowClaw;
import ru.ifmo.se.pokemon.*;

public class Pikachu extends Pokemon{
    public Pikachu (String name, int lvl){
        super(name,lvl);
        addType(Type.ELECTRIC);
        setStats(35,55,40,50,50,90);
        Move shadowClaw = new ShadowClaw();
        Move poisonSting = new PoisonSting();
        Move hornAttack = new HornAttack();
        addMove(hornAttack);
        addMove(shadowClaw);
        addMove(poisonSting);
    }
}
