package be.kdg.foundation.operatie;


/**
 * @author Jan de Rijke.
 * Een operatie is een filterconditie die meegegeven wordt bij bijvoorbeeld zoekRecepten.
 * Een voorbeeldgebruik voor recept: new Operatie("naam", Operator.CONTAINS, "curry")).
 * De filter wordt doorgegeven aan de Repository zodat deze de operaties kan gebruiken om de terug te geven collectie te filteren.
 */
//TODO: This class is not used
public class Operatie {
    private String field;
    private Operator operator;
    private String value;

    public Operatie(String target, Operator operator, String value) {
        this.field = target;
        this.operator = operator;
        this.value = value;
    }

    public String getField() {
        return field;
    }

    public Operator getOperator() {
        return operator;
    }

    public String getValue() {
        return value;
    }

}
