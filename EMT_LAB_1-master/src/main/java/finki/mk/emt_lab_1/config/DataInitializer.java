package finki.mk.emt_lab_1.config;

import finki.mk.emt_lab_1.model.Accommodation;
import finki.mk.emt_lab_1.model.Country;
import finki.mk.emt_lab_1.model.Host;
import finki.mk.emt_lab_1.model.enums.Category;
import finki.mk.emt_lab_1.repository.AccommodationRepository;
import finki.mk.emt_lab_1.repository.CountryRepository;
import finki.mk.emt_lab_1.repository.HostRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final CountryRepository countryRepository;
    private final HostRepository hostRepository;
    private final AccommodationRepository accommodationRepository;

    public DataInitializer(CountryRepository countryRepository, HostRepository hostRepository, AccommodationRepository accommodationRepository) {
        this.countryRepository = countryRepository;
        this.hostRepository = hostRepository;
        this.accommodationRepository = accommodationRepository;
    }

    @PostConstruct
    public void init() {
        // Create and save countries
        Country france = new Country("France", "Europe");
        Country germany = new Country("Germany", "Europe");
        Country greece = new Country("Greece", "Europe");

        countryRepository.save(france);
        countryRepository.save(germany);
        countryRepository.save(greece);

        // Create and save hosts
        Host host1 = new Host("Pierre", "Dupont", france);
        Host host2 = new Host("Hans", "Müller", germany);
        Host host3 = new Host("Nikos", "Papadopoulos", greece);

        hostRepository.save(host1);
        hostRepository.save(host2);
        hostRepository.save(host3);

        // Create and save accommodations
        accommodationRepository.save(new Accommodation("Eiffel Loft", Category.ROOM, host1, 7));
        accommodationRepository.save(new Accommodation("Berlin Motel", Category.MOTEL, host2, 4));
        accommodationRepository.save(new Accommodation("Santorini Suites", Category.HOTEL, host3, 12));
        accommodationRepository.save(new Accommodation("Alpine Cabin", Category.ROOM, host2, 2));
        accommodationRepository.save(new Accommodation("Athens Apartment", Category.HOTEL, host1, 8));
    }
}
