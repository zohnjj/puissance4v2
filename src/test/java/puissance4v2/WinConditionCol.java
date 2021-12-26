package puissance4v2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class WinConditionCol {
	private Game game;
	Player player = new Player("Player2", "J");
	DataInput dataInput = new DataInput();
	List<Boolean> listExpectedOuput=new ArrayList<Boolean>();
	List<Boolean> listOuput=new ArrayList<Boolean>();
	

	@Test
	void WinConditionCol() {
		// Arrange
		listExpectedOuput.add(false);
		listExpectedOuput.add(false);
		listExpectedOuput.add(true);
		listExpectedOuput.add(false);
		listExpectedOuput.add(false);
		ArrayList<Integer> inputTemp = new ArrayList<Integer>();
		inputTemp.add(0);
		inputTemp.add(3);	
		
		// Act
		for (int i = 0; i < dataInput.getDataList().size(); i++) {
			boolean a = game.winConditionCol(dataInput.getData(i), inputTemp, player);
			System.out.println("=======");
			listOuput.add(a);
		}
		// Assert
		assertThat(listOuput).isEqualTo(listExpectedOuput);
		System.out.println("listOuput=====");
		System.out.println(listOuput.toString());
		System.out.println("listExpectedOuput=====");
		System.out.println(listExpectedOuput.toString());
	}

}
