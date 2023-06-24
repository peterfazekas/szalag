package com.conveyor_belt;

import com.conveyor_belt.controller.ParcelService;
import com.conveyor_belt.model.service.*;

import java.util.Scanner;

public class App {

    private final ParcelService service;
    private final Console console;
    private final FileWriter writer;

    private App() {
        console = new Console(new Scanner(System.in));
        writer = new FileWriter("tomeg.txt");
        DataApi dataApi = new DataApi(new FileReader("szallit.txt"), new DataParser());
        service = new ParcelService(dataApi.getParcels());
    }

    public static void main(String[] args) {
        new App().run();
    }
    private void run() {
        System.out.println("2. feladat");
        System.out.print("Adja meg, melyik adatsorra kíváncsi! ");
        int id = console.read();
        System.out.printf("Honnan: %d Hova: %d%n", service.getStartPosById(id), service.getEndPosById(id));
        System.out.println("4. feladat");
        System.out.println("A maximális távolságú szállítások sorszáma: " + service.getMaxDistanceParcelsId());
        System.out.println("5. feladat");
        System.out.println("A kezdőpont előtt elhaladó rekeszek össztömege: " + service.getTotalWeightInZeroPos());
        System.out.println("6. feladat");
        System.out.print("Adja meg a kívánt időpontot! ");
        int time = console.read();
        System.out.println("A szállított rekeszek halmaza: " + service.getParcelIdDuringTime(time));
        writer.writeAll(service.getTotalWeightInStartPos());
    }
}
