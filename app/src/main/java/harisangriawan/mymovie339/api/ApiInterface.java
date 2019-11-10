package harisangriawan.mymovie339.api;

import harisangriawan.mymovie339.model.Movie;
import retrofit2.Call;
import retrofit2.http.GET;


/**
 * Created by AnymX on 29/10/2018.
 */

public interface ApiInterface {

    public static String DB_API="d9c92cd61557bd3c5054361de8a4281e";

//    @GET("popular?api_key="+DB_API)
//    Call<Dates>getDates();

    @GET("popular?api_key="+DB_API)
    Call<Movie>getPopular();

    @GET("top_rated?api_key="+DB_API)
    Call<Movie>getRated();

}
