package dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Builder
@ToString
@EqualsAndHashCode
public class Calculator {

  private final String hours;
  private final String minutes;
  private final String seconds;
}