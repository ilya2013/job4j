package ru.job4j;

public class Doctor extends Profession {
    Diagnose heal(Pacient pacient) {
        return new Diagnose();
    }
}
