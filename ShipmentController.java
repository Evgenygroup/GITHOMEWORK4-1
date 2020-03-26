package de.telran.controller;

import de.telran.dto.CustomerDTO;
import de.telran.dto.ShipmentDTO;
import de.telran.dto.TrackingDTO;
import de.telran.entity.Customer;
import de.telran.entity.Shipment;
import de.telran.service.TrackingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ShipmentController {

    private TrackingService service;

    @Autowired
    private ModelMapper modelMapper;


    @Autowired
    public ShipmentController(TrackingService service){
        this.service=service;
    }

    @PostMapping("/api/customers/{id}/shipments")
    ShipmentDTO addShipment(@RequestBody ShipmentDTO shipment, @PathVariable long id ) {
        Shipment shipmentEntity =
                new Shipment(shipment.getShipmentId(),shipment.getDescription(),id);
        return modelMapper.map(service.addShipment(shipmentEntity),ShipmentDTO.class);
    }

    @GetMapping("/api/shipments/{id}/trackings")
    TrackingDTO getLastTrackingByShipmentId(@PathVariable long id) {
        return modelMapper.map(service.getTrackingById(id), TrackingDTO.class);
    }



}
