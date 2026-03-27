
package app.ui.home.studyTimer;

public interface HomeStudyTimerView {
    void open();
    void close();
    void setDurationInMin(int duration);
    void setEvtTimeExpired(Runnable evtTimeExpired);
    void setEvtFinish(Runnable evtFinish);
}