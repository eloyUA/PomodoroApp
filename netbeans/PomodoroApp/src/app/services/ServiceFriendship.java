package app.services;

import app.dao.RepositoryUserUser;
import app.models.User;
import app.models.UserUser;
import java.util.List;

public class ServiceFriendship {
    private RepositoryUserUser repoUserUser;
    
    public ServiceFriendship(RepositoryUserUser repoUserUser) {
        this.repoUserUser = repoUserUser;
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
