package com.gla.interface_abstraction;

public interface Exporter {
    void exportCSV();
    void exportPDF();

    default void exportToJSON() {
        System.out.println("Exported to JSON");
    }
}