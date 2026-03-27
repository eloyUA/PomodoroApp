
package app.ui.home;

public class ActivityFormViewmodel {
    private EnumZone zone;
    private EnumDifficulty difficulty;
    private EnumTemporizer temporizer;
    
    public ActivityFormViewmodel() {
        
    }
    
    public ActivityFormViewmodel(
            EnumZone zone,
            EnumDifficulty difficulty,
            EnumTemporizer temporizer) {
        
        this.zone = zone;
        this.difficulty = difficulty;
        this.temporizer = temporizer;
    }
    
    public void setZone(EnumZone zone) {
        this.zone = zone;
    }
    
    public EnumZone getZone() {
        return this.zone;
    }
    
    public void setDifficulty(EnumDifficulty difficulty) {
        this.difficulty = difficulty;
    }
    
    public EnumDifficulty getDifficulty() {
        return this.difficulty;
    }
    
    public void setTemporizer(EnumTemporizer temporizer) {
        this.temporizer = temporizer;
    }
    
    public EnumTemporizer getTemporizer() {
        return this.temporizer;
    }
}