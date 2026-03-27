
package app.ui.home.studyTimer;


public class HomeStudyTimerViewConsole implements HomeStudyTimerView {
    private int durationInMin;
    private Runnable evtTimeExpired;
    private Runnable evtFinish;
    
    public HomeStudyTimerViewConsole() {
        
    }

    @Override
    public void open() {
        System.out.println("Inicio (Temporizador Estudio):");
        try  {
            for (int tMin = 0; tMin < this.durationInMin; tMin++) {
                for (int i = 0; i < 60; i++) {
                    Thread.sleep(1000);
                    System.out.println("Tiempo: " + tMin + ":" + i);
                }
            }
        }
        catch (Exception ex) {}
        this.evtTimeExpired.run();
        this.evtFinish.run(); // Esto lo ponemos porque estamos con la consola, así solo se ejecuta 1 ejercicio
    }

    @Override
    public void close() {
        System.out.println("------------------------------------------------------------------------------");
    }
    
    @Override
    public void setDurationInMin(int duration) {
        this.durationInMin = duration;
    }

    @Override
    public void setEvtTimeExpired(Runnable evtTimeExpired) {
        this.evtTimeExpired = evtTimeExpired;
    }

    @Override
    public void setEvtFinish(Runnable evtFinish) {
        this.evtFinish = evtFinish;
    }
}
