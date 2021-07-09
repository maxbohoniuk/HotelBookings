package pl.maxbohoniuk.hotelbookings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.maxbohoniuk.hotelbookings.model.User;

public interface UserRepository extends JpaRepository<User,Long> {



}
