package app.ui.history;

import java.util.Date;

public class RowHistoryViewmodel {
    private Date date;
    private String nameExercise;
    private int durationInMin;
    
    public RowHistoryViewmodel() {
        
    }
    
    public RowHistoryViewmodel(Date date, String nameExercise, int timeInMin) {
        this.date = date;
        this.nameExercise = nameExercise;
        this.durationInMin = timeInMin;
    }

    public RowHistoryViewmodel(RowHistoryViewmodel row) {
        this.date = row.getDate();
        this.nameExercise = row.getNameExercise();
        this.durationInMin = row.getDurationInMin();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNameExercise() {
        return nameExercise;
    }

    public void setNameExercise(String nameExercise) {
        this.nameExercise = nameExercise;
    }

    public int getDurationInMin() {
        return durationInMin;
    }

    public void setDurationInMin(int durationInMin) {
        this.durationInMin = durationInMin;
    }
}