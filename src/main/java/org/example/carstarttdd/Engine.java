package org.example.carstarttdd;

public class Engine {

    public boolean isStart(Key key) {

        boolean isValid = key.isValid(key);
        boolean isInserted = key.isInserted(key);

        if (isValid && isInserted) {
            return true;
        } else {
            return false;
        }
    }
}
