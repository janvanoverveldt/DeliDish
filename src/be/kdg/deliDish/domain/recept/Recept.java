package be.kdg.hiFresh.domain.recept;


import be.kdg.hiFresh.domain.business.ContractCatalog;
import be.kdg.hiFresh.domain.leverancier.Contract;

import java.time.Duration;
import java.util.List;

/**
 * @author Jan de Rijke.
 */
public class Recept {
    // TODO0: implementeer klasse
    private String naam;
    private Duration bereidingsTijd;
    private int moeilijkheid;
    private List<String> instructies;
    private List<Ingredient> ingredients;
    private Label label;
    private double prijsPP;

    // automatisch gegenereerde constructor
    public Recept(String naam, Duration bereidingsTijd, int moeilijkheid, List<String> instructies, List<Ingredient> ingredients, Label label) {
        this.naam = naam;
        this.bereidingsTijd = bereidingsTijd;
        this.moeilijkheid = moeilijkheid;
        this.instructies = instructies;
        this.ingredients = ingredients;
        this.label = label;
    }

    // met opdracht gegeven constructor
    public Recept(String naam, Duration bereidingsTijd, int moeilijkheid, List<String> instructies, List<Ingredient> ingredients) {
        this.naam = naam;
        this.bereidingsTijd = bereidingsTijd;
        this.moeilijkheid = moeilijkheid;
        this.instructies = instructies;
        this.ingredients = ingredients;
    }


    public void addLabel(Label label) {
        //TODO0
        this.label = label;
    }

    public String getNaam() {
        //TODO0
        return this.naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Duration getBereidingsTijd() {
        return bereidingsTijd;
    }

    public void setBereidingsTijd(Duration bereidingsTijd) {
        this.bereidingsTijd = bereidingsTijd;
    }

    public int getMoeilijkheid() {
        return moeilijkheid;
    }

    public void setMoeilijkheid(int moeilijkheid) {
        this.moeilijkheid = moeilijkheid;
    }

    public List<String> getInstructies() {
        return instructies;
    }

    public void setInstructies(List<String> instructies) {
        this.instructies = instructies;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Label getLabel() {
        return label;
    }

    //Bereken Prijs
    public Double berekenPrijsPerPersoon(ContractCatalog contractCatalog) {
        for (Ingredient ingredient : ingredients) {
            for (Contract contract : contractCatalog.getContracten()) {
                if (ingredient.getProduct().getNaam().equals(contract.getContractPeriode().getProduct().getNaam())) {
                    prijsPP += contract.getContractPeriode().getEenheidsPrijs();
                }
            }
        }
        return prijsPP;
    }

    public Double getPrijsPP() {
        return prijsPP;
    }
}
