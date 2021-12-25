package puissance4v2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SearchEmptyColTest {


	Player player;
	// ArrayList<Integer> input = new ArrayList<Integer>();
	DataInput dataInput = new DataInput();
	private GameArea searchEmptyColTest = new GameArea(dataInput.getData(0));
	ArrayList<Integer> output = new ArrayList<Integer>();
	ArrayList<Integer> expectedOutputEmptyCol = new ArrayList<Integer>();

	@BeforeEach
	public void initSearch() {
		System.out.println("Appel avant chaque test");
	}

	@AfterEach
	public void afterSearch() {
		System.out.println("Appel avant après test");
		searchEmptyColTest = null;
		dataInput.clear();
		output.clear();
	}

	// Test que si il n'y a que des 0 ça renvoie bien les coordonées de dernière
	// ligne du tableau de jeu
	@Test
	void searchEmptyColTest() {
		// Arrange
		expectedOutputEmptyCol.add(5);
		expectedOutputEmptyCol.add(1);
		expectedOutputEmptyCol.add(3);
		expectedOutputEmptyCol.add(1);
		expectedOutputEmptyCol.add(3);
		expectedOutputEmptyCol.add(1);
		expectedOutputEmptyCol.add(3);
		expectedOutputEmptyCol.add(1);
		expectedOutputEmptyCol.add(5);
		expectedOutputEmptyCol.add(1);
		int a = 1;
		// Act
		for (int i = 0; i < dataInput.getDataList().size(); i++) {
			ArrayList<Integer> outputTemp = new ArrayList<Integer>();
			outputTemp = searchEmptyColTest.searchEmptyCol(dataInput.getData(i), a);
			output.add(outputTemp.get(0));
			output.add(outputTemp.get(1));
		}
		// Assert
		assertThat(output).isEqualTo(expectedOutputEmptyCol);
		System.out.println(output.toString());
		System.out.println(expectedOutputEmptyCol.toString());

	}

}
