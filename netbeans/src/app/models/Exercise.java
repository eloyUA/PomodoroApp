
package app.models;

public class Exercise {
    private String objectId;
    private String name;
    private String description;
    private String studyZone;
    private String difficultyLevel;
    // private String img;

    public Exercise() {
        
    }
    
    public Exercise(Exercise exercise) {
        this.objectId = exercise.getObjectId();
        this.name = exercise.getName();
        this.description = exercise.getDescription();
        this.studyZone = exercise.getStudyZone();
        this.difficultyLevel = exercise.getDifficultyLevel();
    }
    
    public Exercise(
            String name,
            String description,
            String studyZone,
            String difficultyLevel) {
        
        this.name = name;
        this.description = description;
        this.studyZone = studyZone;
        this.difficultyLevel = difficultyLevel;
    }
    
    public void update(Exercise exercise) {
        this.name = exercise.getName();
        this.description = exercise.getDescription();
        this.studyZone = exercise.getStudyZone();
        this.difficultyLevel = exercise.getDifficultyLevel();
    }
    
    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStudyZone() {
        return studyZone;
    }

    public void setStudyZone(String studyZone) {
        this.studyZone = studyZone;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }
}