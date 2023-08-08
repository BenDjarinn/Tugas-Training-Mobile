package com.example.myapplication.models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class TopMoviesItem{

	@SerializedName("overview")
	private String overview;

	@SerializedName("release_date")
	private int releaseDate;

	@SerializedName("genres")
	private List<String> genres;

	@SerializedName("rating")
	private Object rating;

	@SerializedName("id")
	private String id;

	@SerializedName("title")
	private String title;

	@SerializedName("poster")
	private String poster;

	public String getOverview(){
		return overview;
	}

	public int getReleaseDate(){
		return releaseDate;
	}

	public List<String> getGenres(){
		return genres;
	}

	public Object getRating(){
		return rating;
	}

	public String getId(){
		return id;
	}

	public String getTitle(){
		return title;
	}

	public String getPoster(){
		return poster;
	}
}