package activities;

public class Car {
    String color;
    String transmission;
    int make;
    int tyres;
    int doors;

    Car() {
        tyres = 4;
        doors = 4;
    }
   public void displayCharacteristics(){
       System.out.println("Car Color: " + color);
       System.out.println("Make of the Car: " + make);
       System.out.println("Car transmission: " + transmission);
       System.out.println("Number of doors: " + doors);
       System.out.println("Number of tyres: " + tyres);
    }
   public void accelerate(){
        System.out.println("Car is Moving");
   }
    public void brake() {
        System.out.println("Car has stopped");
    }
}
