package dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Builder
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AddBikes {

  @EqualsAndHashCode.Include
  @ToString.Include
  private final String bikeName;
  private final String brand;
  private final String model;
  private final String cost;
  private final String datePurchased;
  @ToString.Include
  private final String bikeType;
  private final String frameMaterial;
  @ToString.Include
  private final String frameSize;
  private final String wheelSize;
  @ToString.Include
  private final String startDistance;
  private final String startDistanceType;
  @ToString.Include
  private final String alertDistance;
  private final String alertDistanceType;
  private final String notes;
}