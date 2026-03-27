
package app.services;

import app.models.User;
import app.dao.RepositoryUser;
import app.ui.friendship.ProfileViewmodel;
import app.ui.history.AnaliticsViewmodel;

public class ServiceUser {
    private RepositoryUser repoUser;
    
    public ServiceUser(RepositoryUser repoUser) {
        this.repoUser = repoUser;
    }
    
    public void createUser(User user) throws Exception {
        this.repoUser.create(user);
    }
    
    public void updateUser(User user) throws Exception {
        this.repoUser.update(user);
    }
    
    public void deleteUserById(String objectId) throws Exception {
        this.repoUser.deleteById(objectId);
    }
    
    public User getUserById(String objectId) throws Exception {
        return this.repoUser.getById(objectId);
    }
    
    public AnaliticsViewmodel getAnaliticsByIdUser(String userId) throws Exception {
        User user = this.repoUser.getById(userId);
        return new AnaliticsViewmodel(
                user.getStudyTimeInMin(),
                user.getMeanExerciseTimeInMin(),
                user.getMeters()
        );
    }
    
    public ProfileViewmodel getProfileByIdUser(String userId) throws Exception {
        User user = this.repoUser.getById(userId);
        return new ProfileViewmodel(userId, user.getName());
    }
}