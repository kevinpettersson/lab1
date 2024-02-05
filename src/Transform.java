public class Transform {
    protected double currentSpeed;
    private final double enginepower;
    protected Boolean TurboOn;
    protected Boolean CargoDoorClosed;
    double TrimFactor;

    public Transform(double enginepower){
        this.enginepower = enginepower;
        this.currentSpeed = 0;
        this.TurboOn = false;
        this.TrimFactor = 1;
        this.CargoDoorClosed = true;
    }

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
    public void startEngine() { this.currentSpeed = 0; }
    public void stopEngine() { this.currentSpeed = 0; }


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

    //Setters
    public void setTrimFactor(double value){
        this.TrimFactor = value;
    }
    public void setCargoDoorClosed(Boolean value){
        this.CargoDoorClosed = value;
    }
}
