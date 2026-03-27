package app.services;

import app.dao.RepositoryUser;
import app.dao.RepositoryUserExercise;
import app.models.Exercise;
import app.models.User;
import app.models.UserExercise;
import java.util.List;

public class ServiceActivity {
    private RepositoryUser repoUser;
    private RepositoryUserExercise repoUserExercise;
    
    public ServiceActivity(
            RepositoryUser repoUser,
            RepositoryUserExercise repoUserExercise) {
        
        this.repoUser = repoUser;
        this.repoUserExercise = repoUserExercise;
    }
    
    public void createUserExercise(UserExercise userExercise) throws Exception {
        this.repoUserExercise.create(userExercise);
        
        String idUser = userExercise.getIdUser();
        User user = this.repoUser.getById(idUser);
        user.finishActivity(
                userExercise.getPrevStudyTimeInMin(),
                userExercise.getDuration(),
                userExercise.getMeters());
        this.repoUser.update(user);
    }
    
    public List<Exercise> getExercisesByIdUser(String userId) throws Exception {
        return this.repoUserExercise.getExercisesByIdUser(userId);
    }
}
