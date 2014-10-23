package dc.test;

import org.junit.Test;

import dc.character.CharPlayer;
import dc.character.Race;
import dc.main.SaveLoad;

public class SaveLoadTest {

	@Test
	public void test() {
		CharPlayer player;
		SaveLoad.save((CharPlayer) Race.getNewChar("test_char", Race.HUMAN));
		player = SaveLoad.load();
		System.out.println(player.getName());
	}

}
