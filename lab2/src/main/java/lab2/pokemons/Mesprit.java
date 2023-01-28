package lab2.pokemons;


import lab2.spells.MetalClaw;
import lab2.spells.Mist_ball;
import lab2.spells.Thunder;
import lab2.spells.Thunderbolt;
import ru.ifmo.se.pokemon.*;

public class Mesprit extends Pokemon {
    public Mesprit(String name, int lvl) {
        super(name, lvl);
        addType(Type.PSYCHIC);
        setStats(80, 105, 105, 105, 105, 80);
        Move thunderbolt = new Thunderbolt();
        Move metal_claw = new MetalClaw();
        Move thunder = new Thunder();
        Move mist_ball = new Mist_ball();
        addMove(thunder);
        addMove(thunderbolt);
        addMove(mist_ball);
        addMove(metal_claw);
    }

}


