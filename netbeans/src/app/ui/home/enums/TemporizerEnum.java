package app.ui.home.enums;

public enum TemporizerEnum {
    TEMP_25_5(25, 5),
    TEMP_45_10(45, 10),
    TEMP_90_10(90, 10);
    
    private int studyTimeInMin;
    private int activityTimeInMin;
    
    private TemporizerEnum(int studyTimeInMin, int activityTimeInMin) {
        this.studyTimeInMin = studyTimeInMin;
        this.activityTimeInMin = activityTimeInMin;
    }
}
