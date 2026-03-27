
package app.dao;

import app.models.UserExercise;
import java.util.List;

public interface RepositoryUserExercise {
    void create(UserExercise relation) throws Exception;
    void deleteByIds(String userId, String exerciseId) throws Exception;
    List<UserExercise> getExercisesByIdUser(String idUser) throws Exception;
}