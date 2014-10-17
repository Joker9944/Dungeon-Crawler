package dc.character;

import java.util.EnumSet;
import java.util.HashSet;

import dc.item.Item;
import dc.item.ItemCategory;
import dc.item.ItemTyp;

public enum Race {

	//Player Race
	HUMAN("Human", 100D, 100D, true, RaceSuffix.PLAYER),
	ELF("Elf", 50D, 150D, true, RaceSuffix.PLAYER),
	ORK("Ork", 150D, 50D, true, RaceSuffix.PLAYER),
	DWARF("Dwarf", 200D, 0D, false, RaceSuffix.PLAYER),
	//Enemy Race
	SPIDER("Spider", 50D, 0D, false, RaceSuffix.BLANK),
	GOBLIN("Goblin", 70D, 0D, false, RaceSuffix.INVENTORY),
	MERCENARY("Mercenary", 100D, 0D, false, RaceSuffix.BAG);
	

	private String race;
	private Double maxHP;
	private Double maxMP;
	private Boolean clm;
	private RaceSuffix suffix;
	
	private Race(String race, Double maxHP, Double maxMP, Boolean clm, RaceSuffix suffix) {
		this.race = race;
		this.maxHP = maxHP;
		this.maxMP = maxMP;
		this.clm = clm;
		this.suffix = suffix;
	}
	
	public static Char getNewChar(String name, Race race) {
		if(race.suffix.equals(RaceSuffix.BLANK)) {
			return new Char(name, race);
		}
		if(race.suffix.equals(RaceSuffix.INVENTORY)) {
			return new CharInventory(name, race);
		}
		if(race.suffix.equals(RaceSuffix.BAG)||race.suffix.equals(RaceSuffix.PLAYER)) {
			return new CharBag(name, race);
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

	public RaceSuffix getSuffix() {
		return suffix;
	}
	
	public Boolean isPlayerRace() {
		if(suffix.equals(RaceSuffix.PLAYER)) {
			return true;
		} else {
			return false;
		}
	}
	
	public Integer getMaxBagSlots(){
		try {
			Integer helpInt = (Integer) RaceSuffix.testIt(suffix, this).get(RaceSuffixVariableName.MAXBAGSLOTS);
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
			EnumSet<ItemCategory> helpSet = (EnumSet<ItemCategory>) RaceSuffix.testIt(suffix, this).get(RaceSuffixVariableName.USABLECATEGORYS);
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
			EnumSet<ItemTyp> helpSet = (EnumSet<ItemTyp>) RaceSuffix.testIt(suffix, this).get(RaceSuffixVariableName.USABLETYPS);
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
			HashSet<Item> helpSet = (HashSet<Item>) RaceSuffix.testIt(suffix, this).get(RaceSuffixVariableName.STARTITEMS);
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
			Integer helpInt = (Integer) RaceSuffix.testIt(suffix, this).get(RaceSuffixVariableName.UNITCOST);
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
			Boolean helpBool = (Boolean) RaceSuffix.testIt(suffix, this).get(RaceSuffixVariableName.HASNAME);
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
			Double helpDou = (Double) RaceSuffix.testIt(suffix, this).get(RaceSuffixVariableName.DAMAGE);
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
			Double helpDou = (Double) RaceSuffix.testIt(suffix, this).get(RaceSuffixVariableName.ARMOR);
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
}
