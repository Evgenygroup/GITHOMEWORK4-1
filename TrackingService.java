package de.telran.service;

import de.telran.entity.Customer;
import de.telran.entity.Shipment;
import de.telran.repositiory.TrackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrackingService {


@Autowired
private TrackingRepository repository;

    public Customer addCustomer(Customer customer) {
        Customer savedCustomer = repository.save(customer);
        return savedCustomer;
    }

    public Shipment addShipment(Shipment shipment) {
        return null;
    }

}
