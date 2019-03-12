package ru.job4j.inheritance;

/**
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 * @since 11.03.19.
 */
public class House {
    private int color;
    private int floor;
    private String material;

    public House() {

    }

    public House(int color, int floor, String material) {
        this.color = color;
        this.floor = floor;
        this.material = material;
    }

    public int getColor() {
        return color;
    }

    public int getFloor() {
        return floor;
    }

    public String getMaterial() {
        return material;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
