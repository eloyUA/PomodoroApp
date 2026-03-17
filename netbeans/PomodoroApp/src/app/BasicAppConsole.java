
package app;

import app.dao.UserDAO;
import app.dao.UserDAOCollection;
import app.dao.UserUserDAO;
import app.dao.UserUserDAOCollection;
import app.models.User;
import app.models.UserUser;
import app.services.ServiceUser;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class BasicAppConsole {
    private Scanner keyboard;
    private ServiceUser serviceUser;
    
    private User user;
    
    public BasicAppConsole(ServiceUser serviceUser) {
        keyboard = new Scanner(System.in);
        this.serviceUser = serviceUser;
    }
    
    public void run() throws Exception {
        user = new User("Invitado", 0, 0);
        serviceUser.create(user);
        
        int opcion = 4;
        do {
            System.out.println("Menu:");
            System.out.println("    1) Inicio.");
            System.out.println("    2) Amigos.");
            System.out.println("    3) Historial.");
            System.out.println("    4) Salir.");

            do {
                try {
                    System.out.print("    Opción -> ");
                    opcion = Integer.parseInt(this.keyboard.nextLine());
                }
                catch (Exception ex) {}
            } while (opcion < 1 || opcion > 4);

            System.out.println("-------------------------------------------------");
            switch (opcion) {
                case 1: this.showHomeScreen(); break;
                case 2: this.showFriendScreen(); break;
                case 3: this.showHistoryScreen(); break;
                default: break;
            }
            System.out.println("-------------------------------------------------");
        } while (opcion != 4);
    }
    
    private void showHomeScreen() {
        System.out.println("Inicio:");
        System.out.println("    Formulario:");
        System.out.print("        1) Lugar de estudio (CASA, BIBLIOTECA) -> ");
        String studyZone = this.keyboard.nextLine();
        System.out.print("        2) Dificultades posibles (BAJA, ALTA) -> ");
        String difficultyLevel = this.keyboard.nextLine();
        System.out.print("        3) Temporizadores posibles (TEMP_25_5, TEMP_45_10, TEMP_90_10) -> ");
        String timingInMin = this.keyboard.nextLine();
        int studyTimeInMin = 1, exerciseTimeInMin = 1;
        if (timingInMin.equals("TEMP_25_5")) {
            studyTimeInMin = 25;
            exerciseTimeInMin = 5;
        }
        else if (timingInMin.equals("TEMP_45_10")) {
            studyTimeInMin = 45;
            exerciseTimeInMin = 10;
        }
        else if (timingInMin.equals("TEMP_90_10")) {
            studyTimeInMin = 90;
            exerciseTimeInMin = 10;
        }
        System.out.println("-------------------------------------------------");
        this.showHomeScreenStudy(studyZone, difficultyLevel, studyTimeInMin, exerciseTimeInMin);
    }
    
    private void showHomeScreenStudy(
            String studyZone,
            String difficultyLevel,
            int studyTimeInMin,
            int exerciseTimeInMin) {
        
        System.out.println("Inicio (Estudiando):");
        try  {
            for (int tMin = 0; tMin < studyTimeInMin; tMin++) {
                for (int i = 0; i < 60; i++) {
                    Thread.sleep(1000);
                    System.out.println("Tiempo: " + tMin + ":" + i);
                }
            }
        }
        catch (Exception ex) {}
        
        System.out.println("-------------------------------------------------");
        this.showHomeScreenExercise(studyZone, difficultyLevel, exerciseTimeInMin);
    }
    
    // TODO
    private void showHomeScreenExercise(
            String studyZone,
            String difficultyLevel,
            int exerciseTimeInMin) {
        
        System.out.println("Inicio (Ejercitando):");
        System.out.println("    Ejercicio a realizar:");
        // Tenemos que elegir un ejercicio aleatorio
        System.out.println("        Nombre: ---");
        System.out.println("        Descripcion: ---");
        
        try  {
            for (int tMin = 0; tMin < exerciseTimeInMin; tMin++) {
                for (int i = 0; i < 60; i++) {
                    Thread.sleep(1000);
                    System.out.println("Tiempo: " + tMin + ":" + i);
                }
            }
        }
        catch (Exception ex) {}
        // Tenemos que apuntar el ejercicio como hecho
    }
    
    // TODO
    private void showFriendScreen() throws Exception {
        List<User> friends = this.serviceUser.getFriendsUser(this.user.getId());
        
        System.out.println("Amigos:");
        System.out.println("    Ranking:");
        System.out.println("        Usuario    TiempoEstudio    TiempoMedioEjercicio    Metros    Puntos");
        for (User user : friends) {
            // TODO
        }
        System.out.println("          ---           ---                 ---              ---        ---");
        
        System.out.println("    Perfil:");
        System.out.println("        Nombre: " + this.user.getName());
        System.out.println("        Tu id: " + this.user.getId());
        
        int opcion;
        do {
            System.out.println("    Opciones:");
            System.out.println("        1) Cerrar pantalla Amigos.");
            System.out.println("        2) Agregar un amigo.");
            System.out.println("        3) Actualizar perfil.");

            do {
                try {
                    System.out.print("            Opcion -> ");
                    opcion = Integer.parseInt(this.keyboard.nextLine());
                    System.out.println("");
                } catch (Exception ex) { opcion = -1; }
            } while (opcion < 1 || opcion > 3);

            if (opcion == 2) {
                // Tenemos que agregar un amigo
            }
            else if (opcion == 3) {
                // Tenemos que actualizar el perfil del usuario
            }
        } while (opcion != 1);
    }
    
    // TODO
    private void showHistoryScreen() {
        System.out.println("Historial:");
        System.out.println("    Fecha       Ejercicio       Tiempo");
        // Tenemos que consultar el historial
        System.out.println("    ---            ---            ---");
        
        System.out.println("    Análisis:");
        // Tenemos que consultar el analisis
        System.out.println("        Tiempo de estudio: ---");
        System.out.println("        Tiempo medio ejercicio: ---");
        System.out.println("        Metros recorridos: ---");
    }
    
    public static void main(String[] args) throws Exception {
        UserDAO userDAO = new UserDAOCollection();
        UserUserDAO userUserDAO = new UserUserDAOCollection();
        ServiceUser serviceUser = new ServiceUser(userDAO, userUserDAO);
        new BasicAppConsole(serviceUser).run();
    }
}