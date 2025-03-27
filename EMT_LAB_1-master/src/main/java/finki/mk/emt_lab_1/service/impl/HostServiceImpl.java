package finki.mk.emt_lab_1.service.impl;

import finki.mk.emt_lab_1.model.Host;
import finki.mk.emt_lab_1.model.dto.HostDTO;
import finki.mk.emt_lab_1.repository.HostRepository;
import finki.mk.emt_lab_1.service.CountryService;
import finki.mk.emt_lab_1.service.HostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostServiceImpl implements HostService {
    private final HostRepository hostRepository;
    private final CountryService countryService;

    public HostServiceImpl(HostRepository hostRepository, CountryService countryService) {
        this.hostRepository = hostRepository;
        this.countryService = countryService;
    }


    @Override
    public List<Host> findAll() {
        return hostRepository.findAll();
    }

    @Override
    public Optional<Host> findById(Long id) {
        return hostRepository.findById(id);
    }

    @Override
    public Optional<Host> save(HostDTO host) {
        if(host.getCountry() != null && countryService.findById(host.getCountry()).isPresent()){
            return Optional.of(hostRepository.save(new Host(host.getName(),host.getSurname(),
                    countryService.findById(host.getCountry()).get())));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Host> update(Long id, HostDTO host) {
        return hostRepository.findById(id)
                .map(existingHost -> {
                    if(host.getName() != null){
                        existingHost.setName(host.getName());
                    }
                    if(host.getSurname() != null){
                        existingHost.setSurname(host.getSurname());
                    }
                    if(host.getCountry() != null && countryService.findById(host.getCountry()).isPresent())
                    {
                        existingHost.setCountry(countryService.findById(host.getCountry()).get());
                    }
                    return hostRepository.save(existingHost);
                });
    }

    @Override
    public void deleteById(Long id) {
        hostRepository.deleteById(id);
    }
}
