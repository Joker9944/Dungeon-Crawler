package dc.character;

public class Char {

	protected String name;
	protected Race race;
	protected Double HP;
	protected Double MP;
	
	protected Char(String name, Race race) {
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

	public Double getHP() {
		return HP;
	}

	public void setHP(Double HP) {
		this.HP = HP;
	}
	
	public Double getMP() {
		return MP;
	}

	public void setMP(Double MP) {
		this.MP = MP;
	}

	public Boolean getClm() {
		return race.getClm();
	}
}