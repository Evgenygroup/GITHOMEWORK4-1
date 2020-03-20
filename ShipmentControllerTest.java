package de.telran;

import de.telran.controller.CustomerController;
import de.telran.controller.ShipmentController;
import de.telran.dto.ShipmentDTO;
import de.telran.entity.Customer;
import de.telran.entity.Shipment;
import de.telran.service.TrackingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ShipmentController.class)
public class ShipmentControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TrackingService service;


     @Test
    public void testAddShipment() throws Exception {
        Shipment shipmentEntity = new Shipment(null," Sony TV",3L);
        Shipment savedShipmentEntity = new Shipment(5L, "Sony TV",3L);
        when(service.addShipment(shipmentEntity)).thenReturn(savedShipmentEntity);

        mvc.perform(post("/api/customers/3/shipments")
                .content("{\"description\": \"Sony TV\",\"customerId\":\"3\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.shipmentId").value("5"))
                .andExpect(jsonPath("$.description").value("Sony TV"))
                .andExpect(jsonPath("$.customerId").value("3"));

        verify(service, times(1)).addShipment(shipmentEntity);
    }


}
