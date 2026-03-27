package app.ui.history;

import app.services.ServiceActivity;
import app.services.ServiceUser;
import java.util.ArrayList;
import java.util.List;

public class HistoryPresenter {

    private String userId;
    private HistoryView view;
    private ServiceUser serviceUser;
    private ServiceActivity serviceActivity;

    public HistoryPresenter(
            String userId,
            ServiceUser serviceUser,
            ServiceActivity serviceActivity,
            HistoryView view) {
        this.view = view;
        this.userId = userId;
        this.serviceUser = serviceUser;
        this.serviceActivity = serviceActivity;
    }
    
    public void load() {
        this.loadHistory();
        this.loadAnalitics();
        this.view.open();
    }

    public void loadHistory() {
        List<RowHistoryViewmodel> history = new ArrayList<>();
        try {
            history = this.serviceActivity.getActivityHistoryByIdUser(userId);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            this.view.setHistory(history);
        }
    }
    
    public void loadAnalitics() {
        AnaliticsViewmodel analitics = new AnaliticsViewmodel();
        try {
            this.serviceUser.getAnaliticsByIdUser(userId);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            this.view.setAnalitics(analitics);
        }
    }
}