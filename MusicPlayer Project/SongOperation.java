package com.jspiders.MusicPlayerProject.songs;

import java.util.ArrayList;
import java.util.Scanner;

public class SongOperation {
	public void chooseSongToPlay(ArrayList<songs> songList) {

		ArrayList<songs> songsList = songs;
		if (songsList.size() > 0) {
			try (Scanner scanner = new Scanner(System.in)) {
				System.out.println("Enter a specific song number to play");
				int b = scanner.nextInt();
				System.out.println(songList.get(b - 1));
			}
		} else {
			System.out.println("No song in list. Please Add some song in list");
		}
	}

	public void playAllSongs(ArrayList<songs> songList) {
		if (songList.size() > 0) {
			for (int i = 0; i < songList.size(); i++) {
				System.out.println(songList.get(i - 1));
			}
		} else {
			System.out.println("No song in list. Please Add some song in list");
		}
	}

	public void playRandomeSong(ArrayList<songs> songList) {
		if (songList.size() > 0) {
			for (int i = 0; i < songList.size(); i++) {
				int b = (int) Math.random();
				System.out.println(songList.get(b - 1));
			}
		} else {
			System.out.println("No song in list. Please Add some song in list");
		}
	}

	public void addSong(ArrayList<songs> songList) {
		System.out.println("addSong");
		if (songList != null) {
			songs song = new songs();
			try (Scanner scanner = new Scanner(System.in)) {
				// logic not set to add id into list
				int id = songList.size() + 1; // always add 1 to size of list to start id from 1
				System.out.println("Enter Song id:\n");
				song.setId(id);
				System.out.println("Enter Song name:\n");
				song.setSongName(scanner.nextLine());
				System.out.println("Enter Singer name:\n");
				song.setSingerName(scanner.nextLine());
				System.out.println("Enter Movie name:\n");
				song.setMovieName(scanner.nextLine());
				System.out.println("Enter Composer name:\n");
				song.setComposer(scanner.nextLine());
				System.out.println("Enter Lyricist name:\n");
				song.setLyricist(scanner.nextLine());
				System.out.println("Enter Song Length:\n");
				song.setLength(scanner.nextDouble());
			}
			songList.add(song);
			System.out.println("Song added in Playlist Successfully...");
			System.out.println(song);
		}
	}

	public void removeSongs(ArrayList<songs> songList) {
		System.out.println("Remove Song Particular");
		if (songList.size() > 0) {
			System.out.println("Choose song to remove from below list & Enter No.:\n");
			for (int i = 0; i < songList.size(); i++) {
				songs tempSong = songList.get(i);
				System.out.println(tempSong);
			}
			try (Scanner scanner = new Scanner(System.in)) {
				int songId = scanner.nextInt();
				if (songId > 0 && songId <= songList.size()) {
					songs tempSong = songList.get(songId - 1);
					songList.remove(songId - 1);
					System.out.println("Removed song from playlist " + tempSong.getSongName());
				} else {
					System.out.println("Entered wrong input, to delete song choose again");
					removeSongs(songList);
				}
			}
		} else {
			System.out.println("No songs avilable");
		}
	}

	public void update(ArrayList<songs> songList) {
		if (songList.size() > 0) {
			for (int i = 0; i < songList.size(); i++) {
				System.out.println(songList.get(i));
			}
			try (Scanner scanner = new Scanner(System.in)) {
				System.out.println("Update the Song which you want. And Enter No.:\\n");
				int songId = scanner.nextInt();
				songs song = new songs();
				if (songId > 0 && songId <= songList.size()) {
					System.out.println("Enter name to update: \n");
					song.setSongName(scanner.next());
					songList.add(song);
					System.out.println("Update Song Name successfully " + song.getSongName());
				} else {
					System.out.println("Entered wrong input, to update song choose again");
					update(songList);
				}
			}
		} else {
			System.out.println("No songs to play, Please add song..");
		}
	}

	public void displayAllSong(ArrayList<songs> songList) {
		if (songList.size() > 0) {
			for (int i = 0; i < songList.size(); i++) {
				songs tempSong = songList.get(i);
				System.out.println(tempSong);
			}
		} else {
			System.out.println("No song avilable");
		}
	}
}
