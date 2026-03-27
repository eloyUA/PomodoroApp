package app.ui.history.viewmodels;

public class AnaliticsViewmodel {
    private int studyTimeInMin;
    private float meanExerciseTimeInMin;
    private int meters;
    
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
    
    public float getMeanExerciseTimeInMin() {
        return meanExerciseTimeInMin;
    }
    
    public int getMeters() {
        return meters;
    }
}
