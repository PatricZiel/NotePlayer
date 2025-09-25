package main.java.helper;

import lombok.Data;
import main.java.objects.Composition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class LilypondFileReaderSecond {
    Composition composition = new Composition();
    String lilypondFile;

    Map<String, String> staffVariables;
    Integer lastMidi; // last resolved midi for \relative nearest calc
    boolean inGrace = false; // if reader currently is inside "<<" and ">>"
    boolean inBrackets = false; // if reader currently is inside "{" and "}"

    int readerIndex = 0;
    List<String> wordBuffer = new ArrayList<>();

    String currentWord = "";
    String lastWord = "";

    public LilypondFileReaderSecond(String lilypondFile) {
        setLilypondFile(lilypondFile);
    }

    public Composition readFile() {
        while(getReaderIndex() < getLilypondFile().length()) {
            readNext();

            if (!getWordBuffer().isEmpty()) {
                setCurrentWord(String.valueOf(getWordBuffer()));
                if (getCurrentWord().startsWith("\\")) {
                    checkHeader();
                }
                setLastWord(getCurrentWord());
            }

            setReaderIndex();
        }

        return getComposition();
    }

    private void readNext() {
        setLastWord(getCurrentWord());
        skipSpaces();

        int wordEndIndex = getReaderIndex();
        while (getLilypondFile().charAt(wordEndIndex) != ' ') {
            wordEndIndex++;
        }
        setCurrentWord(getLilypondFile().substring(getReaderIndex(), wordEndIndex));

        setReaderIndex(wordEndIndex);
    }

    private void checkHeader() {
        if (getCurrentWord().contains("header")) {

        }
    }

    private void checkGrace() {
        if (getCurrentWord().equals("<<")) {
            setInGrace(true);
        } else if (getCurrentWord().equals(">>")) {
            setInGrace(false);
        }
    }

    private void checkBrackets() {
        if (getCurrentWord().equals("{")) {
            setInBrackets(true);
        } else if (getCurrentWord().equals("}")) {
            setInBrackets(false);
        }
    }

    private void skipSpaces() {
        while (getLilypondFile().charAt(getReaderIndex()) == ' ') {
            setReaderIndex();
        }
    }

    private void setReaderIndex() {
        this.readerIndex++;
    }
}
