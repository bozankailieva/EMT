package finki.mk.emt_lab_1.service;

import finki.mk.emt_lab_1.model.Accommodation;
import finki.mk.emt_lab_1.model.Country;
import finki.mk.emt_lab_1.model.dto.CountryDto;
import finki.mk.emt_lab_1.repository.CountryRepository;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();
    Optional<Country> findById(Long id);
    Optional<Country> save(CountryDto country);
    Optional<Country> update(Long id, Country country);
    void deleteById(Long id);
}
