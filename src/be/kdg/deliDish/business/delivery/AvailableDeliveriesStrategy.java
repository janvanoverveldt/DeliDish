package be.kdg.deliDish.business.delivery;

import be.kdg.deliDish.business.domain.order.Order;
import be.kdg.deliDish.business.domain.user.Courier;
import be.kdg.foundation.contact.Country;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AvailableDeliveriesStrategy {


	private final Map<Country, AvailableDeliveriesSelector> availableDeliverieSelectors=new ConcurrentHashMap<>();


private  AvailableDeliveriesSelector getAvailableDeliveriesSelector(Country country){
	final AvailableDeliveriesSelector selector = availableDeliverieSelectors.get(
		country);
	return selector!=null?selector:getAvailableDeliveriesSelector();
}
	private  AvailableDeliveriesSelector getAvailableDeliveriesSelector(){
		return availableDeliverieSelectors.get(Country.DEFAULT);
	}

	//


	public  void addAvailableDeliveriesSelector(Country country, AvailableDeliveriesSelector ads) {
		availableDeliverieSelectors.put(country, ads);
	}

	public  Collection<Order> getAvailableDeliveries(Courier courier) {
		return getAvailableDeliveriesSelector(courier.getContactInfo().getAdress().getCity().getCountry())
			.getAvailableDeliveries(courier);
	}
}