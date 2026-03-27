package app.ui.friendship.viewmodels;

public class RowRankingViewmodel {
    private String friendId;
    private String name;
    private int studyTimeInMin;
    private float meanTimeExerciseInMin;
    private int meters;
    private float points;
    
    public RowRankingViewmodel() {
        
    }
    
    public RowRankingViewmodel(
            String friendId,
            String name,
            int studyTimeInMin,
            float meanTimeExerciseInMin,
            int meters,
            float points) {
        
        this.friendId = friendId;
        this.name = name;
        this.studyTimeInMin = studyTimeInMin;
        this.meanTimeExerciseInMin = meanTimeExerciseInMin;
        this.meters = meters;
        this.points = points;
    }
    
    public RowRankingViewmodel(RowRankingViewmodel row) {
        this.friendId = row.getFriendId();
        this.name = row.getName();
        this.studyTimeInMin = row.getStudyTimeInMin();
        this.meanTimeExerciseInMin = row.getMeanTimeExerciseInMin();
        this.meters = row.meters;
        this.points = row.getPoints();
    }

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId;
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

    public void setStudyTimeInMin(int studyTimeInMin) {
        this.studyTimeInMin = studyTimeInMin;
    }

    public float getMeanTimeExerciseInMin() {
        return meanTimeExerciseInMin;
    }

    public void setMeanTimeExerciseInMin(float meanTimeExerciseInMin) {
        this.meanTimeExerciseInMin = meanTimeExerciseInMin;
    }

    public float getMeters() {
        return meters;
    }

    public void setMeters(int meters) {
        this.meters = meters;
    }

    public float getPoints() {
        return points;
    }

    public void setPoints(float points) {
        this.points = points;
    }
}