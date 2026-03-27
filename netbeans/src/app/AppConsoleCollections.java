
package app;

import app.dao.RepositoryExercise;
import app.dao.RepositoryUser;
import app.dao.RepositoryUserExercise;
import app.dao.RepositoryUserUser;
import app.dao.local.RepositoryExerciseCollection;
import app.dao.local.RepositoryUserCollection;
import app.dao.local.RepositoryUserExerciseCollection;
import app.dao.local.RepositoryUserUserCollection;
import app.models.Exercise;
import app.models.User;
import app.services.ServiceActivity;
import app.services.ServiceExercise;
import app.services.ServiceFriendship;
import app.services.ServiceUser;
import app.ui.PresenterManager;
import app.ui.friendship.FriendshipPresenter;
import app.ui.friendship.FriendshipView;
import app.ui.friendship.FriendshipViewConsole;
import app.ui.history.HistoryPresenter;
import app.ui.history.HistoryView;
import app.ui.history.HistoryViewConsole;
import app.ui.home.EnumDifficulty;
import app.ui.home.EnumZone;
import app.ui.home.HomeFormPresenter;
import app.ui.home.HomeFormView;
import app.ui.home.HomeFormViewConsole;
import app.ui.home.activityTimer.HomeActivityTimerPresenter;
import app.ui.home.activityTimer.HomeActivityTimerView;
import app.ui.home.activityTimer.HomeActivityTimerViewConsole;
import app.ui.home.studyTimer.HomeStudyTimerPresenter;
import app.ui.home.studyTimer.HomeStudyTimerView;
import app.ui.home.studyTimer.HomeStudyTimerViewConsole;
import app.ui.menu.MenuPresenter;
import app.ui.menu.MenuView;
import app.ui.menu.MenuViewConsole;
import java.util.ArrayList;
import java.util.List;

public class AppConsoleCollections {
    public static void main(String[] args) throws Exception {
        // Create user and exercises
        User user = new User("Pepe");
        List<Exercise> exercises = new ArrayList<>();
        exercises.add(new Exercise(
                "Flexiones", "Hacer entre 10 y 20 flexiones",
                EnumZone.HOME.toString(),
                EnumDifficulty.LOW.toString()));
        exercises.add(new Exercise(
                "Burpies", "Hacer entre 20 y 25 burpees seguidos",
                EnumZone.HOME.toString(),
                EnumDifficulty.HIGH.toString()));
        exercises.add(new Exercise(
                "Rodear árboles", "Salir a la calle y rodear 3 árboles",
                EnumZone.LIBRARY.toString(),
                EnumDifficulty.LOW.toString()));
        exercises.add(new Exercise(
                "Subir árboles", "Salir a la calle y subir a 1 o 2 árboles",
                EnumZone.LIBRARY.toString(),
                EnumDifficulty.HIGH.toString()));
        
        // Create repositories
        RepositoryUser repoUser = new RepositoryUserCollection();
        RepositoryExercise repoExercise = new RepositoryExerciseCollection();
        RepositoryUserUser repoUserUser = new RepositoryUserUserCollection();
        RepositoryUserExercise repoUserExercise = new RepositoryUserExerciseCollection();
        
        repoUser.create(user);
        for (Exercise ex : exercises) {
            repoExercise.insert(ex);
        }
        
        // Create services
        ServiceUser serviceUser = new ServiceUser(repoUser);
        ServiceExercise serviceExercise = new ServiceExercise(repoExercise);
        ServiceFriendship serviceFriendship = new ServiceFriendship(repoUserUser);
        ServiceActivity serviceActivity = new ServiceActivity(repoUser, repoUserExercise, repoExercise);
        
        // Create views and presenters
        MenuView menuView = new MenuViewConsole();
        MenuPresenter menuPresenter = new MenuPresenter(menuView);
        
        HomeFormView homeFormView = new HomeFormViewConsole();
        HomeFormPresenter homeFormPresenter = new HomeFormPresenter(homeFormView);
        
        HomeStudyTimerView homeStudyTimerView = new HomeStudyTimerViewConsole();
        HomeStudyTimerPresenter homeStudyTimerPresenter = new HomeStudyTimerPresenter(homeStudyTimerView);
        
        HomeActivityTimerView homeActivityTimerView = new HomeActivityTimerViewConsole();
        HomeActivityTimerPresenter homeActivityTimerPresenter = new HomeActivityTimerPresenter(
                user.getObjectId(), serviceExercise, serviceActivity, homeActivityTimerView);
    
        FriendshipView friendshipView = new FriendshipViewConsole();
        FriendshipPresenter friendshipPresenter = new FriendshipPresenter(
                user.getObjectId(), serviceUser, serviceFriendship, friendshipView);
        
        HistoryView historyView = new HistoryViewConsole();
        HistoryPresenter historyPresenter = new HistoryPresenter(
                user.getObjectId(), serviceUser, serviceActivity, historyView);
        
        // Inyect dependencies
        PresenterManager presenterManager = new PresenterManager();
        presenterManager.setMenuPresenter(menuPresenter);
        presenterManager.setFriendshipPresenter(friendshipPresenter);
        presenterManager.setHistoryPresenter(historyPresenter);
        presenterManager.setHomeFormPresenter(homeFormPresenter);
        presenterManager.setHomeStudyTimerPresenter(homeStudyTimerPresenter);
        presenterManager.setHomeActivityTimerPresenter(homeActivityTimerPresenter);
        
        menuPresenter.setPresenterManager(presenterManager);
        homeFormPresenter.setPresenterManager(presenterManager);
        homeStudyTimerPresenter.setPresenterManager(presenterManager);
        homeActivityTimerPresenter.setPresenterManager(presenterManager);
    
        // Run program
        menuPresenter.load();
    }
}