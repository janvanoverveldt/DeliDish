package be.kdg.foundation.operatie;

/**
 * @author Jan de Rijke.
 */
public enum Operator {
    CONTAINS("IN"),
    EQUALS("="),
    GREATER(">"),
    GREATER_OR_EQUALS(">="),
    LOWER("<"),
    LOWER_OR_EQUALS("<=");

    private final String symbool;

    Operator(String symbool) {

        this.symbool = symbool;
    }

    public String getSymbool() {
        return symbool;
    }
}
