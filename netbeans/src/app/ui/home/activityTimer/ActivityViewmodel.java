
package app.ui.home.activityTimer;

public class ActivityViewmodel {
    private String idExercise;
    private String name;
    private String description;
    private int durationInMin;
    // private String image;
    
    public ActivityViewmodel() {
        
    }
    
    public ActivityViewmodel(
            String idExercise,
            String name,
            String description,
            int durationInMin) {
        this.idExercise = idExercise;
        this.name = name;
        this.description = description;
        this.durationInMin = durationInMin;
    }
    
    public String getIdExercise() {
        return idExercise;
    }
    
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public int getDurationInMin() {
        return durationInMin;
    }
}
