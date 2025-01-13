package huy.module4course02.service;

import huy.module4course02.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    private List<Customer> customers;

    @Autowired
    public CustomerService() {
        customers = new ArrayList<Customer>();
        customers.add(new Customer(1, "Nguyễn Văn A", "a@gmail.com", "Hà Nội"));
        customers.add(new Customer(2, "Nguyễn Văn B", "b@gmail.com", "Đà Nẵng"));
        customers.add(new Customer(3, "Nguyễn Văn C", "c@gmail.com", "Ninh Bình"));
        customers.add(new Customer(4, "Nguyễn Văn D", "d@gmail.com", "Mộc Châu"));
        customers.add(new Customer(5, "Nguyễn Văn E", "e@gmail.com", "Hải Phòng"));
        customers.add(new Customer(6, "Nguyễn Văn F", "f@gmail.com", "Sài Gòn"));
    }

    public List<Customer> findAll() {
        return customers;
    }

    public Customer findById(final long id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    public void update(final Customer customer) {
        for (Customer cus : customers) {
            if (cus.getId() == customer.getId()) {
                cus.setName(customer.getName());
                cus.setEmail(customer.getEmail());
                cus.setAddress(customer.getAddress());
            }
        }
    }
}
