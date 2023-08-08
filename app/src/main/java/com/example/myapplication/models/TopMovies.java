package com.example.myapplication.models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class TopMovies{

	@SerializedName("TopMovies")
	private List<TopMoviesItem> topMovies;

	public List<TopMoviesItem> getTopMovies(){
		return topMovies;
	}
}