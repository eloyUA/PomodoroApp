package app.dao;

import app.models.User;
import app.models.UserUser;
import java.util.ArrayList;
import java.util.List;

public class RepositoryUserUserCollection implements RepositoryUserUser {
    private List<UserUser> relation = new ArrayList<>();

    @Override
    public void create(UserUser rel) throws Exception {
        for (UserUser r : relation) {
            if (r.getIdUserStart().equals(rel.getIdUserStart()) &&
                r.getIdUserFinish().equals(rel.getIdUserFinish())) {
                throw new Exception("Relationship already exists.");
            }
        }
        relation.add(rel);
    }

    @Override
    public void delete(UserUser rel) throws Exception {
        if (relation.isEmpty()) {
            throw new Exception("Relationship is empty.");
        }
        
        for (int i = 0; i < relation.size(); i++) {
            UserUser current = relation.get(i);
            if (current.getIdUserStart().equals(rel.getIdUserStart()) &&
                current.getIdUserFinish().equals(rel.getIdUserFinish())) {
                relation.remove(i);
                return;
            }
        }
        throw new Exception("Relationship not found.");
    }

    @Override
    public List<User> getFriendsById(String idUser) throws Exception {
        List<User> friends = new ArrayList<>();
        for (UserUser r : relation) {
            if (r.getIdUserStart().equals(idUser)) {
                User friend = new User();
                friend.setObjectId(r.getIdUserFinish());
                friends.add(friend);
            }
        }
        return friends;
    }
}