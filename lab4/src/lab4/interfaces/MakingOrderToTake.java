package lab4.interfaces;

import lab4.essences.Person;
import lab4.exceptions.ProhibitedActionException;
import lab4.enums.Equipment;

public interface MakingOrderToTake {

    void makeOrderToTake(Person bum, Equipment equipment) throws ProhibitedActionException;

}
