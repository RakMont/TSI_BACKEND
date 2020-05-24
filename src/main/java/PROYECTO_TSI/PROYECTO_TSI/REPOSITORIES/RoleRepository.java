package PROYECTO_TSI.PROYECTO_TSI.REPOSITORIES;
import java.util.Optional;

import PROYECTO_TSI.PROYECTO_TSI.MODELS.ERole;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
    Optional<Role> findByName(ERole name);
}
