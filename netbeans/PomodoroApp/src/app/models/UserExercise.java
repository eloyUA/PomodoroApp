package app.models;

import java.util.Date;

public class UserExercise {

    private String idUser;
    private String idExercise;
    private Date date;
    private int prevStudyTimeInMin;
    private int minutes;
    private int meters;
    
    public UserExercise() {
        
    }
    
    public UserExercise(
            String idUser,
            String idExercise,
            Date date,
            int prevStudyTimeInMin,
            int minutes,
            int meters) {
        
        this.idUser = idUser;
        this.idExercise = idExercise;
        this.date = date;
        this.prevStudyTimeInMin = prevStudyTimeInMin;
        this.minutes = minutes;
        this.meters = meters;
    }

    public UserExercise(UserExercise relation) {
        this.idUser = relation.getIdUser();
        this.idExercise = relation.getIdExercise();
        this.date = relation.getDate();
        this.prevStudyTimeInMin = relation.getPrevStudyTimeInMin();
        this.minutes = relation.getDuration();
        this.meters = relation.getMeters();
    }
    
    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getIdExercise() {
        return idExercise;
    }

    public void setIdExercise(String idExercise) {
        this.idExercise = idExercise;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPrevStudyTimeInMin() {
        return this.prevStudyTimeInMin;
    }

    public void setPrevStudyTimeInMin(int prevStudyTimeInMin) {
        this.prevStudyTimeInMin = prevStudyTimeInMin;
    }
    
    public int getDuration() {
        return minutes;
    }

    public void setDuration(int duration) {
        this.minutes = duration;
    }

    public int getMeters() {
        return meters;
    }

    public void setMeters(int meters) {
        this.meters = meters;
    }
    
}
