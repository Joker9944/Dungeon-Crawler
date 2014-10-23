package dc.character;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;

import dc.item.Item;
import dc.item.ItemCategory;
import dc.item.ItemTyp;

public enum Race {

	//Player Race
	HUMAN("Human", 100D, 100D, true, Suffix.PLAYER),
	ELF("Elf", 50D, 150D, true, Suffix.PLAYER),
	ORK("Ork", 150D, 50D, true, Suffix.PLAYER),
	DWARF("Dwarf", 200D, 0D, false, Suffix.PLAYER),
	//Enemy Race
	SPIDER("Spider", 50D, 0D, false, Suffix.BLANK),
	GOBLIN("Goblin", 70D, 0D, false, Suffix.INVENTORY),
	MERCENARY("Mercenary", 100D, 0D, false, Suffix.BAG);
	

	private String race;
	private Double maxHP;
	private Double maxMP;
	private Boolean clm;
	private Suffix suffix;
	
	private Race(String race, Double maxHP, Double maxMP, Boolean clm, Suffix suffix) {
		this.race = race;
		this.maxHP = maxHP;
		this.maxMP = maxMP;
		this.clm = clm;
		this.suffix = suffix;
	}
	
	public static CharBlank getNewChar(String name, Race race) {
		if(race.suffix.equals(Suffix.BLANK)) {
			return new CharBlank(name, race);
		}
		if(race.suffix.equals(Suffix.INVENTORY)) {
			return new CharInventory(name, race);
		}
		if(race.suffix.equals(Suffix.BAG)) {
			return new CharBag(name, race);
		}
		if(race.suffix.equals(Suffix.PLAYER)) {
			return new CharPlayer(name, race);
		}
		return null;
	}
	
	public String getRace() {
		return race;
	}
	
	public Double getMaxHP() {
		return maxHP;
	}
	
	public Double getMaxMP() {
		return maxMP;
	}
	
	public Boolean getClm() {
		return clm;
	}

	public Suffix getSuffix() {
		return suffix;
	}
	
	public Boolean isPlayerRace() {
		if(suffix.equals(Suffix.PLAYER)) {
			return true;
		} else {
			return false;
		}
	}
	
	public Integer getMaxBagSlots(){
		try {
			Integer helpInt = (Integer) testIt(suffix, this).get(SuffixVariable.MAXBAGSLOTS);
			if(helpInt.equals(null)) {
				throw new NullPointerException();
			}
			return helpInt;
		}
		catch(ClassCastException e) {
			System.out.println("Error getMaxBagSlots()");
			System.out.println(e.getMessage());
			throw new NullPointerException();
		}
	}
	
	@SuppressWarnings("unchecked")
	public EnumSet<ItemCategory> getUsableCategorys() {
		try {
			EnumSet<ItemCategory> helpSet = (EnumSet<ItemCategory>) testIt(suffix, this).get(SuffixVariable.USABLECATEGORYS);
			if(helpSet.equals(null)) {
				throw new NullPointerException();
			}
			return helpSet;
		}
		catch(ClassCastException e) {
			System.out.println("Error getUsableCategorys()");
			System.out.println(e.getMessage());
			throw new NullPointerException();
		}
	}
	
	@SuppressWarnings("unchecked")
	public EnumSet<ItemTyp> getUsableTyps() {
		try {
			EnumSet<ItemTyp> helpSet = (EnumSet<ItemTyp>) testIt(suffix, this).get(SuffixVariable.USABLETYPS);
			if(helpSet.equals(null)) {
				throw new NullPointerException();
			}
			return helpSet;
		}
		catch(ClassCastException e) {
			System.out.println("Error getUsableTyps()");
			System.out.println(e.getMessage());
			throw new NullPointerException();
		}
	}
	
	@SuppressWarnings("unchecked")
	public HashSet<Item> getStartItems() {
		try {
			HashSet<Item> helpSet = (HashSet<Item>) testIt(suffix, this).get(SuffixVariable.STARTITEMS);
			if(helpSet.equals(null)) {
				throw new NullPointerException();
			}
			return helpSet;
		}
		catch(ClassCastException e) {
			System.out.println("Error getStartItems()");
			System.out.println(e.getMessage());
			throw new NullPointerException();
		}
	}
	
	public Integer getUnitCost() {
		try {
			Integer helpInt = (Integer) testIt(suffix, this).get(SuffixVariable.UNITCOST);
			if(helpInt.equals(null)) {
				throw new NullPointerException();
			}
			return helpInt;
		}
		catch(ClassCastException e) {
			System.out.println("Error getUnitCost()");
			System.out.println(e.getMessage());
			throw new NullPointerException();
		}
	}
	
	public Boolean getHasName() {
		try {
			Boolean helpBool = (Boolean) testIt(suffix, this).get(SuffixVariable.HASNAME);
			if(helpBool.equals(null)) {
				throw new NullPointerException();
			}
			return helpBool;
		}
		catch(ClassCastException e) {
			System.out.println("Error getHasName()");
			System.out.println(e.getMessage());
			throw new NullPointerException();
		}
	}
	
	public Double getDamage() {
		try {
			Double helpDou = (Double) testIt(suffix, this).get(SuffixVariable.DAMAGE);
			if(helpDou.equals(null)) {
				throw new NullPointerException();
			}
			return helpDou;
		}
		catch(ClassCastException e) {
			System.out.println("Error getDamage()");
			System.out.println(e.getMessage());
			throw new NullPointerException();
		}
	}
	
	public Double getArmor() {
		try {
			Double helpDou = (Double) testIt(suffix, this).get(SuffixVariable.ARMOR);
			if(helpDou.equals(null)) {
				throw new NullPointerException();
			}
			return helpDou;
		}
		catch(ClassCastException e) {
			System.out.println("Error getArmor()");
			System.out.println(e.getMessage());
			throw new NullPointerException();
		}
	}
	
	private static HashMap<SuffixVariable, Object> testIt(Suffix suffix, Race race) {
		if(suffix.equals(Suffix.PLAYER)) {
			return RacePlayer.getRace(race).getValues();
		}
		if(suffix.equals(Suffix.BLANK)) {
			return RaceBlank.getRace(race).getValues();
		}
		if(suffix.equals(Suffix.BAG)) {
			return RaceBag.getRace(race).getValues();
		}
		if(suffix.equals(Suffix.INVENTORY)) {
			return RaceInventory.getRace(race).getValues();
		}
		return null;
	}
}

enum Suffix {
	PLAYER,		// For PlayerChar
	BLANK,		// For Enemy
	BAG,		// For Enemy
	INVENTORY;	// For Enemy
}

enum SuffixVariable {
	OWNER,				// Race
	MAXBAGSLOTS,		// Integer
	USABLECATEGORYS,	// EnumSet<ItemCategory>
	USABLETYPS,			// ENumSet<ItemTyp>
	HASNAME,			// Boolean
	UNITCOST,			// Integer
	DAMAGE,				// Double
	ARMOR,				// Double
	STARTITEMS			// HashSet<Item>
}