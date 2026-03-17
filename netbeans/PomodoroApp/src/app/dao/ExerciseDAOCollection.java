package app.dao;

import app.models.Exercise;
import java.util.ArrayList;
import java.util.List;

public class ExerciseDAOCollection implements ExerciseDAO {
    private List<Exercise> exercises = new ArrayList<>();

    public ExerciseDAOCollection() {

    }

    @Override
    public void create(Exercise exercise) throws Exception {
        for (Exercise ex : this.exercises) {
            if (ex.getId() == exercise.getId()) {
                throw new Exception("Id exercise already exists.");
            }
        }
        this.exercises.add(exercise);
    }

    @Override
    public void deleteById(int id) throws Exception {
        if (this.exercises.isEmpty()) {
            throw new Exception("There aren't exercises.");
        }

        for (int i = 0; i < this.exercises.size(); i++) {
            Exercise currentExercise = this.exercises.get(i);

            if (currentExercise.getId() == id) {
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

            if (currentExercise.getId() == exercise.getId()) {
                currentExercise.update(exercise);
                return;
            }
        }
        throw new Exception("Id exercise not exists.");
    }

    @Override
    public Exercise getById(int id) throws Exception {
        if (this.exercises.isEmpty()) {
            throw new Exception("There aren't exercises.");
        }

        for (Exercise ex : this.exercises) {
            if (ex.getId() == id) {
                return new Exercise(ex);
            }
        }
        throw new Exception("Id exercise not exists.");
    }
}