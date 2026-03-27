package app.ui.menu;

import app.ui.PresenterManager;

public class MenuPresenter {
    private MenuView view;
    private PresenterManager presenterManager;
    
    public MenuPresenter(MenuView view) {
        this.view = view;
        this.view.setEvtHome(() -> this.evtHome());
        this.view.setEvtFriendship(() -> this.evtFriendship());
        this.view.setEvtHistory(() -> this.evtHistory());
    }
    
    public void load() {
        this.view.open();
    }
    
    public void evtHome() {
        this.view.close();
        this.presenterManager.getHomeFormPresenter().load();
    }
    
    public void evtFriendship() {
        this.view.close();
        this.presenterManager.getFriendshipPresenter().load();
    }
    
    public void evtHistory() {
        this.view.close();
        this.presenterManager.getHistoryPresenter().load();
    }
    
    public void setPresenterManager(PresenterManager presenterManager) {
        this.presenterManager = presenterManager;
    }
}