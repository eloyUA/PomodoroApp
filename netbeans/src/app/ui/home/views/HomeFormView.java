
package app.ui.home.views;

import app.ui.home.viewmodels.ActivityFormViewmodel;

public interface HomeFormView {
    void open();
    void close();
    void setEvtStart(Runnable evtComenzar);
    ActivityFormViewmodel getActivityForm();
}