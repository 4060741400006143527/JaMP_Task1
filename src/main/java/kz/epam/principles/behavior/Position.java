package kz.epam.principles.behavior;

public class Position {

    private Location location;
    private int stepCounter;
    private boolean failedStep = false;

    public void changePosition(Command command) {
        failedStep = false;
        stepCounter++;
    }

    public int getStepCount() {
        return stepCounter;
    }

    public boolean isFailedStep() {
        return failedStep;
    }

    public void setFailedStep(boolean failedStep) {
        this.failedStep = failedStep;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }    
}
