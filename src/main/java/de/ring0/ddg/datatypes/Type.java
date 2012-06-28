package de.ring0.ddg.datatypes;

/**
 * The DuckDuckGo service defines a few type for the presented search results.
 * 
 * @author Lennart Weller <lhw+github@ring0.de>
 */
public enum Type {
	ARTICLE("A"),
	DISAMBIGUATION("D"),
	CATEGORY("C"),
	NAME("N"),
	EXCLUSIVE("E"),
	UNKNOWN("");
	
	private String _type;
	
	Type(String type) {
		_type = type;
	}
	public String getType() {
		return _type;
	}
}