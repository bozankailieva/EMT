package finki.mk.emt_lab_1.service.impl;

import finki.mk.emt_lab_1.model.Country;
import finki.mk.emt_lab_1.model.Host;
import finki.mk.emt_lab_1.model.dto.CountryDto;
import finki.mk.emt_lab_1.repository.CountryRepository;
import finki.mk.emt_lab_1.repository.HostRepository;
import finki.mk.emt_lab_1.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;
    private final HostRepository hostRepository;

    public CountryServiceImpl(CountryRepository countryRepository, HostRepository hostRepository) {
        this.countryRepository = countryRepository;
        this.hostRepository = hostRepository;
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public Optional<Country> save(CountryDto country) {
        if(country.getContinent() != null && country.getName() != null ){
            return Optional.of(countryRepository.save(new Country(country.getName(),country.getContinent())));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Country> update(Long id, Country countryDto) {
        return countryRepository.findById(id)
                .map(existingCountry -> {
                    if(countryDto.getName() != null){
                        existingCountry.setName(countryDto.getName());
                    }
                    if(countryDto.getContinent() != null){
                        existingCountry.setContinent(countryDto.getContinent());
                    }
                    return countryRepository.save(existingCountry);
                });
    }


    @Override
    public void deleteById(Long id) {
        List<Host> hosts = hostRepository.findByCountryId(id);

        for (Host host : hosts) {
            host.setCountry(null);
            hostRepository.save(host);
        }
        countryRepository.deleteById(id);
    }

}
