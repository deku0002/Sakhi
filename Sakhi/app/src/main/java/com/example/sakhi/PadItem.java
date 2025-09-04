package com.example.sakhi;

public class PadItem {
    private String name;
    private int stock;

    public PadItem(String name, int stock) {
        this.name = name;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }
}
