// elements/PanelElement.java
package ControlPanel.elements;

public abstract class PanelElement {
    protected int x;
    protected int y;

    public PanelElement(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract String getDisplay();

    public int getX() { return x; }
    public int getY() { return y; }
}