package finki.mk.emt_lab_1.service;

import finki.mk.emt_lab_1.model.Accommodation;
import finki.mk.emt_lab_1.model.Country;
import finki.mk.emt_lab_1.model.dto.AccommodationDTO;

import java.util.List;
import java.util.Optional;

public interface AccommodationService {
    List<Accommodation> findAll();
    Optional<Accommodation> findById(Long id);
    Optional<Accommodation> save(AccommodationDTO accommodation);
    Optional<Accommodation> update(Long id,AccommodationDTO accommodation);
    void deleteById(Long id);
}
