package assignment2;

import assignment2.service.CarService;
import assignment2.thread.CarArrivalThread;
import assignment2.thread.CarDepartureThread;

public class Runner {

    public static void main(String[] args) {

        CarService carService = new CarService();

        Thread arrivalThread = new Thread(new CarArrivalThread(carService));
        arrivalThread.start();

        Thread departureThread = new Thread(new CarDepartureThread(carService));
        departureThread.start();

    }

}
