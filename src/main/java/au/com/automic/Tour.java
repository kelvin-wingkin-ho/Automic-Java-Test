package au.com.automic;

import java.math.BigDecimal;

public enum Tour {
	
	OH(300, "Opera house tour"), BC(110,"Sydney Bridge Climb"), SK(30, "Sydney Sky Tower");
	
	private final BigDecimal price;
	private final String name;
	
	private Tour(int price, String name) {
		this.price = new BigDecimal(price);
		this.name = name;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public String getName() {
		return name;
	}
}
