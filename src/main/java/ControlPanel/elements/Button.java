// Button.java
package ControlPanel.elements;

import java.util.ArrayList;
import java.util.List;

public class Button extends PanelElement {
    private boolean pressed;
    private final List<LampObserver> observers = new ArrayList<>();

    public Button(int x, int y) {
        super(x, y);
    }

    public void press() {
        pressed = true;
        notifyObservers(true);
    }

    public void addObserver(LampObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers(boolean state) {
        observers.forEach(observer -> observer.update(state));
    }

    @Override
    public String getDisplay() {
        return pressed ? "o" : "O";
    }
}