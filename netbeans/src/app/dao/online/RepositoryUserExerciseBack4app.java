package app.dao.online;

import app.dao.RepositoryUserExercise;
import app.models.Exercise;
import app.models.UserExercise;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RepositoryUserExerciseBack4app implements RepositoryUserExercise {

    private final String API_URL = "https://parseapi.back4app.com/classes/UserExercise";
    private final String APPLICATION_ID = "3bUw8LFMiAfo3Bu9M3kQpMfW3Fo21laL4ZnpzdyE";
    private final String REST_API_KEY = "UIRhZL4cjNpLcguhsw9AlEAbc7lEfburAyrw0aqe";

    @Override
    public void create(UserExercise relation) throws Exception {
        OkHttpClient client = new OkHttpClient();

        Gson gson = new Gson();
        String json = gson.toJson(relation);

        RequestBody body = RequestBody.create(
                json,
                okhttp3.MediaType.parse("application/json; charset=utf-8")
        );

        Request request = new Request.Builder()
                .url(API_URL)
                .addHeader("X-Parse-Application-Id", APPLICATION_ID)
                .addHeader("X-Parse-REST-API-Key", REST_API_KEY)
                .addHeader("Content-Type", "application/json")
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new Exception("Error creating relationship");
            }
        } catch (IOException ex) {
            throw new Exception("Connection error");
        }
    }

    @Override
    public void deleteByIds(String userId, String exerciseId) throws Exception {
        OkHttpClient client = new OkHttpClient();

        String where = "{\"idUser\":\"" + userId + "\",\"idExercise\":\"" + exerciseId + "\"}";

        HttpUrl url = HttpUrl.parse(API_URL)
                .newBuilder()
                .addQueryParameter("where", where)
                .build();

        Request requestFind = new Request.Builder()
                .url(url)
                .addHeader("X-Parse-Application-Id", APPLICATION_ID)
                .addHeader("X-Parse-REST-API-Key", REST_API_KEY)
                .addHeader("Content-Type", "application/json")
                .get()
                .build();

        try (Response responseFind = client.newCall(requestFind).execute()) {
            if (!responseFind.isSuccessful() || responseFind.body() == null) {
                throw new Exception("Relationship not found");
            }

            String responseJson = responseFind.body().string();
            Gson gson = new Gson();
            JsonObject json = gson.fromJson(responseJson, JsonObject.class);
            JsonArray results = json.getAsJsonArray("results");

            if (results.size() == 0) {
                throw new Exception("Relationship not found");
            }

            String objectId = results.get(0).getAsJsonObject().get("objectId").getAsString();

            Request requestDelete = new Request.Builder()
                    .url(API_URL + "/" + objectId)
                    .addHeader("X-Parse-Application-Id", APPLICATION_ID)
                    .addHeader("X-Parse-REST-API-Key", REST_API_KEY)
                    .addHeader("Content-Type", "application/json")
                    .delete()
                    .build();

            try (Response responseDelete = client.newCall(requestDelete).execute()) {
                if (!responseDelete.isSuccessful()) {
                    throw new Exception("Relationship not found");
                }
            }
        } catch (IOException ex) {
            throw new Exception("Connection error");
        }
    }

    @Override
    public List<Exercise> getExercisesByIdUser(String idUser) throws Exception {
        List<Exercise> exercises = new ArrayList<>();
        OkHttpClient client = new OkHttpClient();

        String where = "{\"idUser\":\"" + idUser + "\"}";

        HttpUrl url = HttpUrl.parse(API_URL)
                .newBuilder()
                .addQueryParameter("where", where)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .addHeader("X-Parse-Application-Id", APPLICATION_ID)
                .addHeader("X-Parse-REST-API-Key", REST_API_KEY)
                .addHeader("Content-Type", "application/json")
                .get()
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                String responseJson = response.body().string();

                Gson gson = new Gson();
                JsonObject json = gson.fromJson(responseJson, JsonObject.class);
                JsonArray results = json.getAsJsonArray("results");

                for (int i = 0; i < results.size(); i++) {
                    JsonObject obj = results.get(i).getAsJsonObject();

                    Exercise exercise = new Exercise();
                    exercise.setObjectId(obj.get("idExercise").getAsString());
                    exercises.add(exercise);
                }
            }
        } catch (IOException ex) {
            throw new Exception("Connection error");
        }

        return exercises;
    }
}