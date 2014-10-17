package dc.character;

import java.util.HashMap;

enum RaceBlank {

	//TODO DropTable, Balancing
	
	SPIDER(Race.SPIDER, false, 2, 5D, 0.5);
	
	private Race owner;
	private Boolean hasName;
	private Integer unitCost;
	private Double damage;
	private Double armor;
	
	private RaceBlank(Race owner, Boolean hasName, Integer unitCost, Double damage, Double armor) {
		this.owner = owner;
		this.hasName = hasName;
		this.unitCost = unitCost;
		this.damage = damage;
		this.armor = armor;
		
	}

	public static RaceBlank getRace(Race race) {
		for(RaceBlank testRace: RaceBlank.values()) {
			if(race.equals(testRace.getOwner())) {
				return testRace;
			}
		}
		return null;
	}
	
	public Race getOwner() {
		return owner;
	}
	
	public HashMap<RaceSuffixVariableName, Object> getValues() {
		HashMap<RaceSuffixVariableName, Object> helpMap = new HashMap<RaceSuffixVariableName, Object>();
		helpMap.put(RaceSuffixVariableName.OWNER, owner);
		helpMap.put(RaceSuffixVariableName.HASNAME, hasName);
		helpMap.put(RaceSuffixVariableName.UNITCOST, unitCost);
		helpMap.put(RaceSuffixVariableName.DAMAGE, damage);
		helpMap.put(RaceSuffixVariableName.ARMOR, armor);
		return helpMap;
	}
}