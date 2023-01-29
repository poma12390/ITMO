package lab3.interfaces;

import lab3.exceptions.ProhibitedActionException;

public interface Thinking {
    void think(String action) throws ProhibitedActionException;
}
