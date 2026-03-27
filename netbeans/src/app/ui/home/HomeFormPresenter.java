
package app.ui.home;

import app.ui.PresenterManager;

public class HomeFormPresenter {
    private HomeFormView view;
    private PresenterManager presenterManager;
    
    public HomeFormPresenter(HomeFormView view) {
        this.view = view;
        this.view.setEvtStart(() -> this.evtStart());
    }
    
    public void load() {
        this.view.open();
    }
    
    public void evtStart() {
        this.view.close();
        
        ActivityFormViewmodel form = this.view.getActivityForm();
        this.presenterManager.getHomeStudyTimerPresenter().setActivityForm(form);
        this.presenterManager.getHomeStudyTimerPresenter().load();
    }
    
    public void setPresenterManager(PresenterManager presenterManager) {
        this.presenterManager = presenterManager;
    }
}