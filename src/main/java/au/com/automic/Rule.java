package au.com.automic;

import java.math.BigDecimal;
import java.util.List;

/**
 * The interface that every rule must implement.
 * 
 * @author Kelvin Ho
 */
public interface Rule {
	/**
	 * Checks if the rule is applicable to the given tours. If yes, returns the possible amount saved, otherwise return null.
	 * 
	 * @param tours the tours to be checked.
	 * @return the amounts saved or null if the rule is not applicable.
	 */
	public abstract BigDecimal checkSavedAmount(List<Tour> tours);
	
	/**
	 * Applies the rule to the tours. Removes the tours from the list and returns the cost spent.
	 * 
	 * @param tours the tours to be applied.
	 * @return the cost spent.
	 */
	public abstract BigDecimal apply(List<Tour> tours);
}
