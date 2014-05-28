package it.carlom.amandolaelezioni.app.api;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by carlo on 5/26/14.
 */
public interface ElezioneApi {

    public static final String API_URL = "http://1-dot-learned-hour-592.appspot.com/api";

    @POST("/updatesezione")
    public void updateSezione(Sezione sezione, Callback<List<Sezione>> callback);

    @GET("/getsezioni")
    public void getSezioni(Callback<List<Sezione>> callback);


}
