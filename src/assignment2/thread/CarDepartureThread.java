package assignment2.thread;

import assignment2.service.CarService;

public class CarDepartureThread implements Runnable{

    private CarService carService;

    public CarDepartureThread(CarService carService) {
        this.carService = carService;
    }

    @Override
    public void run() {
        while (true) {
            carService.pickUpCar();
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
