// PanelController.java
package ControlPanel.controllers;

import ControlPanel.builders.ControlPanelBuilder;
import ControlPanel.elements.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Scanner;

@Component
public class PanelController {
    private final ControlPanelBuilder builder;

    @Autowired
    public PanelController(ControlPanelBuilder builder) {
        this.builder = builder;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размеры панели (ширина высота):");
        PanelElement[][] panel = builder.setSize(
                scanner.nextInt(),
                scanner.nextInt()
        ).build();

        printPanel(panel);

        while (true) {
            System.out.println("\nВведите координаты кнопки (x y) или -1 для выхода:");
            int x = scanner.nextInt();
            if (x == -1) break;
            int y = scanner.nextInt();

            if (isValidCoordinate(panel, x, y)) {
                handleInput(panel, x, y);
                printPanel(panel);
            } else {
                System.out.println("Неверные координаты!");
            }
        }
        scanner.close();
    }

    private void handleInput(PanelElement[][] panel, int x, int y) {
        PanelElement element = panel[y][x];
        if (element instanceof Button) {
            ((Button) element).press();
        } else {
            System.out.println("Это не кнопка! Элемент: " + element.getDisplay());
        }
    }

    private void printPanel(PanelElement[][] panel) {
        System.out.println("\nТекущая панель:");
        for (PanelElement[] row : panel) {
            for (int i = 0; i < row.length; i++) {
                System.out.print(row[i].getDisplay());
                if (i < row.length - 1) System.out.print(" - ");
            }
            System.out.println();
        }
    }

    private boolean isValidCoordinate(PanelElement[][] panel, int x, int y) {
        return y >= 0 && y < panel.length && x >= 0 && x < panel[y].length;
    }
}