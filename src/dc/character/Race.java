package dc.character;

import java.util.ArrayList;

public enum Race {

	//Player Race
	HUMAN("Human", 100, 100, true, RaceSuffix.PLAYER),
	ELF("Elf", 50, 150, true, RaceSuffix.PLAYER),
	ORK("Ork", 150, 50, true, RaceSuffix.PLAYER),
	DWARF("Dwarf", 200, 0, false, RaceSuffix.PLAYER),
	//Enemy Race
	SPIDER("Spider", 50, 0, false, RaceSuffix.BLANK),
	GOBLIN("Goblin", 70, 0, false, RaceSuffix.INVENTORY),
	MERCENARY("Mercenary", 100, 0, false, RaceSuffix.BAG);
	

	private String race;
	private Integer maxHP;
	private Integer maxMP;
	private Boolean clm;
	private RaceSuffix suffix;
	
	private Race(String race, Integer maxHP, Integer maxMP, Boolean clm, RaceSuffix suffix) {
		this.race = race;
		this.maxHP = maxHP;
		this.maxMP = maxMP;
		this.clm = clm;
		this.suffix = suffix;
	}
	
	public static Char getNewChar(Race race) {
		if(race.suffix == RaceSuffix.BLANK) {
			return new Char(race);
		}
		if(race.suffix == RaceSuffix.INVENTORY) {
			return new CharInventory(race);
		}
		if(race.suffix == RaceSuffix.BAG||race.suffix == RaceSuffix.PLAYER) {
			return new CharBag(race);
		}
		return null;
	}
	
	public static Char getNewChar(String name, Race race) {
		if(race.suffix == RaceSuffix.BLANK) {
			return new Char(name, race);
		}
		if(race.suffix == RaceSuffix.INVENTORY) {
			return new CharInventory(name, race);
		}
		if(race.suffix == RaceSuffix.BAG||race.suffix == RaceSuffix.PLAYER) {
			return new CharBag(name, race);
		}
		return null;
	}
	
	public String getRace() {
		return race;
	}
	
	public Integer getMaxHP() {
		return maxHP;
	}
	
	public Integer getMaxMP() {
		return maxMP;
	}
	
	public Boolean getClm() {
		return clm;
	}
	
	public Integer getMaxBagSlots() {
		if(suffix == RaceSuffix.BAG||suffix == RaceSuffix.PLAYER) {
			for(RaceBag character: RaceBag.values()) {
				if(character.name().matches(this.name())) {
					return character.getMaxBagSlots();
				}
			}
		}
		return null;
	}
	
	public ArrayList<Object> getUsableItems() {
		if(suffix == RaceSuffix.BAG||suffix == RaceSuffix.PLAYER) {
			for(RaceBag race: RaceBag.values()) {
				if(race.name().matches(this.name())) {
					return race.getUsableItems();
				}
			}
		}
		if(suffix == RaceSuffix.INVENTORY) {
			for(RaceInventory race: RaceInventory.values()) {
				if(race.name().matches(this.name())) {
					return race.getUsableItems();
				}
			}
		}
		return null;
	}
}
