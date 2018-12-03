package be.kdg.deliDish.business.delivery;

import be.kdg.foundation.contact.Country;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AvailableDeliveriesSelectorFactory {


	private static Map<Country, AvailableDeliveriesSelector> availableDeliverieSelectors=new ConcurrentHashMap<>();


public static AvailableDeliveriesSelector getAvailableDeliveriesSelector(Country country){
	final AvailableDeliveriesSelector selector = availableDeliverieSelectors.get(
		country);
	return selector!=null?selector:getAvailableDeliveriesSelector();
}
	public static AvailableDeliveriesSelector getAvailableDeliveriesSelector(){
		return availableDeliverieSelectors.get(Country.DEFAULT);
	}



	private AvailableDeliveriesSelectorFactory() {
	}

	public static void addAvailableDeliveriesSelector(Country country, AvailableDeliveriesSelector ads) {
		availableDeliverieSelectors.put(country, ads);
	}
}