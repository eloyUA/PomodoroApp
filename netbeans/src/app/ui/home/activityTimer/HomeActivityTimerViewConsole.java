
package app.ui.home.activityTimer;

public class HomeActivityTimerViewConsole implements HomeActivityTimerView {
    private int timerInSec;
    private ActivityViewmodel activiy;
    private Runnable evtComplete;
    private Runnable evtCancel; // Este no lo usamos en la consola
    
    public HomeActivityTimerViewConsole() {
        
    }
    
    @Override
    public void open() {
        System.out.println("Inicio (Temporizador Ejercicio):");
        System.out.println("    Ejercicio a realizar:");
        if (this.activiy == null) {
            System.out.println("        Sin datos.");
        }
        else {
            System.out.println("        Nombre: " + this.activiy.getName());
            System.out.println("        Descripcion: " + this.activiy.getDescription());
        }
        
        try  {
            for (int tMin = 0; tMin < this.activiy.getDurationInMin(); tMin++) {
                for (int i = 0; i < 60; i++) {
                    Thread.sleep(1000);
                    this.timerInSec += 1;
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
    public void setActivityViewmodel(ActivityViewmodel activity) {
        this.activiy = activity;
    }

    @Override
    public void setEvtComplete(Runnable evtComplete) {
        this.evtComplete = evtComplete;
    }

    @Override
    public void setEvtCancel(Runnable evtCancel) {
        this.evtCancel = evtCancel;
    }

    @Override
    public ActivityViewmodel getActivityViewmodel() {
        return this.activiy;
    }

    @Override
    public int getTimerInMin() {
        return (int) ((float) (this.timerInSec) / (float) (60.0));
    }
}
