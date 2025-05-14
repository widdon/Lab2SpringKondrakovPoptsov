// ControlPanelApplication.java
package ControlPanel;

import ControlPanel.controllers.PanelController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ControlPanelApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ControlPanelApplication.class, args);
        PanelController panelController = context.getBean(PanelController.class);
        panelController.start();  // Запуск вручную
    }
}