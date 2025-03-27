package finki.mk.emt_lab_1.web;

import finki.mk.emt_lab_1.model.Country;
import finki.mk.emt_lab_1.model.dto.CountryDto;
import finki.mk.emt_lab_1.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {
    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }
    @GetMapping
    public List<Country> findAll(){
        return countryService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Country> findById(@PathVariable Long id){
        return countryService.findById(id)
                .map(c -> ResponseEntity.ok().body(c))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping("/add")
    @Transactional
    public ResponseEntity<Country> save(@RequestBody CountryDto country){
        return countryService.save(country)
                .map(c -> ResponseEntity.ok().body(c))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<Country> update(@PathVariable Long id,@RequestBody Country country){
        return countryService.update(id,country)
                .map(c -> ResponseEntity.ok().body(c))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        if(countryService.findById(id).isPresent()){
            countryService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
