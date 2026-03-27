
package app.dao;

import app.models.User;

public interface RepositoryUser {
    void create(User user) throws Exception;
    void deleteById(String objectId) throws Exception;
    void update(User user) throws Exception;
    User getById(String objectId) throws Exception;
}