package main.java.objects;

import lombok.Data;

@Data
public class Note {
    private Key key;
    private int startTimeMs;
    private int lengthMs;
}
