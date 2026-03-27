package app.ui.friendship;

import java.util.ArrayList;
import java.util.List;

import app.models.User;
import app.services.ServiceFriendship;
import app.services.ServiceUser;
public class FriendshipPresenter {

    private String userId;
    private FriendshipView view;
    private ServiceUser serviceUser;
    private ServiceFriendship serviceFriendship;
    
    public FriendshipPresenter(
            String userId,
            ServiceUser serviceUser,
            ServiceFriendship serviceFriendship,
            FriendshipView view) {
        this.userId = userId;
        this.serviceUser = serviceUser;
        this.serviceFriendship = serviceFriendship;
        
        this.view = view;
        this.view.setEvtAddFriend(() -> this.evtAddFriend());
        this.view.setEvtChangeName(() -> this.evtChangeName());
    }
    
    public void load() {
        this.loadProfile();
        this.loadRanking();
        this.view.open();
    }
    
    private void loadProfile() {
        ProfileViewmodel profile = new ProfileViewmodel();
        try {
            profile = this.serviceUser.getProfileByIdUser(this.userId);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            this.view.setProfile(profile);
        }
    }
    
    private void loadRanking() {
        List<RowRankingViewmodel> ranking = new ArrayList<>();
        try {
            ranking = this.serviceFriendship.getFriendRankingByIdUser(this.userId);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            this.view.setRanking(ranking);
        }
    }
    
    public void evtAddFriend() {
        try {
            String idFriend = this.view.getFriendId();
            this.serviceFriendship.addFriendToUserById(userId, idFriend);
            this.loadRanking();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void evtChangeName() {
        try {
            String newName = this.view.getNewName();
            User user = this.serviceUser.getUserById(this.userId);
            user.setName(newName);
            this.serviceUser.updateUser(user);
            this.loadProfile();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}