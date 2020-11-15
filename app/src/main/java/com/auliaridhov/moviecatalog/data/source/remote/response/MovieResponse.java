package com.auliaridhov.moviecatalog.data.source.remote.response;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class MovieResponse implements Parcelable {

	@SerializedName("page")
	private int page;

	@SerializedName("total_pages")
	private int totalPages;

	@SerializedName("results")
	private List<ResultsItem> results;

	@SerializedName("total_results")
	private int totalResults;

	public MovieResponse(int page, int totalPages, List<ResultsItem> results, int totalResults) {
		this.page = page;
		this.totalPages = totalPages;
		this.results = results;
		this.totalResults = totalResults;
	}

	protected MovieResponse(Parcel in) {
		page = in.readInt();
		totalPages = in.readInt();
		totalResults = in.readInt();
	}

	public static final Creator<MovieResponse> CREATOR = new Creator<MovieResponse>() {
		@Override
		public MovieResponse createFromParcel(Parcel in) {
			return new MovieResponse(in);
		}

		@Override
		public MovieResponse[] newArray(int size) {
			return new MovieResponse[size];
		}
	};

	public int getPage(){
		return page;
	}

	public int getTotalPages(){
		return totalPages;
	}

	public List<ResultsItem> getResults(){
		return results;
	}

	public int getTotalResults(){
		return totalResults;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeInt(page);
		parcel.writeInt(totalPages);
		parcel.writeInt(totalResults);
	}
}