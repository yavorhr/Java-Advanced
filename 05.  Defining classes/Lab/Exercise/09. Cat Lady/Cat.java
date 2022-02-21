package Pockemon;

public class Cat {
    private String name;
    private double specialChar;

    public Cat(String name, double specialChar) {
        this.name = name;
        this.specialChar = specialChar;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", this.name, this.specialChar);
    }
}
