package app.ui.friendship;

import app.ui.friendship.ProfileViewmodel;
import app.ui.friendship.RowRankingViewmodel;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FriendshipViewConsole implements FriendshipView {
    private Scanner keyboard;
    
    private List<RowRankingViewmodel> ranking;
    private ProfileViewmodel profile;
    private Runnable evtChangeName;
    private Runnable evtAddFriend;
    private String friendId;
    private String newName;
    
    public FriendshipViewConsole() {
        this.keyboard = new Scanner(System.in);
    }
    
    @Override
    public void open() {
        System.out.println("Amigos:");
        System.out.println("    Ranking:");
        if (this.ranking == null) {
            System.out.println("        Sin datos.");
        }
        else {
            System.out.println("        Usuario    TiempoEstudio    TiempoMedioEjercicio    Metros    Puntos");
            for (RowRankingViewmodel fila : this.ranking) {
                System.out.print("        " + fila.getName());
                System.out.print("   " + fila.getStudyTimeInMin());
                System.out.print("   " + fila.getMeanTimeExerciseInMin());
                System.out.print("   " + fila.getMeters());
                System.out.println("   " + fila.getScore());
            }
        }
        
        System.out.println("    Perfil:");
        if (this.profile == null) {
            System.out.println("        Sin datos.");
        }
        else {
            System.out.println("        Nombre: " + this.profile.getName());
            System.out.println("        Tu id: " + this.profile.getId());
        }
        
        System.out.println("    Opciones:");
        System.out.println("        1) Cerrar.");
        System.out.println("        2) Agregar un amigo.");
        System.out.println("        3) Actualizar perfil.");
        
        int opcion;
        do {
            try {
                System.out.print("            Opcion -> ");
                opcion = Integer.parseInt(this.keyboard.nextLine());
                System.out.println("");
            } catch (Exception ex) { opcion = -1; }
        } while (opcion < 1 || opcion > 3);
        
        switch (opcion) {
            case 1: this.close(); break;
            case 2: 
                System.out.println("Agregar un amigo");
                System.out.println("    Id amigo -> ");
                this.friendId = this.keyboard.nextLine();
                this.evtAddFriend.run(); break;
            case 3:
                System.out.println("Actualizar perfil");
                System.out.println("    Nombre -> ");
                this.newName = this.keyboard.nextLine();
                this.evtChangeName.run(); break;
            default: break;
        }
    }

    @Override
    public void close() {
        System.out.println("------------------------------------------------------------------------------");
    }

    @Override
    public void setRanking(List<RowRankingViewmodel> ranking) {
        this.ranking = new ArrayList<>(ranking);
    }

    @Override
    public void setProfile(ProfileViewmodel profile) {
        this.profile = new ProfileViewmodel(profile);
    }

    @Override
    public void setEvtChangeName(Runnable evtChangeName) {
        this.evtChangeName = evtChangeName;
    }

    @Override
    public void setEvtAddFriend(Runnable evtAddFriend) {
        this.evtAddFriend = evtAddFriend;
    }

    @Override
    public String getFriendId() {
        return this.friendId;
    }
    
    @Override
    public String getNewName() {
        return this.newName;
    }
}
