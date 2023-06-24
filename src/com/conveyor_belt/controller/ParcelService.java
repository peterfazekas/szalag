package com.conveyor_belt.controller;

import com.conveyor_belt.model.domain.Parcel;

import java.util.List;
import java.util.stream.Collectors;

public class ParcelService {

    private final List<Parcel> parcels;

    public ParcelService(List<Parcel> parcels) {
        this.parcels = parcels;
    }

    /**
     * 2. feladat
     */
    public int getStartPosById(int id) {
        return getParcelById(id).getStartPos();
    }

    public int getEndPosById(int id) {
        return getParcelById(id).getEndPos();
    }

    private Parcel getParcelById(int id) {
        return parcels.stream()
                .filter(i -> i.isId(id))
                .findAny()
                .orElseThrow(() -> new RuntimeException("Nincs ilyen csomag!"));
    }

    /**
     * 4. feladat
     */
    public String getMaxDistanceParcelsId() {
        int maxDistance = getMaxDistance();
        return parcels.stream()
                .filter(parcel -> parcel.isDistance(maxDistance))
                .map(Parcel::getId)
                .map(Object::toString)
                .collect(Collectors.joining(" "));
    }

    private int getMaxDistance() {
        return parcels.stream()
                .mapToInt(Parcel::distance)
                .max()
                .orElseThrow(() -> new RuntimeException("Nincs leghosszabb távolság!"));
    }

    /**
     * 5. feladat
     */
    public int getTotalWeightInZeroPos() {
        return parcels.stream()
                .mapToInt(Parcel::getWeightInZeroPos)
                .sum();
    }

    /**
     * 6. feladat
     */
    public String getParcelIdDuringTime(int time) {
        return parcels.stream()
                .filter(i -> i.isInTime(time))
                .map(Parcel::getId)
                .map(Object::toString)
                .collect(Collectors.joining(" "));
    }

    /**
     * 7. feladat
     */
    public List<String> getTotalWeightInStartPos() {
        List<Integer> startPositions = getStartPositions();
        return startPositions.stream()
                .map(pos -> pos + " " + calculateTotalWeightInPos(pos))
                .collect(Collectors.toList());
    }

    private List<Integer> getStartPositions() {
        return parcels.stream()
                .map(Parcel::getStartPos)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    private int calculateTotalWeightInPos(int pos) {
        return parcels.stream()
                .filter(i -> i.isStartPos(pos))
                .mapToInt(Parcel::getWeight)
                .sum();
    }
}
