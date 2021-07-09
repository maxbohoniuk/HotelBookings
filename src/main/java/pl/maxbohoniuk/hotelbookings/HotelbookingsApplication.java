package pl.maxbohoniuk.hotelbookings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.maxbohoniuk.hotelbookings.model.User;
import pl.maxbohoniuk.hotelbookings.repository.UserRepository;

import java.sql.Date;
import java.time.LocalDate;

@SpringBootApplication
public class HotelbookingsApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelbookingsApplication.class, args);

    }

}
