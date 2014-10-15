package dc.character;

public enum Race {

	HUMAN("HUMAN", 100, 100, true, 6, new String[] {"light", "normal", "sword", "dagger", "bow"}),
	ELF("ELF", 50, 150, true, 6, new String [] {"light", "dagger", "bow"}),
	ORK("ORK", 150, 50, true, 6, new String [] {"light", "normal", "heavy", "sword", "axe", "bow"}),
	DWARF("DWARF", 200, 0, false, 6, new String [] {"light", "normal", "heavy", "sword", "axe"});
	
	private String race;
	private Integer maxHP;
	private Integer maxMP;
	private Boolean clm;
	private Integer maxBagSlots;
	private String usableItems[];
	
	private Race(String race, Integer maxHP, Integer maxMP, Boolean clm, Integer maxBagSlots, String usableItems[]) {
		this.race = race;
		this.maxHP = maxHP;
		this.maxMP = maxMP;
		this.clm = clm;
		this.maxBagSlots = maxBagSlots;
		this.usableItems = usableItems;
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
		return maxBagSlots;
	}

	public String[] getUsableItems() {
		return usableItems;
	}
}
