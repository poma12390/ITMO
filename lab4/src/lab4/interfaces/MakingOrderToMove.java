package lab4.interfaces;

import lab4.essences.Mountain;
import lab4.essences.Person;
import lab4.exceptions.ProhibitedActionException;

public interface MakingOrderToMove {

    void makeOrderToMove(Person bum, Mountain mountain) throws ProhibitedActionException;
}
