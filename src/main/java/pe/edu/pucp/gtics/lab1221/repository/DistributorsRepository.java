package pe.edu.pucp.gtics.lab1221.repository;
import pe.edu.pucp.gtics.lab1221.entity.Distributors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistributorsRepository extends JpaRepository<Distributors, Integer> {
}
