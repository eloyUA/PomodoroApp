package app.dao;

import app.models.Exercise;
import app.models.UserExercise;
import java.util.ArrayList;
import java.util.List;

public class UserExerciseDAOCollection implements UserExerciseDAO {
    private List<UserExercise> relation = new ArrayList<>();

    @Override
    public void create(UserExercise rel) throws Exception {
        for (UserExercise r : relation) {
            if (r.getIdUser()== rel.getIdUser()&&
                r.getIdExercise()== rel.getIdExercise()) {
                throw new Exception("Relationship already exists.");
            }
        }
        relation.add(rel);
    }

    @Override
    public void delete(UserExercise rel) throws Exception {
        if (relation.isEmpty()) {
            throw new Exception("Relationship is empty.");
        }
        
        for (int i = 0; i < relation.size(); i++) {
            UserExercise current = relation.get(i);
            if (current.getIdUser()== rel.getIdUser() &&
                current.getIdExercise()== rel.getIdExercise()) {
                relation.remove(i);
                return;
            }
        }
        throw new Exception("Relationship not found.");
    }

    @Override
    public List<Exercise> getExerciseByIdUser(int idUser) throws Exception {
        List<Exercise> exercises = new ArrayList<>();
        for (UserExercise r : relation) {
            if (r.getIdUser() == idUser) {
                Exercise exercise = new Exercise();
                exercise.setId(r.getIdExercise());
                exercises.add(exercise);
            }
        }
        return exercises;
    }
}