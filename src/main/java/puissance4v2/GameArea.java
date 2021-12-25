package puissance4v2;

import java.util.ArrayList;

public class GameArea {

	String[][] game = new String[6][7];

	public GameArea(String[][] game) {
		this.game = game;
	}
	
	// Init String[][] by
	public static void init(String[][] gameArea) {
		for (int row = 0; row < gameArea.length; row++) {
			for (int col = 0; col < gameArea[row].length; col++) {
				gameArea[row][col] = "0";
				// System.out.print(game[row][col] + " ");
			}
			// System.out.println();
		}
	}

	// Display a String[][]
	public static void display(String[][] gameArea) {
		for (int row = 0; row < gameArea.length; row++) {
			for (int col = 0; col < gameArea[row].length; col++) {
				System.out.print(gameArea[row][col] + " ");
			}
			System.out.println();
		}
	}

	// Given a position (x,y) in a 2D String, find the 1st free position in the
	// column of the position
	public ArrayList<Integer> searchEmptyCol(String[][] game, int col) {
		ArrayList<Integer> coordinates = new ArrayList<Integer>();
		// Si il y a 0 sur la dernière ligne alors je renvoie directement les
		// coordonnées
		if (game[game.length - 1][col] == "0") {
			coordinates.add(game.length - 1);
			coordinates.add(col);
		} else {
			// Je cherche dans la colonne le premier element non vide
			for (int row = 0; row < game.length; row++) {
				if (game[row][col] != "0") {
					coordinates.add(row - 1);
					coordinates.add(col);
					break;
				}
			}
		}
		if (coordinates.get(0) < 0) {
			System.out.println("Vous ne pouvez pas jouer ceci");
			coordinates.clear();
			return (coordinates);
		} else {
			return (coordinates);
		}
	}

	// Given a position (x,y) in a 2D String, all the coordinates of the right
	// associate diagonal
	public ArrayList<Integer> searchDiagR(String[][] game, ArrayList<Integer> arr) {
		ArrayList<Integer> coordinates = new ArrayList<Integer>();
		int x = arr.get(0) + arr.get(1);
		for (int row = 0; row < game.length; row++) {
			for (int col = 0; col < game[row].length; col++) {
				if (row + col == x) {
					coordinates.add(row);
					coordinates.add(col);
				}
			}
		}

		return (coordinates);

	}

	// Given a position (x,y) in a 2D String, all the coordinates of the Left
	// associate diagonal
	public ArrayList<Integer> searchDiagL(String[][] game, ArrayList<Integer> arr) {
		ArrayList<Integer> coordinates = new ArrayList<Integer>();
		int x = arr.get(0) - arr.get(1);
		for (int row = 0; row < game.length; row++) {
			for (int col = 0; col < game[row].length; col++) {
				if (row - col == x) {
					coordinates.add(row);
					coordinates.add(col);
				}
			}
		}
		return (coordinates);
	}

}
