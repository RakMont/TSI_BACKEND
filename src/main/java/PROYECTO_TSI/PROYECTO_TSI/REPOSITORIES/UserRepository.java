package PROYECTO_TSI.PROYECTO_TSI.REPOSITORIES;
import java.util.Optional;

import PROYECTO_TSI.PROYECTO_TSI.MODELS.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
