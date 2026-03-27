
package app.models;

public class User {
    private String objectId;
    private String name;
    private int studyTimeInMin;
    private float meanExerciseTimeInMin;
    private int numExercisesCompleted;
    private int meters;
    private float score;
    
    public User() {
        
    }
    
    public User(String name) {
        this.name = name;
    }
    
    public User(User user) {
        this.objectId = user.getObjectId();
        this.name = user.getName();
        this.studyTimeInMin = user.getStudyTimeInMin();
        this.score = user.getScore();
    }
    
    public User(String name, int studyTimeInMin, int score) {
        this.name = name;
        this.studyTimeInMin = studyTimeInMin;
        this.score = score;
    }
    
    public void update(User user) {
        this.objectId = user.getObjectId();
        this.name = user.getName();
        this.studyTimeInMin = user.getStudyTimeInMin();
        this.meanExerciseTimeInMin = user.getMeanExerciseTimeInMin();
        this.numExercisesCompleted = user.getNumExercisesCompleted();
        this.meters = user.getMeters();
        this.score = user.getScore();
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

    public int getStudyTimeInMin() {
        return studyTimeInMin;
    }
    
    public float getMeanExerciseTimeInMin() {
        return meanExerciseTimeInMin;
    }
    
    public int getNumExercisesCompleted() {
        return this.numExercisesCompleted;
    }
    
    public int getMeters() {
        return this.meters;
    }

    public void setMeters(int meters) {
        this.meters = meters;
    }

    public float getScore() {
        return score;
    }
    
    public void finishActivity(int extraStudyTimeInMin, int exerciseTimeInMin, int extraMeters) {
        this.studyTimeInMin += extraStudyTimeInMin;
        
        float time = this.meanExerciseTimeInMin * this.numExercisesCompleted + exerciseTimeInMin;
        this.numExercisesCompleted += 1;
        this.meanExerciseTimeInMin = time / this.numExercisesCompleted;
        
        this.meters += extraMeters;
        this.score = (float) (this.studyTimeInMin + this.meters) / (float) (this.meanExerciseTimeInMin);
    }
}
