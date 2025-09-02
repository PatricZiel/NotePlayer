package main.java.objects;

import main.java.enums.KeyName;
import lombok.Data;

import java.util.*;

@Data
public class Piano {
    private final List<Key> keys = new ArrayList<>();

    private int width;
    private int height;

    public Piano() {
        for(int i = 21; i <= 108; i++) {
            Key key = new Key(KeyName.fromMidi(i));
            this.keys.add(key);
        }
    }

    public void changeSize(int height, int width) {
        this.height = height;
        this.width = width;

        int keyWidth = width / 52;
        for(Key key : this.keys) {
            key.changeSize(this.height, keyWidth);
        }
    }
}
