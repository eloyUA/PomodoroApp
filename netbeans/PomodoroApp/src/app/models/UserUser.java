
package app.models;

public class UserUser {
    private String idUserStart;
    private String idUserFinish;
    
    public UserUser() {
        
    }
    
    public UserUser(String idUserStart, String idUserFinish) {
        this.idUserStart = idUserStart;
        this.idUserFinish = idUserFinish;
    }
    
    public UserUser(UserUser relation) {
        this.idUserStart = relation.getIdUserStart();
        this.idUserFinish = relation.getIdUserFinish();
    }
    
    public String getIdUserStart() {
        return idUserStart;
    }

    public void setIdUserStart(String idUserStart) {
        this.idUserStart = idUserStart;
    }

    public String getIdUserFinish() {
        return idUserFinish;
    }

    public void setIdUserFinish(String idUserFinish) {
        this.idUserFinish = idUserFinish;
    }
    
}