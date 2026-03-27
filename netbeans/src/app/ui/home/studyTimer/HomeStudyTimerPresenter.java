
package app.ui.home.studyTimer;

import app.ui.PresenterManager;
import app.ui.home.ActivityFormViewmodel;
import app.ui.home.EnumTemporizer;

public class HomeStudyTimerPresenter {
    private HomeStudyTimerView view;
    private ActivityFormViewmodel activityForm;
    private PresenterManager presenterManager;
    
    public HomeStudyTimerPresenter(HomeStudyTimerView view) {
        this.view = view;
        this.view.setEvtFinish(() -> this.evtFinish());
        this.view.setEvtTimeExpired(() -> this.evtTimeExpired());
    }
    
    public void load() {
        EnumTemporizer temporizer = this.activityForm.getTemporizer();
        this.view.setDurationInMin(temporizer.getStudyTimeInMin());
        this.view.open();
    }
    
    public void evtFinish() {
        this.view.close();
        this.presenterManager.getHomeFormPresenter().load();
    }
    
    public void evtTimeExpired() {
        this.view.close();
        this.presenterManager.getHomeActivityTimerPresenter().load();
    }
    
    public void setPresenterManager(PresenterManager presenter) {
        this.presenterManager = presenter;
    }
    
    public void setActivityForm(ActivityFormViewmodel form) {
        this.activityForm = form;
    }
}