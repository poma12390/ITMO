package lab3.interfaces;

import lab3.enums.Equipment;
import lab3.essences.Person;
import lab3.exceptions.ProhibitedActionException;

public interface MakingOrderToTake {

    void makeOrderToTake(Person bum, Equipment equipment) throws ProhibitedActionException;

}
