package dc.character;

enum RaceBlank {

	//TODO DropTable, Balancing
	
	SPIDER(Race.SPIDER, 5D);
	
	private Race owner;
	private Double damage;
	
	private RaceBlank(Race owner, Double damage) {
		this.owner = owner;
		this.damage = damage;
	}

	public Race getOwner() {
		return owner;
	}

	public Double getDamage() {
		return damage;
	}
}
