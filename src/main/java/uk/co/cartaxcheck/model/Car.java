package uk.co.cartaxcheck.model;

public class Car {
    private String registrationNumber;
    private String make;
    private String model;
    private String colour;
    private String year;

    public Car(String registrationNumber, String make, String model, String colour, String year) {
        this.registrationNumber = registrationNumber;
        this.make = make;
        this.model = model;
        this.colour = colour;
        this.year = year;
    }

    public String toString() {
        return String.format("%s,%s,%s,%s,%s", this.registrationNumber, this.make, this.model, this.colour, this.year);
    }
}
