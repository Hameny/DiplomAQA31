package dto;

import java.util.Objects;
import lombok.Getter;

@Getter
public class Calculator {

  private final String hours;
  private final String minutes;
  private final String seconds;

  private Calculator(CalculatorBuilder calculatorBuilder) {
    this.hours = calculatorBuilder.hours;
    this.minutes = calculatorBuilder.minute;
    this.seconds = calculatorBuilder.seconds;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Calculator that = (Calculator) o;
    return Objects.equals(hours, that.hours) &&
        Objects.equals(minutes, that.minutes) &&
        Objects.equals(seconds, that.seconds);
  }

  @Override
  public String toString() {
    return String.format("Calculator{hours='%s', minutes='%s', seconds='%s'}",
        hours, minutes, seconds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hours, minutes, seconds);
  }

  public static class CalculatorBuilder {

    private String hours;
    private String minute;
    private String seconds;

    public CalculatorBuilder setHours(String hours) {
      this.hours = hours;
      return this;
    }

    public CalculatorBuilder setMinute(String minute) {
      this.minute = minute;
      return this;
    }

    public CalculatorBuilder setSeconds(String seconds) {
      this.seconds = seconds;
      return this;
    }

    public Calculator build() {
      return new Calculator(this);
    }
  }
}
