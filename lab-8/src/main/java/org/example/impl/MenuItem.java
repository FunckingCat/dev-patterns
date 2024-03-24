package org.example.impl;

public class MenuItem {
    public String getMenuName() {
        return menuName;
    }

    private String menuName;

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    private final String name;

    private final String description;

    private final double price;

    public MenuItem(String menuName, String name, String description, double price) {
        this.menuName = menuName;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "%s\t %s.\t Price for one item %s.\t %s".formatted(menuName, name, price, description);
    }
}
