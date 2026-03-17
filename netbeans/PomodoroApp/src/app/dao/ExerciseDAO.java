
package app.dao;

import app.models.Exercise;

public interface ExerciseDAO {
    void create(Exercise exercise) throws Exception;
    void deleteById(int id) throws Exception;
    void update(Exercise exercise) throws Exception;
    Exercise getById(int id) throws Exception;
}
