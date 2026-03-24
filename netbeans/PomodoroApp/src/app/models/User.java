
package app.models;

public class User {
    private String objectId;
    private String name;
    private int studyTimeInMin;
    private int meanExerciseTimeInMin;
    private int meters;
    private int score;
    
    public User() {
        
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
        this.name = user.getName();
        this.studyTimeInMin = user.getStudyTimeInMin();
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

    public void setStudyTimeInMin(int stydyTimeInMin) {
        this.studyTimeInMin = stydyTimeInMin;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
