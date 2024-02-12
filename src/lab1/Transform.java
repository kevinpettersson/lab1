package lab1;

public class Transform {
    protected double currentSpeed;
    private final double enginepower;
    protected Boolean EngineOn;
    protected Boolean TurboOn;
    protected Boolean CargoDoorClosed;
    double TrimFactor;

    public Transform(double enginepower){
        /* Base values for all possible functions that might interfere with a speed calculation. So that every vehicle
        can utilise Transform even though they have different factors. NOTE: Only Saab95 have the power to turn on Turbo (see Saab95.java) */
        this.enginepower = enginepower;
        this.currentSpeed = 0;
        this.TurboOn = false;
        this.TrimFactor = 1;
        this.CargoDoorClosed = true;
        this.EngineOn = false;
    }

    /* Redone to calculate the speed factor for any given vehicle, for those who don't utilise a (for example) truckbed.
    So there is a base value that won't interfere unless the function in question is being used */
    public double speedFactor() {
        double Turbo = 1;
        if (TurboOn){
            Turbo = 1.3;
        }
        return getEnginepower() * 0.01 * Turbo * TrimFactor; }

    public void incrementSpeed(double amount){
        if(CargoDoorClosed) {
            currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginepower());
        }
    }

    public void decrementSpeed(double amount){
        if (CargoDoorClosed){
        currentSpeed = Math.max(0, getCurrentSpeed() - speedFactor() * amount);
        }
    }

    public void gas(double amount) {
        if (amount > 0 && amount <= 1) {
            incrementSpeed(amount);
        } else {
            throw new IllegalArgumentException("Too much gas");
        }
    }
    public void brake(double amount) {
        if (amount > 0 && amount <= 1) {
            decrementSpeed(amount);
        } else {
            throw new IllegalArgumentException("Too much brake");
        }
    }
    public void startEngine() {this.EngineOn = true; }
    public void stopEngine() { 
        this.EngineOn = false;
        this.currentSpeed = 0;
    }


    // Getters
    public double getEnginepower(){
        return this.enginepower;
    }
    public double getCurrentSpeed(){
        return this.currentSpeed;
    }
    public double getTrimFactor(){
        return this.TrimFactor;
    }
    public Boolean getCargoDoorClosed(){
        return this.CargoDoorClosed;
    }
    public Boolean getEngineState(){return this.EngineOn;}

    //Setters
    public void setCargoDoorClosed(Boolean value){
        this.CargoDoorClosed = value;
    }
}
