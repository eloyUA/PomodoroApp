
package app.ui.home.views;

import app.ui.home.enums.DifficultyEnum;
import app.ui.home.enums.TemporizerEnum;
import app.ui.home.enums.ZoneEnum;
import app.ui.home.viewmodels.ActivityFormViewmodel;
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
        ZoneEnum zones[] = ZoneEnum.values();
        String strZonasPosibles = "";
        for (ZoneEnum zona : zones) {
            strZonasPosibles += zona.toString() + " ";
        }
        
        DifficultyEnum difficulties[] = DifficultyEnum.values();
        String strDificultadesPosibles = "";
        for (DifficultyEnum difficulty : difficulties) {
            strDificultadesPosibles += difficulty.toString() + " ";
        }
        
        TemporizerEnum temporizers[] = TemporizerEnum.values();
        String strTemporizadoresPosibles = "";
        for (TemporizerEnum temporizer : temporizers) {
            strTemporizadoresPosibles += temporizer.toString() + " ";
        }
        
        System.out.println("Inicio:");
        System.out.println("    Formulario:");
        System.out.print("        1) Lugar de estudio (" + strZonasPosibles + ") -> ");
        ZoneEnum zone = ZoneEnum.valueOf(this.keyboard.nextLine());
        System.out.print("        2) Dificultades posibles (" + strDificultadesPosibles + ") -> ");
        DifficultyEnum difficulty = DifficultyEnum.valueOf(this.keyboard.nextLine());
        System.out.print("        3) Temporizadores posibles (" + strTemporizadoresPosibles + ") -> ");
        TemporizerEnum temporizer = TemporizerEnum.valueOf(this.keyboard.nextLine());
        
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
