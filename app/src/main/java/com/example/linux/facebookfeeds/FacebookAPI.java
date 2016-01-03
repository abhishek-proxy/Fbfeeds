package com.example.linux.facebookfeeds;
import android.telecom.Call;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by Linux on 1/3/16.
 */
public interface FacebookAPI {

    @GET("/{id}/feed")
    public void getFacebookfeeds(@Path("id") String pageId,@Query("access_token") String accessToken,Callback<FacebookFeeds> feeds);


}
