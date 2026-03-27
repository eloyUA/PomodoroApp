
package app.ui.home;

import java.util.Scanner;

public class HomeFormViewConsole implements HomeFormView {
    private Scanner keyboard;
    private ActivityFormViewmodel activityForm;
    private Runnable evtStart;
    
    public HomeFormViewConsole() {
        keyboard = new Scanner(System.in);
    }

    @Override
    public void open() {
        EnumZone zones[] = EnumZone.values();
        String strZonasPosibles = "";
        for (EnumZone zona : zones) {
            strZonasPosibles += zona.toString() + " ";
        }
        
        EnumDifficulty difficulties[] = EnumDifficulty.values();
        String strDificultadesPosibles = "";
        for (EnumDifficulty difficulty : difficulties) {
            strDificultadesPosibles += difficulty.toString() + " ";
        }
        
        EnumTemporizer temporizers[] = EnumTemporizer.values();
        String strTemporizadoresPosibles = "";
        for (EnumTemporizer temporizer : temporizers) {
            strTemporizadoresPosibles += temporizer.toString() + " ";
        }
        
        System.out.println("Inicio:");
        System.out.println("    Formulario:");
        System.out.print("        1) Lugar de estudio (" + strZonasPosibles + ") -> ");
        EnumZone zone = EnumZone.valueOf(this.keyboard.nextLine());
        System.out.print("        2) Dificultades posibles (" + strDificultadesPosibles + ") -> ");
        EnumDifficulty difficulty = EnumDifficulty.valueOf(this.keyboard.nextLine());
        System.out.print("        3) Temporizadores posibles (" + strTemporizadoresPosibles + ") -> ");
        EnumTemporizer temporizer = EnumTemporizer.valueOf(this.keyboard.nextLine());
        
        this.activityForm = new ActivityFormViewmodel(zone, difficulty, temporizer);
        this.evtStart.run();
    }

    @Override
    public void close() {
        System.out.println("------------------------------------------------------------------------------");
    }

    @Override
    public void setEvtStart(Runnable evtStart) {
        this.evtStart = evtStart;
    }

    @Override
    public ActivityFormViewmodel getActivityForm() {
        return this.activityForm;
    }
}
