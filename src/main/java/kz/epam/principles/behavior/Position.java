package kz.epam.principles.behavior;

public class Position {

    private int stepCounter;
    private boolean failedStep = false;

    public void changePosition(Command command) {
        failedStep = false;
        stepCounter++;
    }

    public int getPosition() {
        return stepCounter;
    }

    public boolean isFailedStep() {
        return failedStep;
    }

    public void setFailedStep(boolean failedStep) {
        this.failedStep = failedStep;
    }
}
