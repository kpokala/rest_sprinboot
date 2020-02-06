package payroll;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.DoubleStream;

public class CustomerRepository{

    Customer findById(Long id){
        return new Customer((long)1,"Test","Admin");
    }

    List<Customer> findAll(){
        List<Customer> list = new ArrayList();
        list.add(new Customer((long)1,"Test","Admin"));
        return list;
    }

    Customer save(Customer customer){
        return customer;
    }



    void deleteById(Long id){

    }
}
