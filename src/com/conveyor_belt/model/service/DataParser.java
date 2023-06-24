package com.conveyor_belt.model.service;

import com.conveyor_belt.model.domain.ConveyorBelt;
import com.conveyor_belt.model.domain.Parcel;

import java.util.List;
import java.util.stream.Collectors;

public class DataParser {

    private int id = 0;
    private static ConveyorBelt parseConveyorBelt(List<String> lines) {
        String[] items = lines.get(0).split(" ");
        int length = Integer.parseInt(items[0]);
        int unitSpeed = Integer.parseInt(items[1]);
        return new ConveyorBelt(length, unitSpeed);
    }

    public List<Parcel> parseParcels(List<String> lines) {
        ConveyorBelt conveyorBelt = parseConveyorBelt(lines);
        return lines.stream()
                .skip(1)
                .map(line -> createParcel(line, conveyorBelt))
                .collect(Collectors.toList());
    }

    private Parcel createParcel(String line, ConveyorBelt conveyorBelt) {
        String[] items = line.split(" ");
        int time = Integer.parseInt(items[0]);
        int startPos = Integer.parseInt(items[1]);
        int endPos = Integer.parseInt(items[2]);
        int weight = Integer.parseInt(items[3]);
        return new Parcel(++id, time, startPos, endPos, weight, conveyorBelt);
    }
}
