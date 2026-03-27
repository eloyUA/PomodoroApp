package app.dao.online;

import app.dao.RepositoryExercise;
import app.models.Exercise;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RepositoryExerciseBack4app implements RepositoryExercise {

    private final String API_URL = "https://parseapi.back4app.com/classes/sd";
    private final String APPLICATION_ID = "3bUw8LFMiAfo3Bu9M3kQpMfW3Fo21laL4ZnpzdyE";
    private final String REST_API_KEY = "UIRhZL4cjNpLcguhsw9AlEAbc7lEfburAyrw0aqe";

    public class SkipObjectIdStrategy implements ExclusionStrategy {
        @Override
        public boolean shouldSkipClass(Class<?> clazz) {
            return false;
        }

        @Override
        public boolean shouldSkipField(FieldAttributes fa) {
            return fa.getName().equals("objectId");
        }
    }

    @Override
    public void insert(Exercise exercise) throws Exception {
        OkHttpClient client = new OkHttpClient();

        Gson gson = new GsonBuilder()
                .addSerializationExclusionStrategy(new SkipObjectIdStrategy())
                .create();

        String json = gson.toJson(exercise);

        RequestBody body = RequestBody.create(
                json,
                okhttp3.MediaType.parse("application/json; charset=utf-8")
        );

        Request request = new Request.Builder()
                .url(API_URL)
                .addHeader("X-Parse-Application-Id", APPLICATION_ID)
                .addHeader("X-Parse-REST-API-Key", REST_API_KEY)
                .post(body)
                .build();

        try {
            Response response = client.newCall(request).execute();

            if (!response.isSuccessful()) {
                throw new Exception("Error creating exercise");
            }

            String responseBody = response.body().string();
            JsonObject jsonResponse = new Gson().fromJson(responseBody, JsonObject.class);

            if (jsonResponse.has("objectId")) {
                exercise.setId(jsonResponse.get("objectId").getAsString());
            }

        } catch (IOException ex) {
            throw new Exception("Connection error");
        }
    }

    @Override
    public void deleteById(String objectId) throws Exception {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(API_URL + "/" + objectId)
                .addHeader("X-Parse-Application-Id", APPLICATION_ID)
                .addHeader("X-Parse-REST-API-Key", REST_API_KEY)
                .delete()
                .build();

        try {
            Response response = client.newCall(request).execute();

            if (!response.isSuccessful()) {
                throw new Exception("Error deleting exercise");
            }

        } catch (IOException ex) {
            throw new Exception("Connection error");
        }
    }

    @Override
    public void update(Exercise exercise) throws Exception {
        if (exercise.getObjectId() == null) {
            throw new Exception("Exercise id is null");
        }

        OkHttpClient client = new OkHttpClient();

        Gson gson = new GsonBuilder()
                .addSerializationExclusionStrategy(new SkipObjectIdStrategy())
                .create();

        String json = gson.toJson(exercise);

        RequestBody body = RequestBody.create(
                json,
                okhttp3.MediaType.parse("application/json; charset=utf-8")
        );

        Request request = new Request.Builder()
                .url(API_URL + "/" + exercise.getObjectId())
                .addHeader("X-Parse-Application-Id", APPLICATION_ID)
                .addHeader("X-Parse-REST-API-Key", REST_API_KEY)
                .put(body)
                .build();

        try {
            Response response = client.newCall(request).execute();

            if (!response.isSuccessful()) {
                throw new Exception("Error updating exercise");
            }

        } catch (IOException ex) {
            throw new Exception("Connection error");
        }
    }

    @Override
    public Exercise getById(String objectId) throws Exception {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(API_URL + "/" + objectId)
                .addHeader("X-Parse-Application-Id", APPLICATION_ID)
                .addHeader("X-Parse-REST-API-Key", REST_API_KEY)
                .get()
                .build();

        try {
            Response response = client.newCall(request).execute();

            if (!response.isSuccessful()) {
                throw new Exception("Error getting exercise");
            }

            String responseBody = response.body().string();
            JsonObject json = new Gson().fromJson(responseBody, JsonObject.class);

            Exercise exercise = new Exercise();
            exercise.setId(json.get("objectId").getAsString());
            exercise.setName(json.get("name").getAsString());
            exercise.setDescription(json.get("description").getAsString());
            exercise.setStudyZone(json.get("studyZone").getAsString());
            exercise.setDifficultyLevel(json.get("difficultyLevel").getAsString());

            return exercise;

        } catch (IOException ex) {
            throw new Exception("Connection error");
        }
    }

    @Override
    public List<Exercise> getAll() throws Exception {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(API_URL)
                .addHeader("X-Parse-Application-Id", APPLICATION_ID)
                .addHeader("X-Parse-REST-API-Key", REST_API_KEY)
                .get()
                .build();

        List<Exercise> exercises = new ArrayList<>();

        try {
            Response response = client.newCall(request).execute();

            if (!response.isSuccessful()) {
                throw new Exception("Error getting exercises");
            }

            String responseBody = response.body().string();
            JsonObject json = new Gson().fromJson(responseBody, JsonObject.class);
            JsonArray results = json.getAsJsonArray("results");

            for (int i = 0; i < results.size(); i++) {
                JsonObject obj = results.get(i).getAsJsonObject();

                Exercise exercise = new Exercise();
                exercise.setId(obj.get("objectId").getAsString());
                exercise.setName(obj.get("name").getAsString());
                exercise.setDescription(obj.get("description").getAsString());
                exercise.setStudyZone(obj.get("studyZone").getAsString());
                exercise.setDifficultyLevel(obj.get("difficultyLevel").getAsString());

                exercises.add(exercise);
            }

            return exercises;

        } catch (IOException ex) {
            throw new Exception("Connection error");
        }
    }
}