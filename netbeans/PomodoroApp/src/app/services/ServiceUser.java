
package app.services;

import app.models.User;
import app.dao.RepositoryUser;

public class ServiceUser {
    private RepositoryUser repoUser;
    
    public ServiceUser(RepositoryUser userDAO) {
        this.repoUser = userDAO;
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
}
