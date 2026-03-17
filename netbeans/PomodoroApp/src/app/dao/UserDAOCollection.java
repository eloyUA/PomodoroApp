
package app.dao;

import app.models.User;
import java.util.ArrayList;
import java.util.List;

public class UserDAOCollection implements UserDAO {
    private List<User> users = new ArrayList<>();

    public UserDAOCollection() {
        
    }

    @Override
    public void create(User user) throws Exception {
        for (User usr : this.users) {
            if(usr.getId() == user.getId()) {
                throw new Exception("Id user already exists.");
            }
        }
        this.users.add(user);
    }

    @Override
    public void deleteById(int id) throws Exception {
        if (this.users.isEmpty()) {
            throw new Exception("There aren't users.");
        }

        for (int i = 0; i < this.users.size(); i++) {
            User currentUser = this.users.get(i);
            if (currentUser.getId() == id) {
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
            if (currentUser.getId() == user.getId()) {
                currentUser.update(user);
                return;
            }
        }
        throw new Exception("Id user not exists.");
    }

    @Override
    public User getById(int id) throws Exception {
        if (this.users.isEmpty()) {
            throw new Exception("There aren't users.");
        }
        
        for (User usr : this.users) {
            if(usr.getId() == id) {
                return new User(usr);
            }
        }
        throw new Exception("Id user not exists.");
    }
}
