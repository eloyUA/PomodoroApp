
package app.models;

public class UserUser {
    private int idUserStart;
    private int idUserFinish;
    
    public UserUser() {
        
    }
    
    public UserUser(UserUser relation) {
        this.idUserStart = relation.getIdUserStart();
        this.idUserFinish = relation.getIdUserFinish();
    }
    
    public int getIdUserStart() {
        return idUserStart;
    }

    public void setIdUserStart(int idUserStart) {
        this.idUserStart = idUserStart;
    }

    public int getIdUserFinish() {
        return idUserFinish;
    }

    public void setIdUserFinish(int idUserFinish) {
        this.idUserFinish = idUserFinish;
    }
    
}