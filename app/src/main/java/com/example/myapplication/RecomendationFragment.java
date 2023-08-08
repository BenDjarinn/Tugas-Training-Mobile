package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myapplication.adapters.FilmAdapter;
import com.example.myapplication.models.TopMovies;
import com.example.myapplication.models.TopMoviesItem;
import com.example.myapplication.utils.apiinterface;
import com.example.myapplication.utils.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecomendationFragment extends Fragment {
    RecyclerView rvFilm;
    List<TopMoviesItem> filmList = new ArrayList<>();
    FilmAdapter filmAdapter;
    private int CURRENT_PAGE = 1;


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_recomendation, container, false);

        rvFilm = view.findViewById(R.id.rv_film);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        filmAdapter = new FilmAdapter(filmList, getActivity());
        rvFilm.setAdapter(filmAdapter);
        rvFilm.setLayoutManager(linearLayoutManager);

        apiinterface apiInterface = RetrofitInstance.getRetrofitInstance().create(apiinterface.class);
        Call<TopMovies> call = apiInterface.getTopMovies(CURRENT_PAGE);
        call.enqueue(new Callback<TopMovies>() {
            @Override
            public void onResponse(Call<TopMovies> call, Response<TopMovies> response) {
                TopMovies topMovies = response.body();
                assert topMovies != null;
                filmList.addAll(topMovies.getTopMovies());
                filmAdapter.setTopMoviesItems(filmList);
            }

            @Override
            public void onFailure(Call<TopMovies> call, Throwable t) {
                Toast.makeText(getActivity(), "error", Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }
}