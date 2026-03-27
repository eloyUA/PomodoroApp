package app.ui;

import app.ui.friendship.FriendshipPresenter;
import app.ui.history.HistoryPresenter;
import app.ui.home.HomeFormPresenter;
import app.ui.home.activityTimer.HomeActivityTimerPresenter;
import app.ui.home.studyTimer.HomeStudyTimerPresenter;
import app.ui.menu.MenuPresenter;

public class PresenterManager {
    private MenuPresenter menuPresenter;
    private HomeFormPresenter homeFormPresenter;
    private HomeStudyTimerPresenter homeStudyTimerPresenter;
    private HomeActivityTimerPresenter homeActivityTimerPresenter;
    private FriendshipPresenter friendshipPresenter;
    private HistoryPresenter historyPresenter;
    
    public PresenterManager() {
        
    }
    
    public void setMenuPresenter(MenuPresenter presenter) {
        this.menuPresenter = presenter;
    }

    public void setHomeFormPresenter(HomeFormPresenter presenter) {
        this.homeFormPresenter = presenter;
    }

    public void setHomeStudyTimerPresenter(HomeStudyTimerPresenter presenter) {
        this.homeStudyTimerPresenter = presenter;
    }

    public void setHomeActivityTimerPresenter(HomeActivityTimerPresenter presenter) {
        this.homeActivityTimerPresenter = presenter;
    }

    public void setFriendshipPresenter(FriendshipPresenter presenter) {
        this.friendshipPresenter = presenter;
    }

    public void setHistoryPresenter(HistoryPresenter presenter) {
        this.historyPresenter = presenter;
    }
    
    public MenuPresenter getMenuPresenter() {
        return menuPresenter;
    }

    public HomeFormPresenter getHomeFormPresenter() {
        return homeFormPresenter;
    }

    public HomeStudyTimerPresenter getHomeStudyTimerPresenter() {
        return homeStudyTimerPresenter;
    }

    public HomeActivityTimerPresenter getHomeActivityTimerPresenter() {
        return homeActivityTimerPresenter;
    }

    public FriendshipPresenter getFriendshipPresenter() {
        return friendshipPresenter;
    }

    public HistoryPresenter getHistoryPresenter() {
        return historyPresenter;
    }
}
