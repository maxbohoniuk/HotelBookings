package pl.maxbohoniuk.hotelbookings.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.maxbohoniuk.hotelbookings.model.User;
import pl.maxbohoniuk.hotelbookings.repository.UserRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User addUser(User user){
        return userRepository.save(user);
    }

    public void addUsers(User... users){
        Arrays.asList(users).forEach((u)->userRepository.save(u));
    }

    public User getUserById(long id)throws Exception{
        if(userRepository.existsById(id)){
            return userRepository.getById(id);
        }
        else{
            throw new Exception("User with id = " + id + " not found");
        }
    }

}

