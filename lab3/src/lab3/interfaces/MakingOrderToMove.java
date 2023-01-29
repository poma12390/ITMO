package lab3.interfaces;

import lab3.essences.Mountain;
import lab3.essences.Person;
import lab3.exceptions.ProhibitedActionException;

public interface MakingOrderToMove {

    void makeOrderToMove(Person bum, Mountain mountain) throws ProhibitedActionException;
}
