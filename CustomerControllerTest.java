package de.telran;


import de.telran.controller.CustomerController;
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

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TrackingService service;

    @Test
    public void testAddCustomer() throws Exception {
        Customer customerEntity = new Customer(null, "Ivan Petrov");
        Customer savedCustomerEntity = new Customer(1L, "Ivan Petrov");
        when(service.addCustomer(customerEntity)).thenReturn(savedCustomerEntity);

        mvc.perform(post("/api/customers")
                .content("{\"name\": \"Ivan Petrov\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.customerId").value("1"))
                .andExpect(jsonPath("$.name").value("Ivan Petrov"));

        verify(service, times(1)).addCustomer(customerEntity);
    }

    @Test
    public void testGetCustomerShipments() throws Exception {
        when(service.getAllShipments())
                .thenReturn(createListOfShipments());

        mvc.perform(get("/api/customers/7/shipments")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$[0].shipmentId").value("1"))
                .andExpect(jsonPath("$[0].description").value("Bosch"))
                .andExpect(jsonPath("$[0].customerId").value("7"))
                .andExpect(jsonPath("$[1].shipmentId").value("2"))
                .andExpect(jsonPath("$[1].description").value("TP-Link"))
                .andExpect(jsonPath("$[1].customerId").value("7"));

    }
    private List<Shipment> createListOfShipments(){
        Shipment shipment1 = new Shipment(
                1L,
                "Bosch",
                7L);
        Shipment shipment2 =new Shipment(
                2L,
                "TP-Link",
                7L
        );
        return Arrays.asList(shipment1, shipment2);
    }
}
