package au.com.automic.rule;

import java.math.BigDecimal;
import java.util.List;

import au.com.automic.Rule;
import au.com.automic.Tour;

/**
 * Rule 1: 3 for 2 deal on opera house ticket.
 * 
 * @author Kelvin Ho
 */
public class Rule1 implements Rule {

	@Override
	public BigDecimal apply(List<Tour> tours) {
		// remove 3 opera house tours from the list
		for (int i=0; i<3; i++) {
			tours.remove(Tour.OH);
		}
		
		// return the cost spent (i.e. 2 x opera house ticket)
		return Tour.OH.getPrice().multiply(new BigDecimal(2));
	}

	@Override
	public BigDecimal checkSavedAmount(List<Tour> tours) {
		// check if the tours are applicable to the rule.
		if (tours.stream().filter(t -> t.equals(Tour.OH)).count() >= 3) {
			// return the saved amount (i.e. 1 opera house ticket)
			return Tour.OH.getPrice();
		}
		
		// return null if not applicable
		return null;
	}
}
