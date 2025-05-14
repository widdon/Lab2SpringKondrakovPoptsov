// factories/ElementFactory.java
package ControlPanel.factories;

import ControlPanel.elements.PanelElement;

public interface ElementFactory {
    PanelElement createElement(int x, int y);
}