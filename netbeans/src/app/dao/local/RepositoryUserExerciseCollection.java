package app.dao.local;

import app.dao.RepositoryUserExercise;
import app.models.Exercise;
import app.models.UserExercise;
import java.util.ArrayList;
import java.util.List;

public class RepositoryUserExerciseCollection implements RepositoryUserExercise {
    private List<UserExercise> relation = new ArrayList<>();

    @Override
    public void create(UserExercise rel) throws Exception {
        for (UserExercise r : relation) {
            if (r.getIdUser().equals(rel.getIdUser()) &&
                r.getIdExercise().equals(rel.getIdExercise())) {
                throw new Exception("Relationship already exists.");
            }
        }
        relation.add(rel);
    }

    @Override
    public void deleteByIds(String userId, String exerciseId) throws Exception {
        if (relation.isEmpty()) {
            throw new Exception("Relationship is empty.");
        }
        
        for (int i = 0; i < relation.size(); i++) {
            UserExercise current = relation.get(i);
            if (current.getIdUser().equals(userId) &&
                current.getIdExercise().equals(exerciseId)) {
                relation.remove(i);
                return;
            }
        }
        throw new Exception("Relationship not found.");
    }

    @Override
    public List<UserExercise> getExercisesByIdUser(String idUser) throws Exception {
        List<UserExercise> exercises = new ArrayList<>();
        for (UserExercise r : relation) {
            if (r.getIdUser().equals(idUser)) {
                exercises.add(r);
            }
        }
        return exercises;
    }
}