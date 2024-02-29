package lab2;

import lab1.*;
import java.util.ArrayList;
import java.util.Random;

public class Model implements Observer {
    public ArrayList<Car> cars;
    private final Workshop<Volvo240> volvo240Workshop;
    private final CarFactory carFactory;

    public Model() {
        this.cars = new ArrayList<Car>();
        this.volvo240Workshop = new Workshop<Volvo240>(10, new Point(300,300));
        this.carFactory = new CarFactory();
        initiateCars(cars);
    }

    public Workshop<Volvo240> getWorkshop(){
        return this.volvo240Workshop;
    }

    public void update(int x) {
        switch(x){
            case 1:
                adjustCarPosition();
                break;
            case 2:
                ifCarCollideWithWorkshop();
                break;
            case 3:
                handleCollition();
                break;
        }
    }

    public ArrayList<Car> getCars(){
        return this.cars;
    }

    public void initiateCars(ArrayList<Car> cars){
        cars.add(carFactory.createCar(new Saab95(),0,100 ));
        cars.add(carFactory.createCar(new Scania(), 0, 200));
        cars.add(carFactory.createCar(new Volvo240(), 0, 300));
    }
    public void addCar(){
        Random rand = new Random();
        Car[] cars1 = {new Volvo240(), new Saab95(), new Scania()};

        if (cars.size() + 1 <= 10){
            int index = rand.nextInt(0, cars1.length);
            cars.add(carFactory.createCar(cars1[index], 0, 0));
        }
    }
    public void removeCar() {
        if (!cars.isEmpty()) {
            cars.remove(0); 
        }
    }

    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars){
            car.gas(gas);
        }
    }
    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars){
            car.brake(brake);
        }
    }
    public void saabTurboOn(){
        for (int i = 0; i < cars.size(); i++){
            if (cars.get(i) instanceof Saab95){
                ((Saab95) cars.get(i)).setTurboOn();
            }
        }
    }
    public void saabTurboOff(){
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i) instanceof Saab95){
                ((Saab95) cars.get(i)).setTurboOff();
            }
        }
    }
    public void stopEngineAll(){
        for (Car car : cars){
            car.stopEngine();
        }
    }
    public void startEngineAll(){
        for (Car car : cars){
            car.startEngine();
        }
    }
    public void liftAllBeds(){
        for (Car car : cars){
            if (car instanceof Scania){
                ((Scania) car).raiseTruckBed(70);
            }
            if (car instanceof CarTransport){
                ((CarTransport) car).raiseTruckBed(70);
            }
        }
    }
    public void lowerAllBeds(){
        for (Car car : cars){
            if (car instanceof Scania){
                ((Scania) car).lowerTruckBed(70);
            }
            if (car instanceof CarTransport){
                ((CarTransport) car).lowerTruckBed(70);
            }
        }
    }
    public void moveit (int x, int y, Car car) {
        car.setX(x);
        car.setY(y);
    }
    //When the "behind" vehicle collides with the vehicle in front, the approaching vehicle will "crash" and move
    public void handleCollition(){
        for (int i = 0; i < cars.size()-1; i++) {
            for (int j = i+1; j < cars.size(); j++) {
                Car car1 = cars.get(i);
                Car car2 = cars.get(j);
                if (collition(car1, car2)){
                    car1.setPos(car1.getX() + 2, car1.getY() + 2);
                    car1.stopEngine();
                    car2.stopEngine();
                }
            }
        }
    }
    //Checks potential collition between two cars. Returns a boolean.
    //Rewritten with a hasPosition interface as typearguments. To generalize the method.
    public boolean collition(hasPosition objA, hasPosition objB) {
        if (objA.getY() < (objB.getY() + 60) && (objA.getY() > (objB.getY() - 60))){
            if (objA.getX() > (objB.getX() - 100) && (objA.getX() < (objB.getX() + 100))){
                return true;
            }
        }
        return false;
    }
    // If the car collides with the workshop then we remove the car from the list and adds the car to the workshop.
    public void ifCarCollideWithWorkshop(){
        Volvo240 volvo = new Volvo240();
        for (Car car : cars) {
            if (car instanceof Volvo240) {
                volvo = (Volvo240) car;
            }
        }
        if (collition(volvo, volvo240Workshop)) {
            cars.remove(volvo);
            volvo240Workshop.leaveVehicle(volvo);
        }
    }

    // Checks so the car is within bounds of the frame. If not we stop the car, turn it 180 degress.
    // Sets a new position that is within bounds.
    public void adjustCarPosition() {
        for (Car car : cars) {
            int cX = (int) Math.round(car.getX());
            int cY = (int) Math.round(car.getY());
            if (cY <= -1 || cY >= 501) {
                car.stopEngine();
                car.turnLeft();
                car.turnLeft();
                car.setY(cY >= 500 ? 500 - 2 : 2);
            }

            if (cX <= -1 || cX >= 701) {
                car.stopEngine();
                car.turnLeft();
                car.turnLeft();
                car.setX(cX <= 0 ? 2 : 700 - 2);
            }
        }
    }
}