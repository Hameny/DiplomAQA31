package dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Builder
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AddWorkout {

  @EqualsAndHashCode.Include
  @ToString.Include
  private final String workoutDate;
  @ToString.Include
  private final String timeOfDay;
  @EqualsAndHashCode.Include
  @ToString.Include
  private final String activityType;
  @EqualsAndHashCode.Include
  @ToString.Include
  private final String name;
  private final String description;
  private final boolean showPlannedDistance;
  private final String plannedDistance;
  private final String plannedDistanceType;
  private final String plannedDuration;
  @ToString.Include
  private final String distance;
  @ToString.Include
  private final String distanceType;
  @ToString.Include
  private final String duration;
  private final String paceType;
  private final String overallFeeling;
  private final String perceivedEffort;
  private final String postWorkoutNotes;
  private final boolean markAsRace;
  private final String caloriesBurned;
  private final boolean saveToLibrary;
}