package puissance4v2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SearchPosTest {

	ArrayList<Integer> arr = new ArrayList<Integer>();

	String[][] testSlider = new String[][] { { ".", ".", ".", "V", ".", ".", "." } };
	String[][] testSlider1 = new String[][] { { ".", ".", ".", ".", ".", ".", "V" } };
	private Slider searchPosTest = new Slider(testSlider);

	@BeforeEach
	public void initSearchPos() {
		System.out.println("Appel avant chaque test");
	}

	@AfterEach
	public void afterSearchPos() {
		System.out.println("Appel avant après test");
		searchPosTest = null;
		arr = null;
	}

	@Test
	void testSearchPos() {
		// Arrange

		// Act
		arr = searchPosTest.searchPos(testSlider, "V");

		// Assert
		assertThat(arr).containsExactly(0, 3);

	}

	@Test
	void testSearchPos1() {
		// Arrange

		// Act
		arr = searchPosTest.searchPos(testSlider1, "V");

		// Assert
		assertThat(arr).containsExactly(0, 6);

	}

	@Test
	void testSearchPosFailed() {
		// Arrange

		// Act
		arr = searchPosTest.searchPos(testSlider1, "R");

		// Assert
		assertThat(arr).isEmpty();

	}

}
