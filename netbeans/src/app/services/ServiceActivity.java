package app.services;

import app.dao.RepositoryExercise;
import app.dao.RepositoryUser;
import app.dao.RepositoryUserExercise;
import app.models.User;
import app.models.UserExercise;
import app.ui.history.RowHistoryViewmodel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceActivity {
    private RepositoryUser repoUser;
    private RepositoryUserExercise repoUserExercise;
    private RepositoryExercise repoExercise;
    
    public ServiceActivity(
            RepositoryUser repoUser,
            RepositoryUserExercise repoUserExercise,
            RepositoryExercise repoExercise) {
        
        this.repoUser = repoUser;
        this.repoUserExercise = repoUserExercise;
        this.repoExercise = repoExercise;
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
    
    public List<UserExercise> getExercisesByIdUser(String userId) throws Exception {
        return this.repoUserExercise.getExercisesByIdUser(userId);
    }
    
    public List<RowHistoryViewmodel> getActivityHistoryByIdUser(String userId) throws Exception {
        List<RowHistoryViewmodel> history = new ArrayList<>();
        Map<String, String> idExerciseToNameExercise = new HashMap<>();
        List<UserExercise> exercises = this.repoUserExercise.getExercisesByIdUser(userId);
        for (UserExercise userExercise : exercises) {

            String nameExercise;
            String exerciseId = userExercise.getIdExercise();
            if (!idExerciseToNameExercise.containsKey(exerciseId)) {
                nameExercise = this.repoExercise.getById(exerciseId).getName();
            }
            else {
                nameExercise = idExerciseToNameExercise.get(exerciseId);
            }

            history.add(new RowHistoryViewmodel(
                    userExercise.getDate(),
                    nameExercise,
                    userExercise.getDuration())
            );
        }
        return history;
    }
}
