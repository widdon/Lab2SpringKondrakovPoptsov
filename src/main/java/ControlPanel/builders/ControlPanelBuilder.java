// ControlPanelBuilder.java
package ControlPanel.builders;

import ControlPanel.elements.*;
import ControlPanel.factories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Random;

@Component
public class ControlPanelBuilder {
    private final Random random = new Random();
    private final ButtonFactory buttonFactory;
    private final LampFactory lampFactory;
    private int width;
    private int height;

    @Autowired
    public ControlPanelBuilder(ButtonFactory buttonFactory, LampFactory lampFactory) {
        this.buttonFactory = buttonFactory;
        this.lampFactory = lampFactory;
    }

    public ControlPanelBuilder setSize(int width, int height) {
        this.width = width;
        this.height = height;
        return this;
    }

    public PanelElement[][] build() {
        PanelElement[][] panel = new PanelElement[height][width];
        createElements(panel);
        setupConnections(panel);
        return panel;
    }

    private void createElements(PanelElement[][] panel) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                panel[y][x] = random.nextBoolean()
                        ? buttonFactory.createElement(x, y)
                        : new LampProxy((Lamp) lampFactory.createElement(x, y));
            }
        }
    }

    private void setupConnections(PanelElement[][] panel) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (panel[y][x] instanceof Button) {
                    connectButton((Button) panel[y][x], panel);
                }
            }
        }
    }

    private void connectButton(Button button, PanelElement[][] panel) {
        int lampsCount = random.nextInt(3) + 1;
        for (int i = 0; i < lampsCount; i++) {
            int lampX, lampY;
            do {
                lampX = random.nextInt(width);
                lampY = random.nextInt(height);
            } while (!(panel[lampY][lampX] instanceof LampProxy));

            button.addObserver((LampProxy) panel[lampY][lampX]);
        }
    }
}