package dc.main;

public enum Direction {

	WALL("Wall", 0),
	CORRIDOR("Corridor", 5),
	DOOR("Door", 50),
	CHEST("Chest", 30);
	
	private String name;
	private Integer chanche;
	
	private Direction(String name, Integer chanche) {
		this.name = name;
		this.chanche = chanche;
	}
	
	public String getName() {
		return name;
	}
	
	public Integer getChanche() {
		return chanche;
	}
}
