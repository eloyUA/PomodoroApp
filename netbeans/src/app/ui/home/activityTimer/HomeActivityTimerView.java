
package app.ui.home.activityTimer;

public interface HomeActivityTimerView {
    void open();
    void close();
    void setActivityViewmodel(ActivityViewmodel activity);
    void setEvtComplete(Runnable evtComplete);
    void setEvtCancel(Runnable evtCancel);
    ActivityViewmodel getActivityViewmodel();
    int getTimerInMin();
}