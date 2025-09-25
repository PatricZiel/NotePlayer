package main.java.objects;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Composition {
    List<Note> notes = new ArrayList<>();
    boolean inRelative = false;
    private int relativeAnchorMidi = 60;
    String header;
}
