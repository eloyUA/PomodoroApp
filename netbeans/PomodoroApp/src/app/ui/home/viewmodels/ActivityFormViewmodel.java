
package app.ui.home.viewmodels;

import app.ui.home.enums.DifficultyEnum;
import app.ui.home.enums.DifficultyEnum;
import app.ui.home.enums.TemporizerEnum;
import app.ui.home.enums.TemporizerEnum;
import app.ui.home.enums.ZoneEnum;
import app.ui.home.enums.ZoneEnum;

public class ActivityFormViewmodel {
    private ZoneEnum zone;
    private DifficultyEnum difficulty;
    private TemporizerEnum temporizer;
    
    public ActivityFormViewmodel() {
        
    }
    
    public ActivityFormViewmodel(
            ZoneEnum zone,
            DifficultyEnum difficulty,
            TemporizerEnum temporizer) {
        
        this.zone = zone;
        this.difficulty = difficulty;
        this.temporizer = temporizer;
    }
    
    public void setZone(ZoneEnum zone) {
        this.zone = zone;
    }
    
    public ZoneEnum getZone() {
        return this.zone;
    }
    
    public void setDifficulty(DifficultyEnum difficulty) {
        this.difficulty = difficulty;
    }
    
    public DifficultyEnum getDifficulty() {
        return this.difficulty;
    }
    
    public void setTemporizer(TemporizerEnum temporizer) {
        this.temporizer = temporizer;
    }
    
    public TemporizerEnum getTemporizer() {
        return this.temporizer;
    }
}