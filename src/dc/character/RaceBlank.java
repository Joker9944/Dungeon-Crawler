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
	
	public HashMap<SuffixVariable, Object> getValues() {
		HashMap<SuffixVariable, Object> helpMap = new HashMap<SuffixVariable, Object>();
		helpMap.put(SuffixVariable.OWNER, owner);
		helpMap.put(SuffixVariable.HASNAME, hasName);
		helpMap.put(SuffixVariable.UNITCOST, unitCost);
		helpMap.put(SuffixVariable.DAMAGE, damage);
		helpMap.put(SuffixVariable.ARMOR, armor);
		return helpMap;
	}
}