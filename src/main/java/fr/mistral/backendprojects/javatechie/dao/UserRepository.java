package fr.mistral.backendprojects.javatechie.dao;


import fr.mistral.backendprojects.javatechie.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {

    List<Users> findUsersByEmail(String email);
}
