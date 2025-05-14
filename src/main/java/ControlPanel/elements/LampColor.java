// elements/LampColor.java
package ControlPanel.elements;

public enum LampColor {
    RED("к"), GREEN("з"), BLUE("с"), YELLOW("ж");

    private final String code;

    LampColor(String code) {
        this.code = code;
    }

    public String getCode() { return code; }
}