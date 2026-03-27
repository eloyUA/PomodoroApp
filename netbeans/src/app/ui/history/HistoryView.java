package app.ui.history;

import app.ui.history.AnaliticsViewmodel;
import app.ui.history.RowHistoryViewmodel;
import java.util.List;

public interface HistoryView {
    void open();
    void close();
    void setHistory(List<RowHistoryViewmodel> history);
    void setAnalitics(AnaliticsViewmodel analitics);
}