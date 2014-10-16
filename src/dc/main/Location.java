package dc.main;

public enum Location {

	// Locationname, Encounterchanche, Initiativechanche
	WALL("Wall", 0, 0),
	CORRIDOR("Corridor", 5, 50),
	DOOR("Door", 50, 80),
	CHEST("Chest", 30, 20);
	
	private String name;
	private Integer chanche;
	private Integer initiative;
	
	private Location(String name, Integer chanche, Integer initiative) {
		this.name = name;
		this.chanche = chanche;
		this.initiative = initiative;
	}
	
	public String getName() {
		return name;
	}
	
	public Integer getChanche() {
		return chanche;
	}
	
	public Integer getInitiative() {
		return initiative;
	}
}
