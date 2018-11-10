package com.example.esilvrod.prova_listaalunos;

import android.app.ListActivity;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends ListActivity {
    private final String BASE_URL = "https://provaddm2018.000webhostapp.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start();
    }

    private ApiAluno getRetrofit() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        return (new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()).create(ApiAluno.class);
    }

    private void start() {
        Call<List<Aluno>> call = getRetrofit().obterAluno();
        call.enqueue(new Callback<List<Aluno>>() {//chamada assíncrona
            public void onResponse(Call<List<Aluno>> call,
                                   Response<List<Aluno>> response) {
                int statusCode = response.code();
                List<Aluno> alunos = response.body();
                setListAdapter(new Adapter(MainActivity.this, alunos));

            }

            public void onFailure(Call<List<Aluno>> call, Throwable t) {
                // Log error here since request failed
                Log.i("teste", t.toString());
            }
        });
    }

}
