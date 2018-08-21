package be.kdg.infra;


import be.kdg.hiFresh.domain.leverancier.Contract;

public class ContractMemoryRepository<V> extends MemoryRepository<Contract> {

    @Override
    public boolean put(Contract contract) {
        return super.put(contract);
    }
}
