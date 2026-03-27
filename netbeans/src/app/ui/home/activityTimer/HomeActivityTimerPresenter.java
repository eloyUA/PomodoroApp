
package app.ui.home.activityTimer;

import app.models.Exercise;
import app.models.UserExercise;
import app.services.ServiceActivity;
import app.services.ServiceExercise;
import app.ui.PresenterManager;
import app.ui.home.ActivityFormViewmodel;
import java.util.Date;

public class HomeActivityTimerPresenter {
    private String userId;
    private ServiceExercise serviceExercise;
    private ServiceActivity serviceActivity;
    
    private HomeActivityTimerView view;
    private ActivityFormViewmodel activityForm;
    private PresenterManager presenterManager;
    
    public HomeActivityTimerPresenter(
            String userId,
            ServiceExercise serviceExercise,
            ServiceActivity serviceActivity,
            HomeActivityTimerView view) {
        this.view = view;
        this.view.setEvtCancel(() -> this.evtCancel());
        this.view.setEvtComplete(() -> this.evtComplete());
        this.serviceExercise = serviceExercise;
        this.serviceActivity = serviceActivity;
    }
    
    public void load() {
        try {
            Exercise exercise = this.serviceExercise.chooseRandomExercise(activityForm);
            ActivityViewmodel activityViewmodel = new ActivityViewmodel(
                    exercise.getObjectId(),
                    exercise.getName(),
                    exercise.getDescription(),
                    activityForm.getTemporizer().getActivityTimeInMin()
            );
            this.view.setActivityViewmodel(activityViewmodel);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        this.view.open();
    }
    
    public void evtCancel() {
        this.view.close();
        this.presenterManager.getHomeStudyTimerPresenter().load();
    }
    
    public void evtComplete() {
        ActivityViewmodel activityViewmodel = this.view.getActivityViewmodel();
        UserExercise userExercise = new UserExercise(
                this.userId, activityViewmodel.getIdExercise(),
                new Date(), activityForm.getTemporizer().getStudyTimeInMin(),
                this.view.getTimerInMin(), 0);
        
        try {
            this.serviceActivity.createUserExercise(userExercise);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        this.view.close();
        this.presenterManager.getHomeStudyTimerPresenter().load();
    }
    
    public void setActivityForm(ActivityFormViewmodel form) {
        this.activityForm = form;
    }
    
    public void setPresenterManager(PresenterManager presenter) {
        this.presenterManager = presenter;
    }
}