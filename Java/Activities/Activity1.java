package activities;

public class Activity1 {
    public static  void main(String[] args) {
        Car obj = new Car();
        obj.make = 2022;
        obj.transmission = "automatic";
        obj.color = "Blue";

        obj.displayCharacteristics();
        obj.accelerate();
        obj.brake();
    }
}
