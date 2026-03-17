
package app.dao;

import app.models.User;
import app.models.UserUser;
import java.util.List;

public interface UserUserDAO {
    void create(UserUser relation) throws Exception;
    void delete(UserUser relation) throws Exception;
    List<User> getFriendsById(int idUser) throws Exception;
}