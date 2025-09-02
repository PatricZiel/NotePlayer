package main.java.objects;

import lombok.Data;
import main.java.enums.KeyName;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

@Data
public class Key {
    private final KeyName keyName;

    private boolean pressed;

    private Clip clip;

    private int width;
    private int height;

    private int x;

    public Key(KeyName keyName) {
        this.keyName = keyName;
        this.pressed = false;

        loadClip();
    }

    public void changeSize(int height, int width) {
        this.height = height;
        this.width = width;

        if (getKeyName().isBlack()) {
            this.height *= 3;
            this.height  >>= 2;

            this.width *= 3;
            this.width  >>= 2;
        }
    }

    public void press() {
        this.pressed = true;
        if (clip != null) {
            if (clip.isRunning()) {
                clip.stop();
            }
            clip.setFramePosition(0); // set to beginning
            clip.start();
        }
    }

    public void release() {
        this.pressed = false;
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

    private void loadClip() {
        String fileName = "/piano_sounds/" + this.keyName.name() + ".wav";
        try {
            URL resource = getClass().getResource(fileName);
            if (resource == null) {
                throw new IllegalArgumentException("Audio file not found: " + fileName);
            }

            AudioInputStream ais = AudioSystem.getAudioInputStream(resource);
            this.clip = AudioSystem.getClip();
            this.clip.open(ais);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException("Could not load audio: " + fileName, e);
        }
    }
}
