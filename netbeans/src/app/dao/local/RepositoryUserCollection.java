
package app.dao.local;

import app.dao.RepositoryUser;
import app.models.User;
import java.util.ArrayList;
import java.util.List;

public class RepositoryUserCollection implements RepositoryUser {
    private List<User> users = new ArrayList<>();

    public RepositoryUserCollection() {
        
    }

    @Override
    public void create(User user) throws Exception {
        for (User usr : this.users) {
            if(usr.getObjectId().equals(user.getObjectId())) {
                throw new Exception("Id user already exists.");
            }
        }
        this.users.add(user);
    }

    @Override
    public void deleteById(String objectId) throws Exception {
        if (this.users.isEmpty()) {
            throw new Exception("There aren't users.");
        }

        for (int i = 0; i < this.users.size(); i++) {
            User currentUser = this.users.get(i);
            if (currentUser.getObjectId().equals(objectId)) {
                this.users.remove(i);
                return;
            }
        }
        throw new Exception("Id user not exists.");
    }

    @Override
    public void update(User user) throws Exception {
        if (this.users.isEmpty()) {
            throw new Exception("There aren't users.");
        }

        for (int i = 0; i < this.users.size(); i++) {
            User currentUser = this.users.get(i);
            if (currentUser.getObjectId().equals(user.getObjectId())) {
                currentUser.update(user);
                return;
            }
        }
        throw new Exception("Id user not exists.");
    }

    @Override
    public User getById(String objectId) throws Exception {
        if (this.users.isEmpty()) {
            throw new Exception("There aren't users.");
        }
        
        for (User usr : this.users) {
            if(usr.getObjectId().equals(objectId)) {
                return new User(usr);
            }
        }
        throw new Exception("Id user not exists.");
    }
}
