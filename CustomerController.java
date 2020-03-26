package de.telran.controller;

import de.telran.dto.CustomerDTO;
import de.telran.dto.ShipmentDTO;
import de.telran.entity.Customer;
import de.telran.service.TrackingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CustomerController {

    private TrackingService service;

    @Autowired
    private ModelMapper modelMapper;


    @Autowired
    public CustomerController(TrackingService service){
        this.service=service;
    }

    @PostMapping("/api/customers")
    CustomerDTO addCustomer(@RequestBody CustomerDTO customer) {
        Customer customerEntity = modelMapper.map(customer, Customer.class);
        return modelMapper.map(service.addCustomer(customerEntity), CustomerDTO.class);
    }
    @GetMapping("/api/customers/{id}/shipments")
    List<ShipmentDTO> CustomerShipments(@PathVariable long id){
        return service.getAllShipments()
                .stream()
                .map(s -> modelMapper.map(s, ShipmentDTO.class))
                .collect(Collectors.toList());
    }







}
