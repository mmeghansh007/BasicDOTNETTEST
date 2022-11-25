package com.jspiders.MusicPlayerProject.songs;

public class songs {

	private int id;
	private String songName;
	private String singerName;
	private String movieName;
	private String composer;
	private String lyricist;
	private double length;

	public songs() {
		super();
	}

	public songs(int id, String songName, String singerName, String movieName, String composer, String lyricist,
			double length) {
		super();
		this.id = id;
		this.songName = songName;
		this.singerName = singerName;
		this.movieName = movieName;
		this.composer = composer;
		this.lyricist = lyricist;
		this.length = length;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getSingerName() {
		return singerName;
	}

	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getComposer() {
		return composer;
	}

	public void setComposer(String composer) {
		this.composer = composer;
	}

	public String getLyricist() {
		return lyricist;
	}

	public void setLyricist(String lyricist) {
		this.lyricist = lyricist;
	}

	public double getLength() {
		return length;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	@Override
	public String toString() {
		return "Song [id=" + id + ", songName=" + songName + ", singerName=" + singerName + ", movieName=" + movieName
				+ ", composer=" + composer + ", lyricist=" + lyricist + ", length=" + length + "]";
	}
}
