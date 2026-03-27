package app.ui.friendship;

public class ProfileViewmodel {
    private String id;
    private String name;
    
    public ProfileViewmodel() {
        
    }
    
    public ProfileViewmodel(String id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public ProfileViewmodel(ProfileViewmodel profile) {
        this.id = profile.getId();
        this.name = profile.getName();
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getId(){
        return id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
}