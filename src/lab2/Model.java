package lab2;

import lab1.Car;
import lab1.CarTransport;
import lab1.Saab95;
import lab1.Scania;
import java.util.ArrayList;


public class Model {

    ArrayList<Car> cars = CarController.getCars();

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars){
            car.gas(gas);
        }
    }
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars){
            car.brake(brake);
        }
    }
    void saabTurboOn(){
        for (int i = 0; i < cars.size(); i++){
            if (cars.get(i) instanceof Saab95){
                ((Saab95) cars.get(i)).setTurboOn();
            }
        }
    }
    void saabTurboOff(){
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i) instanceof Saab95){
                ((Saab95) cars.get(i)).setTurboOff();
            }
        }
    }
    void stopEngineAll(){
        for (Car car : cars){
            car.stopEngine();
        }
    }
    void startEngineAll(){
        for (Car car : cars){
            car.startEngine();
        }
    }
    void liftAllBeds(){
        for (Car car : cars){
            if (car instanceof Scania){
                ((Scania) car).raiseTruckBed(70);
            }
            if (car instanceof CarTransport){
                ((CarTransport) car).raiseTruckBed(70);
            }
        }
    }
    void lowerAllBeds(){
        for (Car car : cars){
            if (car instanceof Scania){
                ((Scania) car).lowerTruckBed(70);
            }
            if (car instanceof CarTransport){
                ((CarTransport) car).lowerTruckBed(70);
            }
        }
    }
}