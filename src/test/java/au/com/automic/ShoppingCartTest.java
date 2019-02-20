package au.com.automic;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import au.com.automic.rule.Rule1;
import au.com.automic.rule.Rule2;
import au.com.automic.rule.Rule3;

class ShoppingCartTest {
	private ShoppingCart sp;
	
	@BeforeEach
	public void executedBeforeEach() {
		// setup the rules
		List<Rule> rules = new ArrayList<Rule>();
		rules.add(new Rule1());
		rules.add(new Rule2());
		rules.add(new Rule3());
		
		// setup the shopping cart
		sp = new ShoppingCart(rules);
    } 

	@Test
	void test1() {
		sp.add(Tour.OH);
		sp.add(Tour.OH);
		sp.add(Tour.OH);
		sp.add(Tour.BC);
		assertEquals(new BigDecimal(710), sp.total());
	}
	
	@Test
	void test2() {
		sp.add(Tour.OH);
		sp.add(Tour.SK);
		assertEquals(new BigDecimal(300), sp.total());
	}
	
	@Test
	void test3() {
		sp.add(Tour.BC);
		sp.add(Tour.BC);
		sp.add(Tour.BC);
		sp.add(Tour.BC);
		sp.add(Tour.BC);
		sp.add(Tour.OH);
		assertEquals(new BigDecimal(750), sp.total());
	}
}
