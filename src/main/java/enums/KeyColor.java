package main.java.enums;

import lombok.Getter;

@Getter
public enum KeyColor {
    WHITE(1),
    BLACK(2);

    private final int colorCode;

    KeyColor(int colorCode) {
        this.colorCode = colorCode;
    }

    public static KeyColor fromColorCode(int colorCode) {
        for (KeyColor key : values()) {
            if (key.colorCode == colorCode) {
                return key;
            }
        }
        throw new IllegalArgumentException("Ungültiger Color-Code: " + colorCode);
    }
}
