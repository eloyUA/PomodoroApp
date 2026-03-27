package app.ui.friendship.views;

import app.ui.friendship.viewmodels.ProfileViewmodel;
import app.ui.friendship.viewmodels.RowRankingViewmodel;
import java.util.List;

public interface FriendshipView {
    void open();
    void close();
    void setRanking(List<RowRankingViewmodel> ranking);
    void setProfile(ProfileViewmodel perfil);
    void setEvtChangeName(Runnable evtCambiarNombre);
    void setEvtAddFriend(Runnable evtAgregarAmigo);
    List<RowRankingViewmodel> getRanking();
    ProfileViewmodel getProfile();
    int getFriendId();
}