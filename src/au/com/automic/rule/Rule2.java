package au.com.automic.rule;

import java.math.BigDecimal;
import java.util.List;

import au.com.automic.Rule;
import au.com.automic.Tour;
import au.com.automic.TourId;

/**
 * Rule 2: give a free Sky Tower tour for with every Opera House tour sold.
 * 
 * @author Kelvin Ho
 */
public class Rule2 implements Rule {

	@Override
	public BigDecimal apply(List<Tour> tours) {
		tours.remove(new Tour(TourId.OH));
		tours.remove(new Tour(TourId.SK));
		
		// the cost spent is 1 opera house ticket price
		return TourId.OH.getPrice();
	}

	@Override
	public BigDecimal checkSavedAmount(List<Tour> tours) {
		// if the tours has more than one Opera House and one Sky Tower
		if (tours.stream().anyMatch(t -> t.getId().equals(TourId.OH)) && tours.stream().anyMatch(t -> t.getId().equals(TourId.SK))) {
			// save the price of one sky tower ticket
			return TourId.SK.getPrice();			
		}
		
		// return null if not applicable
		return null;
	}

}
