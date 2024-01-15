package assignment2.thread;

import assignment2.service.CarService;

public class CarArrivalThread implements Runnable {
    private CarService carService;

    public CarArrivalThread(CarService carService) {
        this.carService = carService;
    }

    @Override
    public void run() {
        while (true) {
            carService.addCar();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
