package com.kulsoom.covid19tracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new
        DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("https://api.covid19api.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SummaryService summaryService = retrofit.create(SummaryService.class);

        Call<Summary> summaryCall = summaryService.getSummary();
        summaryCall.enqueue(new Callback<Summary>() {
            @Override
            public void onResponse(Call<Summary> call, Response<Summary> response) {
                if (response.isSuccessful()){
                    adapter = new Adapter(response.body(),getApplicationContext());
                    recyclerView.setAdapter(adapter);
                }

            }

            @Override
            public void onFailure(Call<Summary> call, Throwable t) {
                Toast.makeText(MainActivity.this, " NO internet...!!!", Toast.LENGTH_SHORT).show();

            }
        });

    }
}