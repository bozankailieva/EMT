package finki.mk.emt_lab_1.service;

import finki.mk.emt_lab_1.model.Country;
import finki.mk.emt_lab_1.model.Host;
import finki.mk.emt_lab_1.model.dto.HostDTO;

import java.util.List;
import java.util.Optional;

public interface HostService {
    List<Host> findAll();
    Optional<Host> findById(Long id);
    Optional<Host> save(HostDTO host);
    Optional<Host> update(Long id, HostDTO host);
    void deleteById(Long id);
}
