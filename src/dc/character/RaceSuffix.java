package dc.character;

import java.util.HashMap;


public enum RaceSuffix {
	PLAYER,		// For PlayerChar
	BLANK,		// For Enemy
	BAG,		// For Enemy
	INVENTORY;	// For Enemy
	
	public static HashMap<RaceSuffixVariableName, Object> testIt(RaceSuffix suffix, Race race) {
		if(suffix.equals(PLAYER)) {
			return RacePlayer.getRace(race).getValues();
		}
		if(suffix.equals(BLANK)) {
			return RaceBlank.getRace(race).getValues();
		}
		if(suffix.equals(BAG)) {
			return RaceBag.getRace(race).getValues();
		}
		if(suffix.equals(INVENTORY)) {
			return RaceInventory.getRace(race).getValues();
		}
		return null;
	}
}