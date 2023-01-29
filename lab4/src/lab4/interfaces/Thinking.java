package lab4.interfaces;

import lab4.exceptions.ProhibitedActionException;

public interface Thinking {
    void think(String action) throws ProhibitedActionException;
}
