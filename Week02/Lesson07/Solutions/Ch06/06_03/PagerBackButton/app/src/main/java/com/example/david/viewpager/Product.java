package com.example.david.viewpager;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {

    private final String productId;
    private final String name;
    private final String description;
    private final double price;

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description + "\n";
    }

    public double getPrice() {
        return price;
    }

    public Product(String productId, String name, String description, double price) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.productId);
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeDouble(this.price);
    }

    protected Product(Parcel in) {
        this.productId = in.readString();
        this.name = in.readString();
        this.description = in.readString();
        this.price = in.readDouble();
    }

    public static final Parcelable.Creator<Product> CREATOR = new Parcelable.Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel source) {
            return new Product(source);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };
}
