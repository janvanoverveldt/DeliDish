package be.kdg.hiFresh.domain;

import be.kdg.foundation.contact.Adres;

import java.util.List;

public class Restaurant {
    private String Name;
    private float lattitude;
    private float longitude;
    private Adres adres;
    private List<RestaurantOpening> openingShedule;
}
