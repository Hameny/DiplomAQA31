package dto;

import java.util.Objects;
import lombok.Getter;

public class AddWorkout {
    @Getter
    private final String workoutDate;
    @Getter
    private final String timeOfDay;
    @Getter
    private final String activityType;
    @Getter
    private final String name;
    @Getter
    private final String description;
    private final boolean showPlannedDistance;
    private final String pDistance;
    private final String pDistanceType;
    private final String pDuration;
    @Getter
    private final String distance;
    @Getter
    private final String distanceType;
    @Getter
    private final String duration;
    @Getter
    private final String paceType;
    private final String howFeel;
    @Getter
    private final String perEffort;
    private final String postNotes;
    @Getter
    private final boolean markAsRace;
    private final String kCal;
    private final boolean saveToLibrary;

    private AddWorkout(AddWorkoutBuilder addWorkoutBuilder) {
        this.workoutDate = addWorkoutBuilder.workoutDate;
        this.timeOfDay = addWorkoutBuilder.timeOfDay;
        this.activityType = addWorkoutBuilder.activityType;
        this.description = addWorkoutBuilder.description;
        this.name = addWorkoutBuilder.name;
        this.showPlannedDistance = addWorkoutBuilder.showPlannedDistance;
        this.pDistance = addWorkoutBuilder.pDistance;
        this.pDistanceType = addWorkoutBuilder.pDistanceType;
        this.pDuration = addWorkoutBuilder.pDuration;
        this.distance = addWorkoutBuilder.distance;
        this.distanceType = addWorkoutBuilder.distanceType;
        this.duration = addWorkoutBuilder.duration;
        this.paceType = addWorkoutBuilder.paceType;
        this.howFeel = addWorkoutBuilder.howFeel;
        this.perEffort = addWorkoutBuilder.perEffort;
        this.postNotes = addWorkoutBuilder.postNotes;
        this.markAsRace = addWorkoutBuilder.markAsRace;
        this.kCal = addWorkoutBuilder.kCal;
        this.saveToLibrary = addWorkoutBuilder.saveToLibrary;
    }


  public boolean isShowPlannedDistance() {
        return showPlannedDistance;
    }


    public String getpDistance() {
        return pDistance;
    }


    public String getpDistanceType() {
        return pDistanceType;
    }


    public String getpDuration() {
        return pDuration;
    }


  public String getHowFeel() {
        return howFeel;
    }


  public String getPostNotes() {
        return postNotes;
    }


  public String getkCal() {
        return kCal;
    }


    public boolean isSaveToLibrary() {
        return saveToLibrary;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddWorkout that = (AddWorkout) o;
        return showPlannedDistance == that.showPlannedDistance && markAsRace == that.markAsRace && saveToLibrary == that.saveToLibrary && Objects.equals(workoutDate, that.workoutDate) && Objects.equals(timeOfDay, that.timeOfDay) && Objects.equals(activityType, that.activityType) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(pDistance, that.pDistance) && Objects.equals(pDistanceType, that.pDistanceType) && Objects.equals(pDuration, that.pDuration) && Objects.equals(distance, that.distance) && Objects.equals(distanceType, that.distanceType) && Objects.equals(duration, that.duration) && Objects.equals(paceType, that.paceType) && Objects.equals(howFeel, that.howFeel) && Objects.equals(perEffort, that.perEffort) && Objects.equals(kCal, that.kCal) && Objects.equals(postNotes, that.postNotes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workoutDate, timeOfDay, activityType, name, description, showPlannedDistance, pDistance, pDistanceType, pDuration, distance, distanceType, duration, paceType, howFeel, perEffort, postNotes, markAsRace, kCal, saveToLibrary);
    }

    public static class AddWorkoutBuilder {
        private String workoutDate;
        private String timeOfDay;
        private String activityType;
        private String name;
        private String description;
        private boolean showPlannedDistance;
        private String pDistance;
        private String pDistanceType;
        private String pDuration;
        private String distance;
        private String distanceType;
        private String duration;
        private String paceType;
        private String howFeel;
        private String perEffort;
        private String postNotes;
        private boolean markAsRace;
        private String kCal;
        private boolean saveToLibrary;


        public AddWorkoutBuilder setActivityType(String activityType) {
            this.activityType = activityType;
            return this;
        }

        public AddWorkoutBuilder setWorkoutDate(String workoutDate) {
            this.workoutDate = workoutDate;
            return this;
        }

        public AddWorkoutBuilder setTimeOfDay(String timeOfDay) {
            this.timeOfDay = timeOfDay;
            return this;
        }

        public AddWorkoutBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public AddWorkoutBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public AddWorkoutBuilder setShowPlannedDistance(boolean showPlannedDistance) {
            this.showPlannedDistance = showPlannedDistance;
            return this;
        }

        public AddWorkoutBuilder setpDistance(String pDistance) {
            this.pDistance = pDistance;
            return this;
        }

        public AddWorkoutBuilder setpDistanceType(String pDistanceType) {
            this.pDistanceType = pDistanceType;
            return this;
        }

        public AddWorkoutBuilder setpDuration(String pDuration) {
            this.pDuration = pDuration;
            return this;
        }

        public AddWorkoutBuilder setDistance(String distance) {
            this.distance = distance;
            return this;
        }

        public AddWorkoutBuilder setDistanceType(String distanceType) {
            this.distanceType = distanceType;
            return this;
        }

        public AddWorkoutBuilder setDuration(String duration) {
            this.duration = duration;
            return this;
        }

        public AddWorkoutBuilder setPaceType(String paceType) {
            this.paceType = paceType;
            return this;
        }

        public AddWorkoutBuilder setHowFeel(String howFeel) {
            this.howFeel = howFeel;
            return this;
        }

        public AddWorkoutBuilder setPerEffort(String perEffort) {
            this.perEffort = perEffort;
            return this;
        }

        public AddWorkoutBuilder setPostNotes(String postNotes) {
            this.postNotes = postNotes;
            return this;
        }

        public AddWorkoutBuilder setMarkAsRace(boolean markAsRace) {
            this.markAsRace = markAsRace;
            return this;
        }

        public AddWorkoutBuilder setkCal(String kCal) {
            this.kCal = kCal;
            return this;
        }

        public AddWorkoutBuilder setSaveToLibrary(boolean saveToLibrary) {
            this.saveToLibrary = saveToLibrary;
            return this;
        }

        public AddWorkout build() {
            return new AddWorkout(this);

        }
    }
}

