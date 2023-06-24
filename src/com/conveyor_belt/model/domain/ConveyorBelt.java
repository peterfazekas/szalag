package com.conveyor_belt.model.domain;

public class ConveyorBelt {

    private final int length;
    private final int unitSpeed;

    public ConveyorBelt(int length, int unitSpeed) {
        this.length = length;
        this.unitSpeed = unitSpeed;
    }

    public int getLength() {
        return length;
    }

    public int getUnitSpeed() {
        return unitSpeed;
    }
}
