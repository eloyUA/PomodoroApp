
package app.ui.home;

public interface HomeFormView {
    void open();
    void close();
    void setEvtStart(Runnable evtComenzar);
    ActivityFormViewmodel getActivityForm();
}