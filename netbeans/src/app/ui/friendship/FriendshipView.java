package app.ui.friendship;

import app.ui.friendship.ProfileViewmodel;
import app.ui.friendship.RowRankingViewmodel;
import java.util.List;

public interface FriendshipView {
    void open();
    void close();
    void setRanking(List<RowRankingViewmodel> ranking);
    void setProfile(ProfileViewmodel profile);
    void setEvtChangeName(Runnable evtChangeName);
    void setEvtAddFriend(Runnable evtAddFriend);
    String getFriendId();
    String getNewName();
}