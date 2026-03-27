package app.services;

import app.dao.RepositoryUserUser;
import app.models.User;
import app.models.UserUser;
import app.ui.friendship.RowRankingViewmodel;
import java.util.ArrayList;
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
    
    public List<RowRankingViewmodel> getFriendRankingByIdUser(String userId) throws Exception {
        List<RowRankingViewmodel> ranking = new ArrayList<>();
        List<User> friends = this.repoUserUser.getFriendsById(userId);
        for (User friend : friends) {
            ranking.add(new RowRankingViewmodel(
                friend.getObjectId(),
                friend.getName(),
                friend.getStudyTimeInMin(),
                friend.getMeanExerciseTimeInMin(),
                friend.getMeters(),
                friend.getScore()
            ));
        }
        return ranking;
    }
}
