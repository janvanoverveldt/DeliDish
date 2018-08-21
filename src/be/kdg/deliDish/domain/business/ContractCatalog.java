package be.kdg.deliDish.domain.business;

import be.kdg.deliDish.domain.leverancier.Contract;
import be.kdg.infra.ContractMemoryRepository;

import java.util.Collection;

public class ContractCatalog {
    private final ContractMemoryRepository<Contract> contracten = new ContractMemoryRepository();

    public void addContract(Contract contract) {
        contracten.put(contract);
    }

    public Collection<Contract> getContracten() {
        return contracten.entities();
    }
}
