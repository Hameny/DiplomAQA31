package dto;

import java.util.Objects;
import lombok.Getter;

public class AddShoes {

  private final String shoeName;
  @Getter
  private final String brand;
  @Getter
  private final String model;
  @Getter
  private final String cost;
  @Getter
  private final String datePurchased;
  @Getter
  private final String size;
  @Getter
  private final String startDistance;
  @Getter
  private final String startDistancetype;
  @Getter
  private final String alertDistance;
  @Getter
  private final String alertDistancetype;


  private AddShoes(AddShoesBuilder addShoesBuilder) {
    this.shoeName = addShoesBuilder.shoeName;
    this.brand = addShoesBuilder.brand;
    this.model = addShoesBuilder.model;
    this.cost = addShoesBuilder.cost;
    this.datePurchased = addShoesBuilder.datePurchased;
    this.size = addShoesBuilder.size;
    this.startDistance = addShoesBuilder.startDistance;
    this.startDistancetype = addShoesBuilder.startDistancetype;
    this.alertDistance = addShoesBuilder.alertDistance;
    this.alertDistancetype = addShoesBuilder.alertDistancetype;
  }


  public String getShoesName() {
    return shoeName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AddShoes addShoes = (AddShoes) o;
    return Objects.equals(shoeName, addShoes.shoeName) && Objects.equals(brand, addShoes.brand)
        && Objects.equals(model, addShoes.model) && Objects.equals(cost, addShoes.cost)
        && Objects.equals(datePurchased, addShoes.datePurchased) && Objects.equals(size,
        addShoes.size) && Objects.equals(startDistance, addShoes.startDistance) && Objects.equals(
        startDistancetype, addShoes.startDistancetype) && Objects.equals(alertDistance,
        addShoes.alertDistance) && Objects.equals(alertDistancetype, addShoes.alertDistancetype);
  }

  @Override
  public int hashCode() {
    return Objects.hash(shoeName, brand, model, cost, datePurchased, size, startDistance,
        startDistancetype, alertDistance, alertDistancetype);
  }

  @Override
  public String toString() {
    return "AddShoes{" +
        "shoeName='" + shoeName + '\'' +
        ", brand='" + brand + '\'' +
        ", model='" + model + '\'' +
        ", cost='" + cost + '\'' +
        ", datePurchased='" + datePurchased + '\'' +
        ", size='" + size + '\'' +
        ", startDistance='" + startDistance + '\'' +
        ", startDistancetype='" + startDistancetype + '\'' +
        ", alertDistance='" + alertDistance + '\'' +
        ", alertDistancetype='" + alertDistancetype + '\'' +
        '}';
  }

  public static class AddShoesBuilder {

    private String shoeName;
    private String brand;
    private String model;
    private String cost;
    private String datePurchased;
    private String size;
    private String startDistance;
    private String startDistancetype;
    private String alertDistance;
    private String alertDistancetype;

    public AddShoesBuilder() {

    }

    public AddShoesBuilder setShoeName(String shoeName) {
      this.shoeName = shoeName;
      return this;
    }

    public AddShoesBuilder setBrand(String brand) {
      this.brand = brand;
      return this;
    }

    public AddShoesBuilder setModel(String model) {
      this.model = model;
      return this;
    }

    public AddShoesBuilder setCost(String cost) {
      this.cost = cost;
      return this;
    }

    public AddShoesBuilder setDatePurchased(String datePurchased) {
      this.datePurchased = datePurchased;
      return this;
    }

    public AddShoesBuilder setSize(String size) {
      this.size = size;
      return this;
    }

    public AddShoesBuilder setStartDistance(String startDistance) {
      this.startDistance = startDistance;
      return this;
    }

    public AddShoesBuilder setStartDistancetype(String startDistancetype) {
      this.startDistancetype = startDistancetype;
      return this;
    }

    public AddShoesBuilder setAlertDistance(String alertDistance) {
      this.alertDistance = alertDistance;
      return this;
    }

    public AddShoesBuilder setAlertDistancetype(String alertDistancetype) {
      this.alertDistancetype = alertDistancetype;
      return this;
    }

    public AddShoes build() {
      return new AddShoes(this);
    }
  }
}

