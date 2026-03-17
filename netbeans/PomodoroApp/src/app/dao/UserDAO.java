
package app.dao;

import app.models.User;

public interface UserDAO {
    void create(User user) throws Exception;
    void deleteById(int id) throws Exception;
    void update(User user) throws Exception;
    User getById(int id) throws Exception;
}