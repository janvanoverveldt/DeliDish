package be.kdg.deliDish.business.delivery;

import be.kdg.deliDish.business.domain.user.Courier;
import be.kdg.foundation.contact.Country;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DeliveriesFilterSelector {


	private final Map<Country, DeliveriesFilter> deliveriesFilters =new ConcurrentHashMap<>();


private DeliveriesFilter getDeliveriesFilter(Country country){
	final DeliveriesFilter selector = deliveriesFilters.get(country);
	return selector!=null?selector: getDeliveriesFilter();
}
	private DeliveriesFilter getDeliveriesFilter(){
		return deliveriesFilters.get(Country.DEFAULT);
	}

	//


	public  void addDeliveriesFilter(Country country, DeliveriesFilter ads) {
		deliveriesFilters.put(country, ads);
	}

	public DeliveriesFilter getDeliveriesFilter(Courier courier) {
		return getDeliveriesFilter(courier.getContactInfo().getAdress().getCity().getCountry());	}
}