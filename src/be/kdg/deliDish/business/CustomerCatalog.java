package be.kdg.deliDish.business;

import be.kdg.deliDish.business.domain.customer.Customer;
import be.kdg.infra.MemoryRepository;

import java.util.Collection;

public class CustomerCatalog {
    private final MemoryRepository<Customer> customerRepo = new MemoryRepository<>();

    public void addCustomer(Customer customer) {
        customerRepo.put(customer);
    }

    /**
     * Gets all customers in de repository
     *
     * @return all available Customers in the repository
     */
    public Collection<Customer> getCustomers() {
        return customerRepo.entities();
    }


}
