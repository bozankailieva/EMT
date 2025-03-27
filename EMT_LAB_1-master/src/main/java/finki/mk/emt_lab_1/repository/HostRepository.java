package finki.mk.emt_lab_1.repository;

import finki.mk.emt_lab_1.model.Country;
import finki.mk.emt_lab_1.model.Host;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HostRepository extends JpaRepository<Host,Long> {
    List<Host> findByCountryId(Long countryId); // Query to find hosts by country ID

}
