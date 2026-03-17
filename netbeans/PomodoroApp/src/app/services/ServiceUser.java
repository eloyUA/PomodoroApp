
package app.services;

import app.dao.UserDAO;
import app.dao.UserUserDAO;
import app.models.User;
import java.util.List;

public class ServiceUser {
    private UserDAO userDAO;
    private UserUserDAO userUserDAO;
    
    public ServiceUser(UserDAO userDAO, UserUserDAO userUserDAO) {
        this.userDAO = userDAO;
        this.userUserDAO = userUserDAO;
    }
    
    public void create(User user) throws Exception {
        this.userDAO.create(user);
    }
    
    public List<User> getFriendsUser(int idUser) throws Exception {
        return this.userUserDAO.getFriendsById(idUser);
    }
}
