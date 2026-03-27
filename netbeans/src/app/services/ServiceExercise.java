
package app.services;

import app.dao.RepositoryExercise;
import app.models.Exercise;
import app.ui.home.ActivityFormViewmodel;
import java.util.ArrayList;
import java.util.List;


public class ServiceExercise {
    private RepositoryExercise repoExercise;
    
    public ServiceExercise(RepositoryExercise repoExercise) {
        this.repoExercise = repoExercise;
    }
    
    public void createExercise(Exercise exercise) throws Exception {
        this.repoExercise.insert(exercise);
    }
    
    public void updateExercise(Exercise exercise) throws Exception {
        this.repoExercise.update(exercise);
    }
    
    public void deleteExerciseById(String objectId) throws Exception {
        this.repoExercise.deleteById(objectId);
    }
    
    public Exercise getExerciseById(String objectId) throws Exception {
        return this.repoExercise.getById(objectId);
    }
    
    public List<Exercise> getAllExercises() throws Exception {
        return this.repoExercise.getAll();
    }
    
    public Exercise chooseRandomExercise(ActivityFormViewmodel form) throws Exception {
        List<Exercise> exercises = this.repoExercise.getAll();
        List<Exercise> cadidatesExercises = new ArrayList<>();
        for (Exercise exercise : exercises) {
            if (exercise.getStudyZone().equals(form.getDifficulty().toString()) &&
                exercise.getDifficultyLevel().equals(form.getDifficulty().toString())) {
                cadidatesExercises.add(exercise);
            }
        }
        int pos = (int) ((double) (cadidatesExercises.size()) * Math.random());
        return cadidatesExercises.get(pos);
    }
}
