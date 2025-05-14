// factories/ButtonFactory.java
package ControlPanel.factories;

import ControlPanel.elements.Button;
import ControlPanel.elements.PanelElement;
import org.springframework.stereotype.Component;

@Component
public class ButtonFactory implements ElementFactory {
    @Override
    public PanelElement createElement(int x, int y) {
        return new Button(x, y);
    }
}