
package app.ui.home.views;

public interface HomeStudyTimerView {
    void open();
    void close();
    void setDurationInMin(int duration);
    void setEvtTimeExpired(Runnable evtTimeExpired);
    void setEvtCancel(Runnable evtCancel);
}