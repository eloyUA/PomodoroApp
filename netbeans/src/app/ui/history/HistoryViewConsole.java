package app.ui.history;

import app.ui.history.AnaliticsViewmodel;
import app.ui.history.RowHistoryViewmodel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HistoryViewConsole implements HistoryView {
    private List<RowHistoryViewmodel> history;
    private AnaliticsViewmodel analitics;
    
    public HistoryViewConsole() {
        
    }
    
    @Override
    public void open() {
        System.out.println("Historial:");
        if (this.history == null) {
            System.out.println("    Sin datos.");
        }
        else {
            System.out.println("    Fecha       Ejercicio       Tiempo");
            for (RowHistoryViewmodel fila : history) {
                Date fecha = fila.getDate();
                String nombreEjercicio = fila.getNameExercise();
                int tiempo = fila.getDurationInMin();

                System.out.println(fecha + "    " + nombreEjercicio + "    " + tiempo);
            }
        }
        
        System.out.println("    Analíticas:");
        if (this.analitics == null) {
            System.out.println("        Sin datos.");
        }
        else {
            System.out.println("        Tiempo de estudio: " + this.analitics.getStudyTimeInMin());
            System.out.println("        Tiempo medio ejercicio: "  + this.analitics.getMeanExerciseTimeInMin());
            System.out.println("        Metros recorridos:" + this.analitics.getMeters());
        }
    }

    @Override
    public void close() {
        System.out.println("------------------------------------------------------------------------------");
    }

    @Override
    public void setHistory(List<RowHistoryViewmodel> history) {
        this.history = new ArrayList<>(history);
    }

    @Override
    public void setAnalitics(AnaliticsViewmodel analitics) {
        this.analitics = new AnaliticsViewmodel(analitics);
    }
}