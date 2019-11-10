package harisangriawan.mymovie339;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

import harisangriawan.mymovie339.adapter.MovieAdapter;
import harisangriawan.mymovie339.api.ApiClient;
import harisangriawan.mymovie339.api.ApiInterface;
import harisangriawan.mymovie339.model.Movie;
import harisangriawan.mymovie339.model.Result;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    ImageView poster;
    TextView Judul, Rating, Release, Bahasa, Overview;

    Result result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        poster = (ImageView)findViewById(R.id.poster);
        Judul = (TextView)findViewById(R.id.judul);
        Rating = (TextView)findViewById(R.id.rating);
        Release = (TextView)findViewById(R.id.release);
        Bahasa = (TextView)findViewById(R.id.bahasa);
        Overview = (TextView)findViewById(R.id.overview);

        result = new GsonBuilder()
                .create()
                .fromJson(getIntent().getStringExtra("movie"), Result.class);

        Picasso.with(DetailActivity.this)
                .load("http://image.tmdb.org/t/p/w185/"+result.getPosterPath())
                .into(poster);
        Judul.setText(result.getTitle());
        Rating.setText(Double.toString(result.getVoteAverage()));
        Release.setText(result.getReleaseDate());
        Bahasa.setText(result.getOriginalLanguage());
        Overview.setText(result.getOverview());

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.list_sort_setting, menu);

        return true;
    }

}
