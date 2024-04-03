package lab2;
import lab1.*;

public class CarFactory {

    public Car createCar(Car car, int x, int y){

        if (car instanceof Volvo240){
            return createVolvo240(x, y);
        }
        else if (car instanceof Saab95) {
            return createSaab95(x,y);
        }
        else if (car instanceof Scania){
            return createScania(x,y);
        }
        else if (car instanceof CarTransport){
            return createCarTransport(x,y);
        }
        else {
            return null; //Lägg till exeption
            //throw new RuntimeException("Bilfabriken har inte den modellen");
        }
    }

    private Volvo240 createVolvo240(int x, int y){
        Volvo240 volvo240 = new Volvo240();
        volvo240.setDirection(Direction.EAST);
        volvo240.setPos(x,y);
        Car vo = new Volvo240();
        return volvo240;
    }
    private Saab95 createSaab95(int x, int y){
        Saab95 saab95 = new Saab95();
        saab95.setPos(x,y);
        saab95.setDirection(Direction.EAST);
        return saab95;
    }
    private CarTransport createCarTransport(int x, int y){
        CarTransport ct = new CarTransport();
        ct.setPos(x,y);
        ct.setDirection(Direction.EAST);
        return ct;
    }

    private Scania createScania(int x, int y){
        Scania scania = new Scania();
        scania.setDirection(Direction.EAST);
        scania.setPos(x,y);
        return scania;
    }
}

