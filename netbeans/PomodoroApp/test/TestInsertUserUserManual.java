

import app.dao.online.RepositoryUserBack4app;
import app.dao.online.RepositoryUserUser;
import app.models.User;
import app.models.UserUser;

public class TestInsertUserUserManual {

    public static void main(String[] args) {
        RepositoryUserBack4app userRepo = new RepositoryUserBack4app();
        RepositoryUserUser relationRepo = new RepositoryUserUser();

        User user1 = null;
        User user2 = null;

        try {
            String suffix = String.valueOf(System.currentTimeMillis());

            user1 = new User();
            user1.setName("User1 " + suffix);
            user1.setStudyTimeInMin(10);
            user1.setScore(50);
            userRepo.create(user1);

            if (user1.getObjectId() == null) {
                throw new Exception("ERROR: no se ha insertado el user1");
            }

            user2 = new User();
            user2.setName("User2 " + suffix);
            user2.setStudyTimeInMin(20);
            user2.setScore(80);
            userRepo.create(user2);

            if (user2.getObjectId() == null) {
                throw new Exception("ERROR: no se ha insertado el user2");
            }

            UserUser relation = new UserUser();
            relation.setIdUserStart(user1.getObjectId());
            relation.setIdUserFinish(user2.getObjectId());

            relationRepo.create(relation);

            System.out.println("TEST OK: relacion UserUser insertada correctamente");
            System.out.println("User start: " + user1.getObjectId());
            System.out.println("User finish: " + user2.getObjectId());

        } catch (Exception ex) {
            System.out.println("TEST ERROR: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}