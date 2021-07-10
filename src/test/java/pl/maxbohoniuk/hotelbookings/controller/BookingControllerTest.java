package pl.maxbohoniuk.hotelbookings.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pl.maxbohoniuk.hotelbookings.repository.BookingRepository;
import pl.maxbohoniuk.hotelbookings.service.BookingService;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class BookingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookingService bookingService;


    @Test
    void getAllBookings()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/api/booking"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    void openBooking()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/api/booking/1").content("{\n" +
                "    \"checkInDate\":\"2021-07-10\",\n" +
                "    \"checkOutDate\":\"2021-07-16\",\n" +
                "    \"user\":{\n" +
                "        \"id\":\"1\"\n" +
                "    },\n" +
                "    \"guestsCount\":2\n" +
                "}").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    void openBooking2()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/api/booking/10").content("{\n" +
                "    \"checkInDate\":\"2021-07-10\",\n" +
                "    \"checkOutDate\":\"2021-07-16\",\n" +
                "    \"user\":{\n" +
                "        \"id\":\"1\"\n" +
                "    },\n" +
                "    \"guestsCount\":2\n" +
                "}").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
    }
}