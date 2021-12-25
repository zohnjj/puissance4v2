package puissance4v2;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class PlayerTest {

	@Test
	void test() {
		// Arrage
		Player player1 = new Player("Player1", "R");
		Player player2 = new Player("Player2", "J");

		// Act

		// Assert assertThat(output).isEqualTo(expectedOutPut);
		assertThat(player1.nom).as("Player1");
		assertThat(player2.color).as("J");
		System.out.println(player1.nom);
		System.out.println(player2.color);
		

	}

}
