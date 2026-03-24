package app.dao;

import app.models.Exercise;
import java.util.ArrayList;
import java.util.List;

public class RepositoryExerciseCollection implements RepositoryExercise {
    private List<Exercise> exercises = new ArrayList<>();

    public RepositoryExerciseCollection() {

    }

    @Override
    public void create(Exercise exercise) throws Exception {
        for (Exercise ex : this.exercises) {
            if (ex.getObjectId().equals(exercise.getObjectId())) {
                throw new Exception("Id exercise already exists.");
            }
        }
        this.exercises.add(exercise);
    }

    @Override
    public void deleteById(String objectId) throws Exception {
        if (this.exercises.isEmpty()) {
            throw new Exception("There aren't exercises.");
        }

        for (int i = 0; i < this.exercises.size(); i++) {
            Exercise currentExercise = this.exercises.get(i);

            if (currentExercise.getObjectId().equals(objectId)) {
                this.exercises.remove(i);
                return;
            }
        }
        throw new Exception("Id exercise not exists.");
    }

    @Override
    public void update(Exercise exercise) throws Exception {
        if (this.exercises.isEmpty()) {
            throw new Exception("There aren't exercises.");
        }

        for (int i = 0; i < this.exercises.size(); i++) {
            Exercise currentExercise = this.exercises.get(i);

            if (currentExercise.getObjectId().equals(exercise.getObjectId())) {
                currentExercise.update(exercise);
                return;
            }
        }
        throw new Exception("Id exercise not exists.");
    }

    @Override
    public Exercise getById(String objectId) throws Exception {
        if (this.exercises.isEmpty()) {
            throw new Exception("There aren't exercises.");
        }

        for (Exercise ex : this.exercises) {
            if (ex.getObjectId().equals(objectId)) {
                return new Exercise(ex);
            }
        }
        throw new Exception("Id exercise not exists.");
    }

    @Override
    public List<Exercise> getAll() throws Exception {
        return new ArrayList<>(this.exercises);
    }
}