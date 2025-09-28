package dto;

import java.util.Objects;
import lombok.Getter;

@Getter
public class AddBikes {
  private final String bikeName;
  private final String brand;
  private final String model;
  private final String cost;
  private final String datePurchased;
  private final String bikeType;
  private final String frameMaterial;
  private final String frameSize;
  private final String wheelSize;
  private final String startDistance;
  private final String startDistanceType;
  private final String alertDistance;
  private final String alertDistanceType;
  private final String notes;

  private AddBikes(AddBikeBuilder addBikeBuilder) {
    this.bikeName = addBikeBuilder.bikeName;
    this.brand = addBikeBuilder.brand;
    this.model = addBikeBuilder.model;
    this.cost = addBikeBuilder.cost;
    this.datePurchased = addBikeBuilder.datePurchased;
    this.bikeType = addBikeBuilder.bikeType;
    this.frameMaterial = addBikeBuilder.frameMaterial;
    this.frameSize = addBikeBuilder.frameSize;
    this.wheelSize = addBikeBuilder.wheelSize;
    this.startDistance = addBikeBuilder.startDistance;
    this.startDistanceType = addBikeBuilder.startDistanceType;
    this.alertDistance = addBikeBuilder.alertDistance;
    this.alertDistanceType = addBikeBuilder.alertDistanceType;
    this.notes = addBikeBuilder.notes;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AddBikes addBike = (AddBikes) o;
    return Objects.equals(bikeName, addBike.bikeName) &&
        Objects.equals(brand, addBike.brand) &&
        Objects.equals(model, addBike.model) &&
        Objects.equals(cost, addBike.cost) &&
        Objects.equals(datePurchased, addBike.datePurchased) &&
        Objects.equals(bikeType, addBike.bikeType) &&
        Objects.equals(frameMaterial, addBike.frameMaterial) &&
        Objects.equals(frameSize, addBike.frameSize) &&
        Objects.equals(wheelSize, addBike.wheelSize) &&
        Objects.equals(startDistance, addBike.startDistance) &&
        Objects.equals(startDistanceType, addBike.startDistanceType) &&
        Objects.equals(alertDistance, addBike.alertDistance) &&
        Objects.equals(alertDistanceType, addBike.alertDistanceType) &&
        Objects.equals(notes, addBike.notes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bikeName, brand, model, cost, datePurchased, bikeType,
        frameMaterial, frameSize, wheelSize, startDistance, startDistanceType,
        alertDistance, alertDistanceType, notes);
  }

  @Override
  public String toString() {
    return "AddBike{" +
        "bikeName='" + bikeName + '\'' +
        ", brand='" + brand + '\'' +
        ", model='" + model + '\'' +
        ", bikeType='" + bikeType + '\'' +
        ", frameSize='" + frameSize + '\'' +
        ", startDistance='" + startDistance + '\'' +
        ", alertDistance='" + alertDistance + '\'' +
        '}';
  }

  public static class AddBikeBuilder {
    private String bikeName;
    private String brand;
    private String model;
    private String cost;
    private String datePurchased;
    private String bikeType;
    private String frameMaterial;
    private String frameSize;
    private String wheelSize;
    private String startDistance;
    private String startDistanceType;
    private String alertDistance;
    private String alertDistanceType;
    private String notes;

    public AddBikeBuilder() {
    }

    public AddBikeBuilder setBikeName(String bikeName) {
      this.bikeName = bikeName;
      return this;
    }

    public AddBikeBuilder setBrand(String brand) {
      this.brand = brand;
      return this;
    }

    public AddBikeBuilder setModel(String model) {
      this.model = model;
      return this;
    }

    public AddBikeBuilder setCost(String cost) {
      this.cost = cost;
      return this;
    }

    public AddBikeBuilder setDatePurchased(String datePurchased) {
      this.datePurchased = datePurchased;
      return this;
    }

    public AddBikeBuilder setBikeType(String bikeType) {
      this.bikeType = bikeType;
      return this;
    }

    public AddBikeBuilder setFrameMaterial(String frameMaterial) {
      this.frameMaterial = frameMaterial;
      return this;
    }

    public AddBikeBuilder setFrameSize(String frameSize) {
      this.frameSize = frameSize;
      return this;
    }

    public AddBikeBuilder setWheelSize(String wheelSize) {
      this.wheelSize = wheelSize;
      return this;
    }

    public AddBikeBuilder setStartDistance(String startDistance) {
      this.startDistance = startDistance;
      return this;
    }

    public AddBikeBuilder setStartDistanceType(String startDistanceType) {
      this.startDistanceType = startDistanceType;
      return this;
    }

    public AddBikeBuilder setAlertDistance(String alertDistance) {
      this.alertDistance = alertDistance;
      return this;
    }

    public AddBikeBuilder setAlertDistanceType(String alertDistanceType) {
      this.alertDistanceType = alertDistanceType;
      return this;
    }

    public AddBikeBuilder setNotes(String notes) {
      this.notes = notes;
      return this;
    }

    public AddBikes build() {
      return new AddBikes(this);
    }
  }
}