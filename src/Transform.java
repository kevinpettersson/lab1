public class Transform {
    protected double currentSpeed;
    public Transform(Car car){
        this.
    }
    // ---- SPEED STUFF ---- \\
    public double speedFactor() { return getEnginePower() * 0.01; }

    public void incrementSpeed(double amount){
        currentSpeed = Math.min(car.getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    public void decrementSpeed(double amount){
        currentSpeed = Math.max(0, getCurrentSpeed() - speedFactor() * amount);
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
}
