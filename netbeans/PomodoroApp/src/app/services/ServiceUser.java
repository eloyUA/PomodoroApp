
package app.services;

import app.models.User;
import java.util.List;
import app.dao.RepositoryUser;
import app.dao.RepositoryUserUser;
import app.models.UserUser;

public class ServiceUser {
    private RepositoryUser repoUser;
    private RepositoryUserUser repoUserUser;
    
    public ServiceUser(RepositoryUser userDAO, RepositoryUserUser userUserDAO) {
        this.repoUser = userDAO;
        this.repoUserUser = userUserDAO;
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
    
    public void addFriendToUserById(String userId, String friendId) throws Exception {
        UserUser userUser = new UserUser(userId, friendId);
        this.repoUserUser.create(userUser);
    }
    
    public void deleteFriendToUserById(String userId, String friendId) throws Exception {
        UserUser userUser = new UserUser(userId, friendId);
        this.repoUserUser.delete(userUser);
    }
    
    public List<User> getFriendsUser(String userId) throws Exception {
        return this.repoUserUser.getFriendsById(userId);
    }
}
