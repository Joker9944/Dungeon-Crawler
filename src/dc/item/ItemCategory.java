package dc.item;

public enum ItemCategory {

	LIGHT("LIGHT", 0.5),
	NORMAL("NORMAL", 1D),
	HEAVY("HEAVY", 1.5);
	
	private String category;
	private Double scaling;
	
	private ItemCategory(String category, Double scaling) {
		this.category = category;
		this.scaling = scaling;
	}
	
	public String getCategory() {
		return category;
	}
	
	public Double getScaling() {
		return scaling;
	}
}
