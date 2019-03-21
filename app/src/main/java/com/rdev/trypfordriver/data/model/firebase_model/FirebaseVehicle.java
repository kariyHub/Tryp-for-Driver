package com.rdev.trypfordriver.data.model.firebase_model;

public class FirebaseVehicle {

    private String image;

    private String color;

    private String model;

    private String plateNumber;

    private String make;

    public FirebaseVehicle() {
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getMake() {
        return make;
    }

    @Override
    public String toString() {
        return
                "Vehicle{" +
                        "image = '" + image + '\'' +
                        ",color = '" + color + '\'' +
                        ",model = '" + model + '\'' +
                        ",plate_number = '" + plateNumber + '\'' +
                        ",make = '" + make + '\'' +
                        "}";
    }
}