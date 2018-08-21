package be.kdg.hiFresh.domain.leverancier;

import java.time.LocalDate;
import java.util.logging.Logger;

/**
 * @author Jan de Rijke.
 */
public class Contract {
    private static Logger logger = Logger.getLogger("be.kdg.hiFresh.domain.leverancier.Contract");
    private final LocalDate datum;
    private final int contractNummer;
    private final Leverancier leverancier;
    private ContractPeriode contractPeriode;


    // TODO0: implementeer klasse
    public Contract(Leverancier leverancier, int i, LocalDate of) {
        this.leverancier = leverancier;
        this.contractNummer = i;
        this.datum = of;
    }

    public void add(ContractPeriode periode) {
        this.contractPeriode = periode;
    }

    public ContractPeriode getContractPeriode() {
        return contractPeriode;
    }
}
