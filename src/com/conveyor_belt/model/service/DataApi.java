package com.conveyor_belt.model.service;

import com.conveyor_belt.model.domain.Parcel;

import java.util.List;

public class DataApi {

    private final DataParser parser;

    private final List<String> lines;

    public DataApi(FileReader reader, DataParser parser) {
        this.parser = parser;
        lines = reader.read();
    }

    public List<Parcel> getParcels() {
        return parser.parseParcels(lines);
    }
}
