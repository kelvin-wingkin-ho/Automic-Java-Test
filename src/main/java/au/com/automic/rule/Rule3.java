package au.com.automic.rule;

import java.math.BigDecimal;
import java.util.List;

import au.com.automic.Rule;
import au.com.automic.Tour;

/**
 * Rule 3: Sydney Bridge Climb bulk discount: the price will drop to $20, if someone buys more than 4
 * 
 * @author Kelvin Ho
 */
public class Rule3 implements Rule {

	@Override
	public BigDecimal apply(List<Tour> tours) {
		// check the no. of Sydney Bridge Climb tickets bought
		long cnt = tours.stream().filter(t -> t.equals(Tour.BC)).count();
		
		for (int i=0; i<cnt; i++) {
			tours.remove(Tour.BC);
		}
		return Tour.BC.getPrice().subtract(new BigDecimal(20)).multiply(new BigDecimal(cnt));
	}

	@Override
	public BigDecimal checkSavedAmount(List<Tour> tours) {
		// check the no. of Sydney Bridge Climb tickets bought
		long cnt = tours.stream().filter(t -> t.equals(Tour.BC)).count();
		
		// applicable if more than 5 tickets
		if (cnt > 4) {
			// the saved amount is [no. of tickets bought] x 20
			return (new BigDecimal(20)).multiply(new BigDecimal(cnt));	
		}
		
		// return null if not applicable
		return null;
	}

}
