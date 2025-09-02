package main.java.helper;

import main.java.objects.Composition;

import java.util.HashMap;
import java.util.Map;

public class LilypondFileReader {
    String lilyPondFile;
    Map<String, String> staffVariables;
    Integer lastMidi; // last resolved midi for \relative nearest calc
    boolean inGrace;

    private LilypondFileReader(String lilyPondFile) {
        this.lilyPondFile = lilyPondFile;

        this.staffVariables = new HashMap<>();
        this.lastMidi = null;
        this.inGrace = false;
    }

    public static Composition read(String lilyPondFile) {
        if(lilyPondFile == null || lilyPondFile.isEmpty()) {
            return null;
        }

        LilypondFileReader lilypondFileReader = new LilypondFileReader(lilyPondFile);
        return lilypondFileReader.readFile();
    }

    public Composition readFile() {
        readStaffVariables();
        if(!staffVariables.isEmpty())
            return readFileWithVariables();

        return null;
    }

    private Composition readFileWithVariables() {
        Composition composition = new Composition();

        
        for(String key : staffVariables.keySet()) {
            lilyPondFile.indexOf("\\" + key);
        }

        return composition;
    }

    private void readStaffVariables() {
        if(lilyPondFile.contains("= \\new Staff")) {
            String[] varSplit = lilyPondFile.split("= \\new Staff");

            for(int i = 0; i < varSplit.length; i++) {
                String[] words = varSplit[i].trim().split("\\s+");
                String variableName = words[words.length - 1];

                String content = varSplit[i + 1];
                int start = content.indexOf('{');
                if (start == -1) return null;

                int depth = 0;
                for (int contentIndex = start; contentIndex < content.length(); contentIndex++) {
                    char c = content.charAt(contentIndex);
                    if (c == '{') {
                        depth++;
                    } else if (c == '}') {
                        depth--;
                        if (depth == 0) {
                            staffVariables.put(variableName, content.substring(start + 1, contentIndex).trim());
                            break;
                        }
                    }
                }
            }
        }
    }
}
