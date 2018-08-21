package be.kdg.deliDish.domain.recept;

import be.kdg.foundation.qualified.Hoeveelheid;

import java.util.logging.Logger;

/**
 * @author Jan de Rijke.
 */
public class Ingredient {
    private static Logger logger = Logger.getLogger("be.kdg.deliDish.domain.recept.Ingredient");
    private Hoeveelheid persoonsHoeveelheid;
    private Product product;

    public Ingredient(Product product, Hoeveelheid persoonsHoeveelheid) {
        this.persoonsHoeveelheid = persoonsHoeveelheid;
        this.product = product;
    }

    public Hoeveelheid getPersoonsHoeveelheid() {
        return persoonsHoeveelheid;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return persoonsHoeveelheid +
                " " + product;
    }
}
