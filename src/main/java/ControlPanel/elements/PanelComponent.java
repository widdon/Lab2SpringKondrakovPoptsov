// elements/PanelComponent.java
package ControlPanel.elements;

import java.util.ArrayList;
import java.util.List;

public class PanelComponent extends PanelElement {
    private List<PanelElement> children = new ArrayList<>();

    public PanelComponent(int x, int y) {
        super(x, y);
    }

    public void add(PanelElement element) {
        children.add(element);
    }

    @Override
    public String getDisplay() {
        StringBuilder sb = new StringBuilder("[");
        for (PanelElement child : children) {
            sb.append(child.getDisplay()).append(" ");
        }
        return sb.append("]").toString();
    }
}