package main.java.enums;

import lombok.Getter;

@Getter
public enum KeyName {
    A0(21, false),
    Bb0(22, true),
    B0(23, false),
    C1(24, false),
    Db1(25, true),
    D1(26, false),
    Eb1(27, true),
    E1(28, false),
    F1(29, false),
    Gb1(30, true),
    G1(31, false),
    Ab1(32, true),
    A1(33, false),
    Bb1(34, true),
    B1(35, false),
    C2(36, false),
    Db2(37, true),
    D2(38, false),
    Eb2(39, true),
    E2(40, false),
    F2(41, false),
    Gb2(42, true),
    G2(43, false),
    Ab2(44, true),
    A2(45, false),
    Bb2(46, true),
    B2(47, false),
    C3(48, false),
    Db3(49, true),
    D3(50, false),
    Eb3(51, true),
    E3(52, false),
    F3(53, false),
    Gb3(54, true),
    G3(55, false),
    Ab3(56, true),
    A3(57, false),
    Bb3(58, true),
    B3(59, false),
    C4(60, false),
    Db4(61, true),
    D4(62, false),
    Eb4(63, true),
    E4(64, false),
    F4(65, false),
    Gb4(66, true),
    G4(67, false),
    Ab4(68, true),
    A4(69, false),
    Bb4(70, true),
    B4(71, false),
    C5(72, false),
    Db5(73, true),
    D5(74, false),
    Eb5(75, true),
    E5(76, false),
    F5(77, false),
    Gb5(78, true),
    G5(79, false),
    Ab5(80, true),
    A5(81, false),
    Bb5(82, true),
    B5(83, false),
    C6(84, false),
    Db6(85, true),
    D6(86, false),
    Eb6(87, true),
    E6(88, false),
    F6(89, false),
    Gb6(90, true),
    G6(91, false),
    Ab6(92, true),
    A6(93, false),
    Bb6(94, true),
    B6(95, false),
    C7(96, false),
    Db7(97, true),
    D7(98, false),
    Eb7(99, true),
    E7(100, false),
    F7(101, false),
    Gb7(102, true),
    G7(103, false),
    Ab7(104, true),
    A7(105, false),
    Bb7(106, true),
    B7(107, false),
    C8(108, false);

    private final int midiNumber;
    private final boolean black;

    KeyName(int midiNumber, boolean black) {
        this.midiNumber = midiNumber;
        this.black = black;
    }

    public static KeyName fromMidi(int midiNumber) {
        for (KeyName key : values()) {
            if (key.midiNumber == midiNumber) {
                return key;
            }
        }
        throw new IllegalArgumentException("Ungültige MIDI-Nummer: " + midiNumber);
    }
}
