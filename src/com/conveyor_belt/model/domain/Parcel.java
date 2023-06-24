package com.conveyor_belt.model.domain;

public class Parcel {

    private final int id;
    private final int time;
    private final int startPos;
    private final int endPos;
    private final int weight;
    private final ConveyorBelt conveyorBelt;

    public Parcel(int id, int time, int startPos, int endPos, int weight, ConveyorBelt conveyorBelt) {
        this.id = id;
        this.time = time;
        this.startPos = startPos;
        this.endPos = endPos;
        this.weight = weight;
        this.conveyorBelt = conveyorBelt;
    }

    public int getId() {
        return id;
    }

    public boolean isId(int id) {
        return  this.id == id;
    }

    public boolean isStartPos(int pos) {
        return startPos == pos;
    }
    public int getStartPos() {
        return startPos;
    }

    public int getEndPos() {
        return endPos;
    }

    public int getWeight() {
        return weight;
    }


    public boolean isDistance(int distance) {
        return distance() == distance;
    }

    /**
     * 3. feladat
     */
    public int distance() {
        return tav(conveyorBelt.getLength(), this.getStartPos(), this.getEndPos());
    }

    private int tav(int szalaghossz, int indulashelye, int erkezeshelye) {
        return  (indulashelye < erkezeshelye)
                ? erkezeshelye - indulashelye
                : szalaghossz - indulashelye + erkezeshelye;
    }

    public int getWeightInZeroPos() {
        return  (endPos < startPos && startPos != 0 && endPos != 0) ? weight : 0;
    }

    public boolean isInTime(int time) {
        return this.time <= time && calculateEndTime() > time;
    }

    private int calculateEndTime() {
        return time + distance() * conveyorBelt.getUnitSpeed();
    }

}
