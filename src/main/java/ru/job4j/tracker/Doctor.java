package ru.job4j.tracker;

public class Doctor extends Profession {

    private String specialty;
    private int  salary;

    public String getSpecialty() {
        return specialty;
    }

    public boolean canDoSurgery() {
        return true;
    }

}
