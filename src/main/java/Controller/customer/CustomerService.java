package Controller.customer;

import java.util.List;

public interface CustomerService {
   boolean addCustomer(Customer customer);
    boolean updateCustomer(Customer customer);
    boolean deletCustomer(String id);
    Customer searchCustomer(String id);
    List<Customer> getAll();

}
