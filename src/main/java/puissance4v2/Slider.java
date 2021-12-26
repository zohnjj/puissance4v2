package puissance4v2;

import java.util.ArrayList;

public class Slider {

	String[][] sliderCursor = new String[1][7];
	
	public Slider(String[][] sliderCursor) {
		this.sliderCursor = sliderCursor;
	}

	//Init the slider by fill it with "."
	public void init(String[][] game) {
		for (int row = 0; row < game.length; row++) {
			for (int col = 0; col < game[row].length; col++) {
				game[row][col] = ".";
				// System.out.print(game[row][col] + " ");
			}
			// System.out.println();
		}
	}

	// Display a String String[][]
	public void display(String[][] game) {
		for (int row = 0; row < game.length; row++) {
			for (int col = 0; col < game[row].length; col++) {
				System.out.print(game[row][col] + " ");
			}
			System.out.println();
		}
	}
	
	// Return the (x,y) of the first encounter of the String within a String[][]
	public ArrayList<Integer> searchPos(String[][] game, String search) {
		ArrayList<Integer> coordinates = new ArrayList<Integer>();
		for (int row = 0; row < game.length; row++) {
			for (int col = 0; col < game[row].length; col++) {
				if (game[row][col] == search) {
					coordinates.add(row);
					coordinates.add(col);
					break;
				}
			}
		}

		return (coordinates);
	}

}
