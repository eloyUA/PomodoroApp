
package app.ui.home.views;

import app.ui.home.viewmodels.ExerciseViewmodel;

public class HomeActivityTimerViewConsole implements HomeActivityTimerView {
    private int durationInMin;
    private ExerciseViewmodel exercise;
    private Runnable evtComplete;
    private Runnable evtCancel;
    
    public HomeActivityTimerViewConsole() {
        
    }
    
    @Override
    public void open() {
        System.out.println("Inicio (Temporizador Ejercicio):");
        System.out.println("    Ejercicio a realizar:");
        if (this.exercise == null) {
            System.out.println("        Sin datos.");
        }
        else {
            System.out.println("        Nombre: " + this.exercise.getName());
            System.out.println("        Descripcion: " + this.exercise.getDescription());
        }
        
        try  {
            for (int tMin = 0; tMin < this.durationInMin; tMin++) {
                for (int i = 0; i < 60; i++) {
                    Thread.sleep(1000);
                    System.out.println("Tiempo: " + tMin + ":" + i);
                }
            }
        }
        catch (Exception ex) {}
        this.evtComplete.run();
    }

    @Override
    public void close() {
        System.out.println("------------------------------------------------------------------------------");
    }

    @Override
    public void setDurationActivityInMin(int duration) {
        this.durationInMin = duration;
    }

    @Override
    public void setExercise(ExerciseViewmodel exercise) {
        this.exercise = exercise;
    }

    @Override
    public void setEvtComplete(Runnable evtComplete) {
        this.evtComplete = evtComplete;
    }

    @Override
    public void setEvtCancel(Runnable evtCancel) {
        this.evtCancel = evtCancel;
    }
}
