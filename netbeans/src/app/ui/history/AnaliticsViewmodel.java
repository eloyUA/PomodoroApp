package app.ui.history;

public class AnaliticsViewmodel {
    private int studyTimeInMin;
    private float meanExerciseTimeInMin;
    private int meters;
    
    public AnaliticsViewmodel() {
        
    }
    
    public AnaliticsViewmodel(int studyTimeInMin, float meanExerciseTimeInMin, int meters) {
        this.studyTimeInMin = studyTimeInMin;
        this.meanExerciseTimeInMin = meanExerciseTimeInMin;
        this.meters = meters;
    }
    
    public AnaliticsViewmodel(AnaliticsViewmodel analisis) {
        this.studyTimeInMin = analisis.getStudyTimeInMin();
        this.meanExerciseTimeInMin = analisis.getMeanExerciseTimeInMin();
        this.meters = analisis.getMeters();
    }
    
    public int getStudyTimeInMin() {
        return studyTimeInMin;
    }

    public void setStudyTimeInMin(int studyTimeInMin) {
        this.studyTimeInMin = studyTimeInMin;
    }

    public void setMeanExerciseTimeInMin(float meanExerciseTimeInMin) {
        this.meanExerciseTimeInMin = meanExerciseTimeInMin;
    }

    public void setMeters(int meters) {
        this.meters = meters;
    }
    
    public float getMeanExerciseTimeInMin() {
        return meanExerciseTimeInMin;
    }
    
    public int getMeters() {
        return meters;
    }
}
