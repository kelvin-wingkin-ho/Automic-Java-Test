package au.com.automic;

import java.math.BigDecimal;

public enum TourId {
	
	OH(300), BC(110), SK(30);
	
	private final BigDecimal price;
	
	private TourId(int price) {
		this.price = new BigDecimal(price);
	}
	
	public BigDecimal getPrice() {
		return price;
	}
}
