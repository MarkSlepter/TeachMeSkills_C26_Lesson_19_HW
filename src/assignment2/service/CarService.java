package assignment2.service;

public class CarService {

    private static final int MAX_CAPACITY = 5;
    private int currentCapacity = 0;

    public synchronized void addCar() {
        while (currentCapacity >= MAX_CAPACITY) {
            try {
                System.out.println("Machines undergoing maintenance have reached their maximum value. Waiting...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        currentCapacity++;
        System.out.println("The car has been added for service. current amount: " + currentCapacity);

        notify();
    }

    public synchronized void pickUpCar() {
        while (currentCapacity == 0) {
            try {
                System.out.println("There are no pick-up machines. Waiting...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        currentCapacity--;
        System.out.println("The car has been taken out of service. current amount: " + currentCapacity);

        notify();
    }

}
