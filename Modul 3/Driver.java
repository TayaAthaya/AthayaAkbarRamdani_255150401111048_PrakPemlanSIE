public class Driver {
    private Car car;

    public Driver() {
        System.out.println("Driver is created.");
        this.car = new Car();
    }

    public void driving() {
        System.out.println("Driver is driving.");
        System.out.println("Using a car that has " + car.numWheel + " wheels.");
    }
}