package dc.test;

import dc.character.CharBag;
import dc.character.Race;
import dc.main.Encounter;
import dc.main.Location;

public class EncounterTest {

	public static void main(String[] args) {
		Encounter.encounter(Location.CORRIDOR, (CharBag) Race.getNewChar("test_char", Race.HUMAN));

	}

}
