// elements/PanelIterator.java
package ControlPanel.elements;

import java.util.Iterator;

public class PanelIterator implements Iterator<PanelElement> {
    private final PanelElement[][] panel;
    private int row = 0;
    private int col = 0;

    public PanelIterator(PanelElement[][] panel) {
        this.panel = panel;
    }

    @Override
    public boolean hasNext() {
        return row < panel.length && col < panel[0].length;
    }

    @Override
    public PanelElement next() {
        PanelElement element = panel[row][col++];
        if (col >= panel[0].length) {
            col = 0;
            row++;
        }
        return element;
    }
}