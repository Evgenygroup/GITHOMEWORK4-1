package de.telran.controller;

import de.telran.dto.CustomerDTO;
import de.telran.dto.ShipmentDTO;
import de.telran.dto.TrackingDTO;
import de.telran.entity.Customer;
import de.telran.entity.Shipment;
import de.telran.entity.Tracking;
import de.telran.service.TrackingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrackingController {

    private TrackingService service;
    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public TrackingController (TrackingService service){
        this.service=service;
    }

    @PostMapping("/api/customers")
    CustomerDTO addCustomer(@RequestBody CustomerDTO customer) {
        System.out.println(customer);
        Customer customerEntity = modelMapper.map(customer, Customer.class);
        System.out.println(customerEntity);
        return modelMapper.map(service.addCustomer(customerEntity), CustomerDTO.class);
    }

    @PostMapping("/api/customers{id}/shipments/")
    ShipmentDTO addShipment(@RequestBody ShipmentDTO shipment) {
        return shipment;
    }

    @PostMapping("/api/shipments{id}/trackings")
    TrackingDTO addTracking(@RequestBody TrackingDTO tracking) {
        return tracking;
    }




}
