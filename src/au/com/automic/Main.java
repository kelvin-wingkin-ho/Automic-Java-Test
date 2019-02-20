package au.com.automic;

import java.util.ArrayList;
import java.util.List;

import au.com.automic.rule.Rule1;
import au.com.automic.rule.Rule2;
import au.com.automic.rule.Rule3;

/**
 * The Main class for testing.
 * 
 * @author Kelvin Ho
 */
public class Main {

	public static void main(String[] args) {
		List<Rule> rules = new ArrayList<Rule>();
		rules.add(new Rule1());
		rules.add(new Rule2());
		rules.add(new Rule3());
		
		ShoppingCart sp = new ShoppingCart(rules);
		sp.add(new Tour(TourId.OH));
		sp.add(new Tour(TourId.OH));
		sp.add(new Tour(TourId.OH));
		sp.add(new Tour(TourId.BC));
		System.out.println(sp.total());
		
		sp = new ShoppingCart(rules);
		sp.add(new Tour(TourId.OH));
		sp.add(new Tour(TourId.SK));
		System.out.println(sp.total());
		
		sp = new ShoppingCart(rules);
		sp.add(new Tour(TourId.BC));
		sp.add(new Tour(TourId.BC));
		sp.add(new Tour(TourId.BC));
		sp.add(new Tour(TourId.BC));
		sp.add(new Tour(TourId.BC));
		sp.add(new Tour(TourId.OH));
		System.out.println(sp.total());
	}
}
