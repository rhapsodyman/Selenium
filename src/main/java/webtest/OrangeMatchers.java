package webtest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.awt.Color;
import java.awt.Shape;

import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;

public class OrangeMatchers {

	public static Matcher<Fruit> hasShape(final Shape shape) {
		return new FeatureMatcher<Fruit, Shape>(equalTo(shape), "fruit has shape - ", "shape -") {
			@Override
			protected Shape featureValueOf(Fruit fruit) {
				return fruit.getShape();
			}
		};
	}

	/*public static Matcher<Fruit> round() {
		return hasShape(Shape.ROUND);
	}
*/
	public static Matcher<Fruit> sweet() {
		return new FeatureMatcher<Fruit, Boolean>(is(true), "fruit should be sweet", "sweet -") {
			@Override
			protected Boolean featureValueOf(Fruit fruit) {
				return fruit.isSweet();
			}
		};
	}

	public static Matcher<Fruit> hasColor(final Color color) {
		return new FeatureMatcher<Fruit, Color>(equalTo(color), "fruit have color - ", "color -") {
			@Override
			protected Color featureValueOf(Fruit fruit) {
				return fruit.getColor();
			}
		};
	}

}