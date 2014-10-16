package dc.character;

public class Char {

	protected String name;
	protected Race race;
	protected Integer HP;
	protected Integer MP;
	
	protected Char(Race race) {
		creat(race.getRace(), race);
	}
	
	protected Char(String name, Race race) {
		creat(name, race);
	}
	
	private void creat(String name, Race race) {
		this.name = name;
		this.race = race;
		HP = race.getMaxHP();
		MP = race.getMaxMP();
	}
	
	// get and set
	public String getName() {
		return name;
	}

	public Race getRace() {
		return race;
	}

	public Integer getMaxHP() {
		return race.getMaxHP();
	}

	public Integer getHP() {
		return HP;
	}

	public void setHP(Integer HP) {
		this.HP = HP;
	}

	public Integer getMaxMP() {
		return race.getMaxMP();
	}
	
	public Integer getMP() {
		return MP;
	}

	public void setMP(Integer MP) {
		this.MP = MP;
	}

	public Boolean getClm() {
		return race.getClm();
	}
}