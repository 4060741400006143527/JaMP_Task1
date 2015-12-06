package kz.epam.principles.behavior;

public class EnegryChecker {

    public static boolean checkEnergy(int stepCounter, boolean faildStep) {
        if (stepCounter != 0 && stepCounter % 10 == 0) {
            return faildStep;
        }
        return true;
    }
}
