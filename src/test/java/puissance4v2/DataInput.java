package puissance4v2;

import java.util.ArrayList;

public class DataInput {

	String[][] testTableauNull = new String[][] { { "0", "0", "0", "0", "0", "0", "0" },
			{ "0", "0", "0", "0", "0", "0", "0" }, { "0", "0", "0", "0", "0", "0", "0" },
			{ "0", "0", "0", "0", "0", "0", "0" }, { "0", "0", "0", "0", "0", "0", "0" },
			{ "0", "0", "0", "0", "0", "0", "0" } };

	String[][] testTableauWinRow = new String[][] { { "0", "0", "0", "0", "0", "0", "R" },
			{ "0", "0", "0", "0", "0", "0", "J" }, { "0", "0", "0", "0", "0", "0", "J" },
			{ "0", "0", "0", "J", "J", "0", "R" }, { "0", "R", "R", "R", "R", "0", "R" },
			{ "0", "R", "R", "J", "J", "0", "J" } };

	String[][] testTableauWinCol = new String[][] { { "0", "0", "0", "0", "0", "0", "0" },
			{ "0", "0", "0", "0", "0", "0", "0" }, { "0", "0", "0", "J", "0", "0", "0" },
			{ "0", "0", "0", "J", "J", "0", "0" }, { "0", "R", "R", "J", "R", "0", "0" },
			{ "0", "R", "R", "J", "J", "0", "0" } };

	String[][] testTableauWinDiagR = new String[][] { { "0", "0", "0", "0", "0", "0", "0" },
			{ "0", "0", "0", "0", "0", "0", "0" }, { "0", "0", "0", "J", "R", "0", "0" },
			{ "0", "0", "0", "R", "J", "0", "0" }, { "0", "R", "R", "J", "R", "0", "0" },
			{ "0", "R", "R", "J", "J", "0", "0" } };

	String[][] testTableauDiagL = new String[][] { { "0", "0", "0", "0", "0", "0", "0" },
			{ "0", "0", "0", "0", "0", "0", "0" }, { "0", "0", "R", "0", "0", "0", "0" },
			{ "0", "0", "J", "R", "0", "0", "0" }, { "0", "0", "R", "J", "R", "0", "0" },
			{ "0", "0", "J", "R", "J", "R", "0" } };

	String[][] testSlider = new String[][] { { ".", ".", ".", "V", ".", ".", "." } };
	String[][] testSlider1 = new String[][] { { ".", ".", ".", ".", ".", ".", "V" } };

	ArrayList<String[][]> dataInput = new ArrayList<String[][]>();
	
	public DataInput() {
		dataInput.add(testTableauNull);
		dataInput.add(testTableauWinRow);
		dataInput.add(testTableauWinCol);
		dataInput.add(testTableauWinDiagR);
		dataInput.add(testTableauDiagL);
	}


	
	public String[][] getData(int i) {
		return dataInput.get(i);
	}

	public ArrayList<String[][]> getDataList() {
		return dataInput;
	}

	public ArrayList<String[][]> clear() {
		dataInput.clear();
		return dataInput;
	}

}
