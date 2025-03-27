package finki.mk.emt_lab_1.repository;

import finki.mk.emt_lab_1.model.Accommodation;
import finki.mk.emt_lab_1.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import finki.mk.emt_lab_1.model.Accommodation;

public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {
}
