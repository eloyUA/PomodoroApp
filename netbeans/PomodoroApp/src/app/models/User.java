
package app.models;

public class User {
    private int id;
    private String name;
    private int studyTimeInMin;
    private int meanExerciseTimeInMin;
    private int meters;
    private int score;
    
    public User() {
        
    }
    
    public User(User user) {
        this.id = user.getId();
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
