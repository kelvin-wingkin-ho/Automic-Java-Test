package au.com.automic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

	private List<Rule> rules;
	private List<Tour> tours = new ArrayList<Tour>();

	/**
	 * Creates a shopping cart with given promotion rules.
	 * 
	 * @param rules the promotion rules.
	 */
	public ShoppingCart(List<Rule> rules) {
		this.rules = rules;
	}

	/**
	 * Adds the tour.
	 * 
	 * @param tour
	 */
	public void add(Tour tour) {
		this.tours.add(tour);
	}

	/**
	 * Returns the total.
	 * 
	 * @return the total.
	 */
	public BigDecimal total() {
		BigDecimal total = BigDecimal.ZERO;


		while (true) {
			// find the rule that saved most
			Rule bestRule = null;
			BigDecimal maxSaved = BigDecimal.ZERO;
			for (Rule rule : rules) {
				BigDecimal savedAmount = rule.checkSavedAmount(tours);
				if (savedAmount != null && savedAmount.compareTo(maxSaved) > 0) {
					bestRule = rule;
				}
			}

			// apply the rule
			if (bestRule != null) {
				total = total.add(bestRule.apply(tours));
			}
			else {
				// if no rule is applicable, exit the loop
				break;
			}
		}
		
		// calculate the remaining tours
		for (Tour tour: tours) {
			total = total.add(tour.getPrice());
		}

		return total;
	}
}
