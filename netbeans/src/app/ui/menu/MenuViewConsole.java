
package app.ui.menu;

import java.util.Scanner;

public class MenuViewConsole implements MenuView {
    private Scanner keyboard;
    private Runnable evtHome;
    private Runnable evtFriendship;
    private Runnable evtHistory;
    
    public MenuViewConsole() {
        this.keyboard = new Scanner(System.in);
    }
    
    @Override
    public void open() {
        System.out.println("Menu:");
        System.out.println("    1) Inicio.");
        System.out.println("    2) Amigos.");
        System.out.println("    3) Historial.");
        
        int opcion = -1;
        do {
            try {
                System.out.print("    Opción -> ");
                opcion = Integer.parseInt(keyboard.nextLine());
            }
            catch (Exception ex) {}
        } while (opcion < 1 || opcion > 3);
        
        switch (opcion){
            case 1: this.evtHome.run(); break;
            case 2: this.evtFriendship.run(); break;
            case 3: this.evtHistory.run(); break;
        }
    }

    @Override
    public void close() {
        System.out.println("------------------------------------------------------------------------------");
    }

    @Override
    public void setEvtHome(Runnable evtHome) {
        this.evtHome = evtHome;
    }

    @Override
    public void setEvtFriendship(Runnable evtFriendship) {
        this.evtFriendship = evtFriendship;
    }

    @Override
    public void setEvtHistory(Runnable evtHistory) {
        this.evtHistory = evtHistory;
    }   
}