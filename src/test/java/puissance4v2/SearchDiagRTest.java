package puissance4v2;

import static org.assertj.core.api.Assertions.assertThat;

import java.security.KeyStore.Entry;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SearchDiagRTest {
	
	DataInput dataInput = new DataInput();
	private GameArea searchDiagRTest = new GameArea(dataInput.getData(0));
	ArrayList<Integer> output = new ArrayList<Integer>();
	ArrayList<Integer> expectedsearchDiagRTest = new ArrayList<Integer>();
	

	
	@BeforeEach
	public void initSearch() {
		System.out.println("Appel avant chaque test");
	}

	@AfterEach
	public void afterSearch() {
		System.out.println("Appel avant après test");
		searchDiagRTest = null;
		output.clear();
	}

	@Test
	void searchDiagRTest() {
		// Arrange
		ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(2);
		input.add(1);
		expectedsearchDiagRTest.add(0);
		expectedsearchDiagRTest.add(3);
		expectedsearchDiagRTest.add(1);
		expectedsearchDiagRTest.add(2);
		expectedsearchDiagRTest.add(2);
		expectedsearchDiagRTest.add(1);
		expectedsearchDiagRTest.add(3);
		expectedsearchDiagRTest.add(0);
		// Act
		output = searchDiagRTest.searchDiagR(dataInput.getData(0), input);
		
		// Assert
		assertThat(output).isEqualTo(expectedsearchDiagRTest);
		System.out.println(output.toString());
		System.out.println(expectedsearchDiagRTest.toString());
	}
	
	@Test
	void searchDiagRTest1() {
		// Arrange
		ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(5);
		input.add(6);
		expectedsearchDiagRTest.add(5);
		expectedsearchDiagRTest.add(6);

		// Act
		output = searchDiagRTest.searchDiagR(dataInput.getData(0), input);
		
		// Assert
		assertThat(output).isEqualTo(expectedsearchDiagRTest);
		System.out.println(output.toString());
		System.out.println(expectedsearchDiagRTest.toString());
	}
	
	@Test
	void searchDiagRTest2() {
		// Arrange
		ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(0);
		input.add(6);
		expectedsearchDiagRTest.add(0);
		expectedsearchDiagRTest.add(6);
		expectedsearchDiagRTest.add(1);
		expectedsearchDiagRTest.add(5);
		expectedsearchDiagRTest.add(2);
		expectedsearchDiagRTest.add(4);
		expectedsearchDiagRTest.add(3);
		expectedsearchDiagRTest.add(3);
		expectedsearchDiagRTest.add(4);
		expectedsearchDiagRTest.add(2);
		expectedsearchDiagRTest.add(5);
		expectedsearchDiagRTest.add(1);

		// Act
		output = searchDiagRTest.searchDiagR(dataInput.getData(0), input);
		
		// Assert
		assertThat(output).isEqualTo(expectedsearchDiagRTest);
		System.out.println(output.toString());
		System.out.println(expectedsearchDiagRTest.toString());
	}
	
}
