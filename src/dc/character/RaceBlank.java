package dc.character;

enum RaceBlank {

	//TODO DropTable, Balancing
	
	SPIDER(Race.SPIDER, false, 2, 5D);
	
	private Race owner;
	private Boolean hasName;
	private Integer unitCost;
	private Double damage;
	
	private RaceBlank(Race owner, Boolean hasName, Integer unitCost, Double damage) {
		this.owner = owner;
		this.hasName = hasName;
		this.unitCost = unitCost;
		this.damage = damage;
	}

	public Race getOwner() {
		return owner;
	}
	
	public Boolean getHasName() {
		return hasName;
	}
	
	public Integer getUnitCost() {
		return unitCost;
	}

	public Double getDamage() {
		return damage;
	}
}
