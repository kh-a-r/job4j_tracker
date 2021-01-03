package ru.job4j.tracker;

public class Engineer extends Profession {

    private int sertificateLevel;

public boolean hasAccessToDangerousObjects() {
    return true;
}

public int getSertificateLevel() {
    return sertificateLevel;
}

}
