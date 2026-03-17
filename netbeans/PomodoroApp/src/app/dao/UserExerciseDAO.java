
package app.dao;

import app.models.Exercise;
import app.models.UserExercise;
import java.util.List;

public interface UserExerciseDAO {
    void create(UserExercise relation) throws Exception;
    void delete(UserExercise relation) throws Exception;
    List<Exercise> getExerciseByIdUser(int idUser) throws Exception;
}