
package app.ui.home.views;

import app.ui.home.viewmodels.ExerciseViewmodel;

public interface HomeActivityTimerView {
    void open();
    void close();
    void setDurationActivityInMin(int duration);
    void setExercise(ExerciseViewmodel exercise);
    void setEvtComplete(Runnable evtComplete);
    void setEvtCancel(Runnable evtCancel);
}
