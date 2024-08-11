package net.myosotis.kanekiller;

public class globalVars {
    public static int resetValue = 1000;
    public static int currentValue = resetValue;

    public static void setCurrentValue(int value) {
        currentValue = value;
    }

    public static void resetCurrentValue() {
        currentValue = resetValue;
    }

    public static int getCurrentValue() {
        return currentValue;
    }
}
