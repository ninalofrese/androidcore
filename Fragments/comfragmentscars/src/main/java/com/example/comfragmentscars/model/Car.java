package com.example.comfragmentscars.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Car implements Parcelable {
    private int image;
    private String model;
    private String description;

    public Car(int image, String model, String description) {
        this.image = image;
        this.model = model;
        this.description = description;
    }

    public Car() {

    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
