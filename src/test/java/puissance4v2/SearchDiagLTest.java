package puissance4v2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SearchDiagLTest {

	DataInput dataInput = new DataInput();
	private GameArea searchDiagLTest = new GameArea(dataInput.getData(0));
	ArrayList<Integer> output = new ArrayList<Integer>();
	ArrayList<Integer> expectedsearchDiagLTest = new ArrayList<Integer>();

	@BeforeEach
	public void initSearch() {
		System.out.println("Appel avant chaque test");
	}

	@AfterEach
	public void afterSearch() {
		System.out.println("Appel avant après test");
		searchDiagLTest = null;
		output.clear();
	}

	@Test
	void searchDiagLTest() {
		// Arrange
		ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(4);
		input.add(2);
		expectedsearchDiagLTest.add(2);
		expectedsearchDiagLTest.add(0);
		expectedsearchDiagLTest.add(3);
		expectedsearchDiagLTest.add(1);
		expectedsearchDiagLTest.add(4);
		expectedsearchDiagLTest.add(2);
		expectedsearchDiagLTest.add(5);
		expectedsearchDiagLTest.add(3);
		// Act
		output = searchDiagLTest.searchDiagL(dataInput.getData(0), input);

		// Assert
		assertThat(output).isEqualTo(expectedsearchDiagLTest);
		System.out.println(output.toString());
		System.out.println(expectedsearchDiagLTest.toString());
	}
	
	@Test
	void searchDiagLTest1() {
		// Arrange
		ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(1);
		input.add(5);
		expectedsearchDiagLTest.add(0);
		expectedsearchDiagLTest.add(4);
		expectedsearchDiagLTest.add(1);
		expectedsearchDiagLTest.add(5);
		expectedsearchDiagLTest.add(2);
		expectedsearchDiagLTest.add(6);
		// Act
		output = searchDiagLTest.searchDiagL(dataInput.getData(0), input);

		// Assert
		assertThat(output).isEqualTo(expectedsearchDiagLTest);
		System.out.println(output.toString());
		System.out.println(expectedsearchDiagLTest.toString());
	}

}
