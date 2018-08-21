package be.kdg.deliDish.domain.recept;

/**
 * @author Jan de Rijke.
 */
public enum Label {
    GLUTENVRIJ("Zonder gluten"),
    KINDER("Kindvriendelijk"),
    LIGHT("Calorie-arm"),
    VIS("Met vis of zeevruchten"),
    VEGGIE("Zonder vlees of vis"),
    VEGAN("Geen ingrediënten van dierlijke oorsprong");

    private final String omschrijving;

    Label(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    @Override
    public String toString() {
        return omschrijving;
    }

    boolean isVegetarisch() {
        return this == VEGGIE || this == VEGAN;
    }
}
