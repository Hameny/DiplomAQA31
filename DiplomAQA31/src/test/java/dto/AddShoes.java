package dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Builder
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AddShoes {

  @EqualsAndHashCode.Include
  @ToString.Include
  private final String shoeName;
  @ToString.Include
  private final String brand;
  @ToString.Include
  private final String model;
  private final String cost;
  private final String datePurchased;
  @ToString.Include
  private final String size;
  @ToString.Include
  private final String startDistance;
  private final String startDistanceType;
  @ToString.Include
  private final String alertDistance;
  private final String alertDistanceType;
}