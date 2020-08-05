package fr.mistral.backendprojects.javatechie.web;


import fr.mistral.backendprojects.javatechie.dao.UserRepository;
import fr.mistral.backendprojects.javatechie.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/register")
    public String registreUser(@RequestBody Users users) {
        Users user =userRepository.save(users);
        return "hey "+user.getFirstName()+" .....coucou";
    }


    @GetMapping("/users")
        public List<Users> getAllusers(){

        return userRepository.findAll();
    }

    @GetMapping("/users/{email}")
    public List<Users> getByEmail(@PathVariable("email") String email){



        return  userRepository.findUsersByEmail(email);
    }

    @DeleteMapping("/users/{id}")
    public String DeleteById(@PathVariable("id") Long id){


        userRepository.deleteById(id);

        return "Ok";
    }

    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Users> updateVehicle(@PathVariable(value = "id") Long id,
                                                         @RequestBody Users user){
        Optional<Users> userOptional = userRepository.findById(id);

        if (!userOptional.isPresent())
            return ResponseEntity.notFound().build();

        user.setId(id);

        userRepository.save(user);

        return ResponseEntity.noContent().build();
    }
}
