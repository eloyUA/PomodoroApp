package app.ui.history.views;

import app.ui.history.viewmodels.AnaliticsViewmodel;
import app.ui.history.viewmodels.RowHistoryViewmodel;
import java.util.List;

public interface HistoryView {
    void open();
    void close();
    void setHistory(List<RowHistoryViewmodel> history);
    void setAnalitics(AnaliticsViewmodel analitics);
}