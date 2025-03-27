package finki.mk.emt_lab_1.service.impl;

import finki.mk.emt_lab_1.model.Accommodation;
import finki.mk.emt_lab_1.model.Host;
import finki.mk.emt_lab_1.model.dto.AccommodationDTO;
import finki.mk.emt_lab_1.repository.AccommodationRepository;
import finki.mk.emt_lab_1.service.AccommodationService;
import finki.mk.emt_lab_1.service.HostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccommodationServiceImpl implements AccommodationService {
    private final AccommodationRepository accommodationRepository;
    private final HostService hostService;

    public AccommodationServiceImpl(AccommodationRepository accommodationRepository, HostService hostService) {
        this.accommodationRepository = accommodationRepository;
        this.hostService = hostService;
    }

    @Override
    public List<Accommodation> findAll() {
        return accommodationRepository.findAll();
    }

    @Override
    public Optional<Accommodation> findById(Long id) {
        return accommodationRepository.findById(id);
    }

    @Override
    public Optional<Accommodation> save(AccommodationDTO accommodation) {
      if(accommodation.getHost() != null && hostService.findById(accommodation.getHost()).isPresent()
      && accommodation.getName() != null && accommodation.getCategory() != null && accommodation.getNumRooms() != null) {
          return Optional.of(accommodationRepository.save(new Accommodation(
                  accommodation.getName(),accommodation.getCategory(),hostService.findById(accommodation.getHost()).get(),accommodation.getNumRooms(),accommodation.isRented())));
      }
      return Optional.empty();
    }

    @Override
    public Optional<Accommodation> update(Long id, AccommodationDTO accommodation) {
        return accommodationRepository.findById(id)
                .map(existingAccommodation -> {
                    if(accommodation.getName() != null){
                        existingAccommodation.setName(accommodation.getName());
                    }
                    if(accommodation.getCategory() != null){
                        existingAccommodation.setCategory(accommodation.getCategory());
                    }
                    if(accommodation.getNumRooms() != null){
                        existingAccommodation.setNumRooms(accommodation.getNumRooms());
                    }
                    if(accommodation.getHost() != null && hostService.findById(accommodation.getHost()).isPresent()){
                        existingAccommodation.setHost(hostService.findById(accommodation.getHost()).get());
                    }
                    existingAccommodation.setRented(accommodation.isRented());

                    return accommodationRepository.save(existingAccommodation);
                });
    }


    @Override
    public void deleteById(Long id) {
        accommodationRepository.deleteById(id);
    }
}
