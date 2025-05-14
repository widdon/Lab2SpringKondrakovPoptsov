// elements/Lamp.java
package ControlPanel.elements;

public class Lamp extends PanelElement implements LampObserver {
    private boolean active;
    private LampColor color;

    public Lamp(int x, int y, LampColor color) {
        super(x, y);
        this.color = color;
    }

    @Override
    public void update(boolean isActive) {
        if (isActive) activate();
        else deactivate();
    }

    public void activate() { active = true; }
    public void deactivate() { active = false; }
    public LampColor getColor() { return color; }

    @Override
    public String getDisplay() {
        return active ? "Л_" + color.getCode() : "Л";
    }
}