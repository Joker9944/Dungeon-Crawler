package dc.item;

public class Item {

	//TODO Implement Consumebels (Potions)
	
	private String name;
	private String description = "lazors!! :<"; //TODO Item description
	private ItemCategory category;
	private ItemTyp typ;
	private Double value;
	
	public Item(String name, ItemCategory category, ItemTyp typ, Double value) {
		this.name = name;
		this.category = category;
		this.typ = typ;
		this.value = value;
	}

	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public ItemCategory getCategory() {
		return category;
	}
	
	public ItemTyp getTyp() {
		return typ;
	}
	
	public Double getValue() {
		return value*category.getScaling()*typ.getScaling();
	}
}