package app.models;

import java.util.Date;

public class UserExercise {

    private int idUser;
    private int idExercise;
    private Date date;
    private int minutes;
    private int meters;
    
    public UserExercise() {
        
    }

    public UserExercise(UserExercise relation) {
        this.idUser = relation.getIdUser();
        this.idExercise = relation.getIdExercise();
        this.date = relation.getDate();
        this.minutes = relation.getDuration();
        this.meters = relation.getMeters();
    }
    
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdExercise() {
        return idExercise;
    }

    public void setIdExercise(int idExercise) {
        this.idExercise = idExercise;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
