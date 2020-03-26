package de.telran.controller;


import de.telran.dto.ShipmentDTO;
import de.telran.dto.TrackingDTO;
import de.telran.entity.Shipment;
import de.telran.entity.Tracking;
import de.telran.service.TrackingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TrackingController {

    private TrackingService service;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public TrackingController(TrackingService service) {
        this.service = service;
    }


    @PostMapping("/api/shipments/{id}/trackings")
    TrackingDTO addTracking(@RequestBody TrackingDTO tracking, @PathVariable long id) {
        Tracking trackingEntity =
                new Tracking(tracking.getTrackingId(), tracking.getStatus(), id);
        return modelMapper.map(service.addTracking(trackingEntity), TrackingDTO.class);
    }


}
