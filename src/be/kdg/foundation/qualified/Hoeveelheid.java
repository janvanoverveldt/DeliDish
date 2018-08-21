package be.kdg.foundation.qualified;


import static be.kdg.foundation.qualified.Eenheid.GRAM;

/**
 * @author Jan de Rijke.
 */
public class Hoeveelheid {
    private static final Hoeveelheid STANDAARD = new Hoeveelheid(1000, GRAM);
    private double aantal;
    private Eenheid eenheid;

    public Hoeveelheid(double aantal, Eenheid eenheid) {
        this.aantal = aantal;
        this.eenheid = eenheid;
    }

    public static Hoeveelheid getStandaard() {
        return STANDAARD;
    }

    @Override
    public String toString() {
        return aantal +
                " " + eenheid;
    }

    public double getAantal() {
        return aantal;
    }

    public Eenheid getEenheid() {
        return eenheid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hoeveelheid)) return false;

        Hoeveelheid that = (Hoeveelheid) o;

        if (Double.compare(that.getAantal(), getAantal()) != 0) return false;
        return getEenheid() == that.getEenheid();
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getAantal());
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (getEenheid() != null ? getEenheid().hashCode() : 0);
        return result;
    }
}
