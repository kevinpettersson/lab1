package lab1;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

public abstract class Car implements Movable {
    private final int nrDoors;              //Number of door will never change for a specific car
    private Color color;                    //Color can change as well
    private final String modelName;         //Volvo240 will always be a Volvo240
    private final VehicleType type;         //Defines the Vehicle type.
    protected Transform transform;          //Handles all our
    protected GPS Gps;

    public Car(int nrDoors, double enginePower, Color color, String modelName, VehicleType type) {

        this.nrDoors = nrDoors;
        this.color = color;
        this.modelName = modelName;
        this.type = type;
        this.transform = new Transform(enginePower);
        this.Gps = new GPS();

    }

    // ---- MOVE ---- \\
    public void move() {
        this.transform.move(this);
    }
    public void turnLeft(){
        this.transform.turnLeft(this);
    }
    public void turnRight(){
        this.transform.turnRight(this);
    }

    public void brake(double amount){
        this.transform.brake(amount);
    }
    public void gas(double amount){
        this.transform.gas(amount);
    }

    // ---- GETTERS ---- \\
    public Point getPoint(Car car){
        return car.Gps.position.getPoint(car);
    }
    public double getY(){
        return this.Gps.position.getY();
    }
    public double getX(){
        return this.Gps.position.getX();
    }
    public VehicleType getVehicleType(){
        return this.type;
    }
    public Direction getDirection() { return this.Gps.direction; }
    public String getModelName(){
        return this.modelName;
    }
    public int getNrDoors(){
        return this.nrDoors;
    }
    public Color getColor(){
        return this.color;
    }
    public double getEnginepower(){
        return this.transform.getEnginepower();
    }

    public double getCurrentSpeed(){
        return this.transform.currentSpeed;
    }
    public double getSpeedFactor(){
        return this.transform.speedFactor();
    }
    public double getPosX() {
        return this.Gps.position.x;
    }
    public double getPosY() {
        return this.Gps.position.y;
    }

    // ---- SETTERS ---- \\
    public void setDirection(Direction dir){
        this.Gps.direction = dir;
    }
    public void setPos(double nx, double ny){
        this.Gps.position.setPos(nx,ny);
    }
    public void setX(double amount){
        this.Gps.position.setX(amount);
    }
    public void setY(double amount){
        this.Gps.position.setY(amount);
    }
    public void startEngine() {
        this.transform.startEngine();
    }
    public void stopEngine(){
        this.transform.stopEngine();
    }
    public void setColor(Color clr){
        this.color = clr;
    }
    public void setCurrentSpeed(double value){
        this.transform.currentSpeed = value;
    }
    public void setGas(double value){
        this.transform.gas(value);
    }
    public void setBrake(double value){
        this.transform.brake(value);
    }
}
