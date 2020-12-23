package com.auliaridhov.moviecatalog.data.source.remote.response;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResultsItem implements Parcelable {


	@SerializedName("id")
	private int id;

	@SerializedName("overview")
	private String overview;

	@SerializedName("original_language")
	private String originalLanguage;

	@SerializedName("original_name")
	private String originalName;

	@SerializedName("original_title")
	private String originalTitle;

	@SerializedName("video")
	private boolean video;

	@SerializedName("title")
	private String title;


	@SerializedName("poster_path")
	private String posterPath;

	@SerializedName("backdrop_path")
	private String backdropPath;

	@SerializedName("release_date")
	private String releaseDate;

	@SerializedName("media_type")
	private String mediaType;

	@SerializedName("vote_average")
	private double voteAverage;

	@SerializedName("popularity")
	private double popularity;


	@SerializedName("adult")
	private boolean adult;

	@SerializedName("vote_count")
	private int voteCount;

	public ResultsItem(int id, String overview, String originalLanguage, String originalName, String originalTitle, boolean video, String title, String posterPath, String backdropPath, String releaseDate, String mediaType, double voteAverage, double popularity, boolean adult, int voteCount) {
		this.id = id;
		this.overview = overview;
		this.originalLanguage = originalLanguage;
		this.originalName = originalName;
		this.originalTitle = originalTitle;
		this.video = video;
		this.title = title;

		this.posterPath = posterPath;
		this.backdropPath = backdropPath;
		this.releaseDate = releaseDate;
		this.mediaType = mediaType;
		this.voteAverage = voteAverage;
		this.popularity = popularity;
		this.adult = adult;
		this.voteCount = voteCount;
	}

	public ResultsItem(Parcel in) {
		overview = in.readString();
		originalLanguage = in.readString();
		originalTitle = in.readString();
		video = in.readByte() != 0;
		title = in.readString();
		posterPath = in.readString();
		backdropPath = in.readString();
		releaseDate = in.readString();
		mediaType = in.readString();
		voteAverage = in.readDouble();
		popularity = in.readDouble();
		id = in.readInt();
		adult = in.readByte() != 0;
		voteCount = in.readInt();
		originalName = in.readString();
	}

	public static final Creator<ResultsItem> CREATOR = new Creator<ResultsItem>() {
		@Override
		public ResultsItem createFromParcel(Parcel in) {
			return new ResultsItem(in);
		}

		@Override
		public ResultsItem[] newArray(int size) {
			return new ResultsItem[size];
		}
	};

	public String getOriginalName() {
		return originalName;
	}

	public String getOverview(){
		return overview;
	}

	public String getOriginalLanguage(){
		return originalLanguage;
	}

	public String getOriginalTitle(){
		return originalTitle;
	}

	public boolean isVideo(){
		return video;
	}

	public String getTitle(){
		return title;
	}


	public String getPosterPath(){
		return posterPath;
	}

	public String getBackdropPath(){
		return backdropPath;
	}

	public String getReleaseDate(){
		return releaseDate;
	}

	public String getMediaType(){
		return mediaType;
	}

	public double getVoteAverage(){
		return voteAverage;
	}

	public double getPopularity(){
		return popularity;
	}

	public int getId(){
		return id;
	}

	public boolean isAdult(){
		return adult;
	}

	public int getVoteCount(){
		return voteCount;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(overview);
		parcel.writeString(originalLanguage);
		parcel.writeString(originalTitle);
		parcel.writeByte((byte) (video ? 1 : 0));
		parcel.writeString(title);
		parcel.writeString(posterPath);
		parcel.writeString(backdropPath);
		parcel.writeString(releaseDate);
		parcel.writeString(mediaType);
		parcel.writeDouble(voteAverage);
		parcel.writeDouble(popularity);
		parcel.writeInt(id);
		parcel.writeByte((byte) (adult ? 1 : 0));
		parcel.writeInt(voteCount);
	}
}