package lab2.pokemons;
import lab2.spells.Foresight;
import lab2.spells.MilkDrink;
import lab2.spells.SandAttack;
import ru.ifmo.se.pokemon.*;


public class Patrat extends Pokemon{
    public Patrat (String name, int lvl){
        super(name, lvl);
        addType(Type.NORMAL);
        setStats(45,55,39,35,39,42);;
        Move sandAttack = new SandAttack();
        Move foresight = new Foresight();
        Move milkdrink = new MilkDrink();
        addMove(milkdrink);
        addMove(sandAttack);
        addMove(foresight);

    }
}
