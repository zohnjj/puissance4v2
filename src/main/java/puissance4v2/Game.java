package puissance4v2;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		// Init of the game
		// 1st phase player creation if player = true then player 1 turn else player 2
		// turn
		
		boolean win = false;
		boolean player = true;
		Player player1 = new Player("Player1", "R");
		Player player2 = new Player("Player2", "J");

		// 2nd Slider creation
		String[][] sliderCursor = new String[1][7];
		Slider slider = new Slider(sliderCursor);
		slider.init(sliderCursor);
		System.out.println(
				"Please find bellow the slider across which you will navigate 'left' & 'right' to play. For now it is fill up with '...'");
		slider.display(sliderCursor);

		// 3nd Game Area creation
		String[][] game = new String[6][7];
		GameArea gameArea = new GameArea(game);
		gameArea.init(game);
		System.out.println(
				"Please find bellow the Game Area across which you will put your token. For now it is fill up with '0 0 0'");
		gameArea.display(game);

		// Lanch the game
		startGame(slider, gameArea);

		// Player Turn
		ArrayList<Integer> coordinatesToken = new ArrayList<Integer>();
		while (win == false) {
			if (player == true) {
				coordinatesToken = playerTurn(player1, slider, gameArea);
				while (coordinatesToken.isEmpty() == true) {
					coordinatesToken = playerTurn(player1, slider, gameArea);
				}
				System.out.println("coordinatesToken " + coordinatesToken.toString());
				win = winCheck(player1, slider, gameArea, coordinatesToken);
				if (win == true) {
					System.out.println("=====================================");
					System.out.println("Vous avez gagné " + player1.nom);
				}
				player = false;
			} else {
				coordinatesToken = playerTurn(player2, slider, gameArea);
				while (coordinatesToken.isEmpty() == true) {
					coordinatesToken = playerTurn(player2, slider, gameArea);
				}
				System.out.println("coordinatesToken " + coordinatesToken.toString());
				win = winCheck(player2, slider, gameArea, coordinatesToken);

				if (win == true) {
					System.out.println("=====================================");
					System.out.println("Vous avez gagné " + player2.nom);
				}
				player = true;
			}
		}

	}

	public static ArrayList<Integer> playerTurn(Player player, Slider slider, GameArea gameArea) {
		ArrayList<Integer> coordinatesV = new ArrayList<Integer>();
		ArrayList<Integer> coordinatesToken = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		switch (input) {
		case "q":
			coordinatesV = slider.searchPos(slider.sliderCursor, "V");
			switch (coordinatesV.get(1)) {
			case 0:
				printTurn(slider, gameArea);
				System.out.println("Vous ne pouvez pas aller plus à gauche");
				break;
			default:
				slider.sliderCursor[coordinatesV.get(0)][coordinatesV.get(1)] = ".";
				slider.sliderCursor[coordinatesV.get(0)][coordinatesV.get(1) - 1] = "V";
				printTurn(slider, gameArea);
				break;
			}
			break;
		case "d":
			coordinatesV = slider.searchPos(slider.sliderCursor, "V");
			switch (coordinatesV.get(1)) {
			case 6:
				printTurn(slider, gameArea);
				System.out.println("Vous ne pouvez pas aller plus à droite");
				break;
			default:
				slider.sliderCursor[coordinatesV.get(0)][coordinatesV.get(1)] = ".";
				slider.sliderCursor[coordinatesV.get(0)][coordinatesV.get(1) + 1] = "V";
				printTurn(slider, gameArea);
				break;
			}
			break;
		case "s":
			coordinatesV = slider.searchPos(slider.sliderCursor, "V");
			coordinatesToken = gameArea.searchEmptyCol(gameArea.game, coordinatesV.get(1));
			gameArea.game[coordinatesToken.get(0)][coordinatesToken.get(1)] = player.color;
			printTurn(slider, gameArea);
			break;
		default:
			printTurn(slider, gameArea);
			break;
		}
		return coordinatesToken;
	}

	public static boolean winCheck(Player player, Slider slider, GameArea gameArea,
			ArrayList<Integer> coordinatesToken) {
		boolean win = false;
		if (win == false) {
			win = winConditionCol(gameArea.game, coordinatesToken, player);
		}
		if (win == false) {
			win = winConditionRow(gameArea.game, coordinatesToken, player);
		}
		if (win == false) {
			ArrayList<Integer> listCoordonatesDiagR = new ArrayList<Integer>();
			listCoordonatesDiagR = gameArea.searchDiagR(gameArea.game, coordinatesToken);
			win = winConditionDiagRight(gameArea.game, listCoordonatesDiagR, player);
		}
		if (win == false) {
			ArrayList<Integer> listCoordonatesDiagL = new ArrayList<Integer>();
			listCoordonatesDiagL = gameArea.searchDiagL(gameArea.game, coordinatesToken);
			win = winConditionDiagLeft(gameArea.game, listCoordonatesDiagL, player);
		}
		// System.out.println("=====================================");
		// System.out.println("Vous avez gagné");

		return win;
	}

	public static boolean countWin(int count) {
		boolean win = false;
		if (count >= 4) {
			win = true;
		}
		return win;
	}

	public static boolean winConditionCol(String[][] game, ArrayList<Integer> coordinatesToken, Player player) {
		int count = 0;
		boolean win = false;
		for (int row = coordinatesToken.get(0); row < game.length; row++) {
			if (game[row][coordinatesToken.get(1)] == player.color) {
				count += 1;
				win = countWin(count);
				if (win == true) {
					break;
				}
			} else {
				count = 0;
			}
		}
		return win;
	}

	public static boolean winConditionRow(String[][] game, ArrayList<Integer> coordinatesToken, Player player) {
		int count = 0;
		boolean win = false;

		for (int col = 0; col < game[0].length; col++) {
			if (game[coordinatesToken.get(0)][col] == player.color) {
				count += 1;
				win = countWin(count);
				if (win == true) {
					break;
				}
			} else {
				count = 0;
			}
		}
		return win;
	}

	public static boolean winConditionDiagRight(String[][] game, ArrayList<Integer> listCoordonatesDiagR,
			Player player) {
		int count = 0;
		boolean win = false;

		for (int i = -1, j = 0; i <= listCoordonatesDiagR.size() / 2 && j < listCoordonatesDiagR.size() / 2; i++, j++) {
			int abs = 2 * (i + 1);
			int ord = 2 * j + 1;
			int valAbs = listCoordonatesDiagR.get(abs);
			int valOrd = listCoordonatesDiagR.get(ord);
			String valCase = game[listCoordonatesDiagR.get(abs)][listCoordonatesDiagR.get(ord)];
			if (game[listCoordonatesDiagR.get(abs)][listCoordonatesDiagR.get(ord)] == player.color) {
				count += 1;
				win = countWin(count);
			} else {
				count = 0;
			}
		}
		return win;
	}

	public static boolean winConditionDiagLeft(String[][] game, ArrayList<Integer> listCoordonatesDiagR,
			Player player) {
		int count = 0;
		boolean win = false;
		for (int i = -1, j = 0; i <= listCoordonatesDiagR.size() / 2 && j < listCoordonatesDiagR.size() / 2; i++, j++) {
			int abs = 2 * (i + 1);
			int ord = 2 * j + 1;
			int valAbs = listCoordonatesDiagR.get(abs);
			int valOrd = listCoordonatesDiagR.get(ord);
			String valCase = game[listCoordonatesDiagR.get(abs)][listCoordonatesDiagR.get(ord)];
			if (game[listCoordonatesDiagR.get(abs)][listCoordonatesDiagR.get(ord)] == player.color) {
				count += 1;
				win = countWin(count);
			} else {
				count = 0;
			}
		}
		return win;
	}

	public static void startGame(Slider slider, GameArea gameArea) {
		System.out.println("=====================================");
		System.out.println("Si vous êtes prêts à jouer taper 's'");
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		switch (input) {
		case "s":
			System.out.println("=====================================");
			System.out.println("Welcome Player 1, you will play the Red 'R' one.");
			System.out.println(
					"Please notice the 'V' on the slider. It designates the colunm where you will place your Red token.");
			System.out.println("To Move Left, please type 'q'");
			System.out.println("To Move Right, please type 'd'");
			System.out.println("To Move Put your token on the designated colum, please type 's'");
			slider.sliderCursor[0][3] = "V";
			slider.display(slider.sliderCursor);
			slider.display(gameArea.game);
			break;
		default:
			startGame(slider, gameArea);
		}

	}

	public static void printTurn(Slider slider, GameArea gameArea) {
		System.out.println("=====================================");
		System.out.println(
				"Please notice the 'V' on the slider. It designates the colunm where you will place your token.");
		System.out.println("To Move Left, please type 'q'");
		System.out.println("To Move Right, please type 'd'");
		System.out.println("To Move Put your token on the designated colum, please type 's'");
		slider.display(slider.sliderCursor);
		slider.display(gameArea.game);
	}

}
