package au.com.automic.rule;

import java.math.BigDecimal;
import java.util.List;

import au.com.automic.Rule;
import au.com.automic.Tour;
import au.com.automic.TourId;

/**
 * Rule 3: Sydney Bridge Climb bulk discount: the price will drop to $20, if someone buys more than 4
 * 
 * @author Kelvin Ho
 */
public class Rule3 implements Rule {

	@Override
	public BigDecimal apply(List<Tour> tours) {
		for (int i=0; i<5; i++) {
			tours.remove(new Tour(TourId.BC));
		}
		return TourId.BC.getPrice().subtract(new BigDecimal(20)).multiply(new BigDecimal(5));
	}

	@Override
	public BigDecimal checkSavedAmount(List<Tour> tours) {
		// applicable if more than 5 tickets
		if (tours.stream().filter(t -> t.getId().equals(TourId.BC)).count() > 4) {
			// the saved amount is 5 x (Sydney Bridge Climb - 20)
			return (new BigDecimal(20)).multiply(new BigDecimal(5));	
		}
		
		// return null if not applicable
		return null;
	}

}
