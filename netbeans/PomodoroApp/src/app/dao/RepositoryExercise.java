
package app.dao;

import app.models.Exercise;
import java.util.List;

public interface RepositoryExercise {
    void create(Exercise exercise) throws Exception;
    void deleteById(String objectId) throws Exception;
    void update(Exercise exercise) throws Exception;
    Exercise getById(String objectId) throws Exception;
    List<Exercise> getAll() throws Exception;
}
