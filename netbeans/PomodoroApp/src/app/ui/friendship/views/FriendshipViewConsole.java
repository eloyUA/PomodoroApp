package app.ui.friendship.views;

import app.ui.friendship.viewmodels.ProfileViewmodel;
import app.ui.friendship.viewmodels.RowRankingViewmodel;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FriendshipViewConsole implements FriendshipView {
    private Scanner keyboard;
    
    private List<RowRankingViewmodel> ranking;
    private ProfileViewmodel profile;
    private int friendId;
    private Runnable evtChangeName;
    private Runnable evtAddFriend;
    
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
                System.out.println("   " + fila.getPoints());
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
        System.out.println("        1) Cerrar pantalla Amigos.");
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
            case 2: this.evtAddFriend.run(); break;
            case 3: this.evtChangeName.run(); break;
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
    public void setProfile(ProfileViewmodel perfil) {
        this.profile = new ProfileViewmodel(perfil);
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
    public List<RowRankingViewmodel> getRanking() {
        return new ArrayList<>(this.ranking);
    }

    @Override
    public ProfileViewmodel getProfile() {
        return new ProfileViewmodel(this.profile);
    }

    @Override
    public int getFriendId() {
        return this.friendId;
    }
}
