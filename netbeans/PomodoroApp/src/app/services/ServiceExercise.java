
package app.services;

import app.dao.RepositoryExercise;
import app.dao.RepositoryUserExercise;
import app.models.Exercise;
import app.models.UserExercise;
import java.util.List;


public class ServiceExercise {
    
    private RepositoryExercise repoExercise;
    private RepositoryUserExercise repoUserExercise;
    
    public ServiceExercise(
            RepositoryExercise repoExercise, 
            RepositoryUserExercise repoUserExercise) {
        
        this.repoExercise = repoExercise;
        this.repoUserExercise = repoUserExercise;
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
    
    public void createUserExercise(UserExercise userExercise) throws Exception {
        this.repoUserExercise.create(userExercise);
    }
    
    public void deleteUserExerciseByIds(String userId, String exerciseId) throws Exception {
        this.repoUserExercise.deleteByIds(userId, exerciseId);
    }
    
    public List<Exercise> getExercisesByIdUser(String userId) throws Exception {
        return this.repoUserExercise.getExercisesByIdUser(userId);
    }
}
