package be.kdg.foundation.qualified;


/**
 * @author Jan de Rijke.
 */
public enum Eenheid {
    GRAM("g"),
    MILILITER("ml"),
    MILIMETER("mm"),
    STUK("st"),
    TEEN("teentje(s)"),
    STENGEL("stengel(s))"),
    THEELEPEL("tl"),
    EETLEPEL("el"),
    CENTIMETER("cm"),
    CENTILITER("cl"),
    LITER("l");
    private String afkorting;

    Eenheid(String afkorting) {
        this.afkorting = afkorting;
    }

    public String afkorting() {
        return afkorting;
    }


}
