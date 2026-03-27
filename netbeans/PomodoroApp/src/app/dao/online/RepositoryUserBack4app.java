package app.dao.online;

import app.dao.RepositoryUser;
import app.models.User;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RepositoryUserBack4app implements RepositoryUser {

    private final String API_URL = "https://parseapi.back4app.com/classes/user";
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
    public void create(User user) throws Exception {
        OkHttpClient client = new OkHttpClient();

        Gson gson = new GsonBuilder()
                .addSerializationExclusionStrategy(new SkipObjectIdStrategy())
                .create();

        String json = gson.toJson(user);

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
                throw new Exception("Error creating user");
            }

            String responseBody = response.body().string();
            JsonObject jsonResponse = new Gson().fromJson(responseBody, JsonObject.class);

            if (jsonResponse.has("objectId")) {
                user.setObjectId(jsonResponse.get("objectId").getAsString());
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
                throw new Exception("Id user not exists.");
            }

        } catch (IOException ex) {
            throw new Exception("Connection error");
        }
    }

    @Override
    public void update(User user) throws Exception {
        if (user.getObjectId() == null) {
            throw new Exception("Id user not exists.");
        }

        OkHttpClient client = new OkHttpClient();

        Gson gson = new GsonBuilder()
                .addSerializationExclusionStrategy(new SkipObjectIdStrategy())
                .create();

        String json = gson.toJson(user);

        RequestBody body = RequestBody.create(
                json,
                okhttp3.MediaType.parse("application/json; charset=utf-8")
        );

        Request request = new Request.Builder()
                .url(API_URL + "/" + user.getObjectId())
                .addHeader("X-Parse-Application-Id", APPLICATION_ID)
                .addHeader("X-Parse-REST-API-Key", REST_API_KEY)
                .put(body)
                .build();

        try {
            Response response = client.newCall(request).execute();

            if (!response.isSuccessful()) {
                throw new Exception("Id user not exists.");
            }

        } catch (IOException ex) {
            throw new Exception("Connection error");
        }
    }

    @Override
    public User getById(String objectId) throws Exception {
        User user = null;
        OkHttpClient client = new OkHttpClient();

        String urlConId = API_URL + "/" + objectId;

        Request request = new Request.Builder()
                .url(urlConId)
                .addHeader("X-Parse-Application-Id", APPLICATION_ID)
                .addHeader("X-Parse-REST-API-Key", REST_API_KEY)
                .addHeader("Content-Type", "application/json")
                .get()
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                String responseJson = response.body().string();

                Gson gson = new Gson();
                user = gson.fromJson(responseJson, User.class);
            }
        } catch (IOException ex) {
            throw new Exception("Connection error");
        }

        return user;
    }
}