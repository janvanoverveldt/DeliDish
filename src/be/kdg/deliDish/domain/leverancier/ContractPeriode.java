package be.kdg.hiFresh.domain.leverancier;

import be.kdg.foundation.qualified.Hoeveelheid;
import be.kdg.hiFresh.domain.recept.Product;

import java.time.LocalDate;
import java.util.logging.Logger;

/**
 * @author Jan de Rijke.
 */
public class ContractPeriode {
    private static Logger logger = Logger.getLogger(
            "be.kdg.hiFresh.domain.leverancier.ContractPeriode");
    private double prijs;
    private LocalDate van; //inclusive
    private LocalDate tot; //inclusive
    private Hoeveelheid maxHoeveelheid;
    private Product product;
    /**
     * bidirectionele navigeerbaarheid omdat contract nodig is om uniciteit van contractperiodes in repository te verzekeren
     */
    private Contract contract;


    public ContractPeriode(
            double prijs,
            LocalDate van,
            LocalDate tot,
            Hoeveelheid maxHoeveelheid, Product product, Contract contract) {
        this.prijs = prijs;
        this.van = van;
        this.tot = tot;
        this.maxHoeveelheid = maxHoeveelheid;
        this.product = product;
        this.contract = contract;
    }

    public Contract getContract() {
        return contract;
    }

    public Product getProduct() {
        return product;
    }

    public double getEenheidsPrijs() {
        return prijs;
    }

    public LocalDate getVan() {
        return van;
    }

    public LocalDate getTot() {
        return tot;
    }

    public Hoeveelheid getMaxHoeveelheid() {
        return maxHoeveelheid;
    }

    public boolean isGeldigVoor(LocalDate date) {
        return !date.isBefore(van) && !date.isAfter(tot);
    }

    public boolean isGeldigVoor(Product product, LocalDate date) {
        return this.product.equals(product) && isGeldigVoor(date);
    }
}
