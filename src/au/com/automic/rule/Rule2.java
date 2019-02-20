package au.com.automic.rule;

import java.math.BigDecimal;
import java.util.List;

import au.com.automic.Rule;
import au.com.automic.Tour;

/**
 * Rule 2: give a free Sky Tower tour for with every Opera House tour sold.
 * 
 * @author Kelvin Ho
 */
public class Rule2 implements Rule {

	@Override
	public BigDecimal apply(List<Tour> tours) {
		tours.remove(Tour.OH);
		tours.remove(Tour.SK);
		
		// the cost spent is 1 opera house ticket price
		return Tour.OH.getPrice();
	}

	@Override
	public BigDecimal checkSavedAmount(List<Tour> tours) {
		// if the tours has more than one Opera House and one Sky Tower
		if (tours.stream().anyMatch(t -> t.equals(Tour.OH)) && tours.stream().anyMatch(t -> t.equals(Tour.SK))) {
			// save the price of one sky tower ticket
			return Tour.SK.getPrice();			
		}
		
		// return null if not applicable
		return null;
	}

}
