package com.jspiders.MusicPlayerProject.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.jspiders.MusicPlayerProject.songs.SongOperation;
import com.jspiders.MusicPlayerProject.songs.songs;

public class MusicPlayerMain {
	static ArrayList<songs> songList = new ArrayList<songs>();
	static MusicPlayerMain musicPlayerMain = new MusicPlayerMain();
	static boolean loop = true;

	public static void main(String[] args) {
		songs song1 = new songs(1, "songname1", "singername1", "moviename1", "composer1", "lyricist1", 123);
		songs song2 = new songs(2, "songname2", "singername2", "moviename2", "composer2", "lyricist2", 223);
		songList.add(song1);
		songList.add(song2);
		MusicPlayerMain.menu();
	}

	public static void menu() {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println(
					"Choose to make operation for \n1. Play  Song \n.2 Add Or Remove Song \n.3 Edit Song \n.4 Exist ");
			int choose = scanner.nextInt();
			switch (choose) {
			case 1:
				musicPlayerMain.playSong();
				break;
			case 2:
				musicPlayerMain.addOrRemoveSongs();
				break;
			case 3:
				musicPlayerMain.editSong();
				break;
			default:
				musicPlayerMain.exist();
				break;
			}
		}
	}

	public void playSong() {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Choose any option \n1. Choose Song \n2. Play All Song\n3. Random Song\n4. Go back");
			int choose = scanner.nextInt();
			SongOperation songOperation = new SongOperation();
			switch (choose) {
			case 1:
				songOperation.chooseSongToPlay(songList);
				break;
			case 2:
				songOperation.playAllSongs(songList);
				break;
			case 3:
				songOperation.playRandomeSong(songList);
				break;
			default:
				musicPlayerMain.menu();
				break;
			}
		}
	}

	public void addOrRemoveSongs() {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Choose any option \n1. Add Song \n2. Remove Song\n3. Go Back");
			int choose = scanner.nextInt();
			SongOperation songOperation = new SongOperation();
			switch (choose) {
			case 1:
				songOperation.addSong(songList);
				break;
			case 2:
				songOperation.removeSongs(songList);
				break;
			default:
				musicPlayerMain.menu();
				break;
			}
		}
	}

	public void editSong() {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Choose option \n1. Update song ");
			int choose = scanner.nextInt();
			SongOperation songOperation = new SongOperation();
			switch (choose) {
			case 1:
				songOperation.update(songList);
				break;
			default:
				musicPlayerMain.menu();
				break;
			}
		}
	}

	public void exist() {
		System.out.println("Application Existed Sucessfully Thank you");
	}
}
