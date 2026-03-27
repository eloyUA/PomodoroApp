package app.ui.home;

public enum EnumTemporizer {
    TEMP_25_5(25, 5),
    TEMP_45_10(45, 10),
    TEMP_90_10(90, 10);
    
    private final int studyTimeInMin;
    private final int activityTimeInMin;
    
    private EnumTemporizer(int studyTimeInMin, int activityTimeInMin) {
        this.studyTimeInMin = studyTimeInMin;
        this.activityTimeInMin = activityTimeInMin;
    }
    
    public int getStudyTimeInMin() {
        return this.studyTimeInMin;
    }
    
    public int getActivityTimeInMin() {
        return this.activityTimeInMin;
    }
}
