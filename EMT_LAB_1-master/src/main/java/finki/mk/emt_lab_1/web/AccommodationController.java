package finki.mk.emt_lab_1.web;

import finki.mk.emt_lab_1.model.Accommodation;
import finki.mk.emt_lab_1.model.dto.AccommodationDTO;
import finki.mk.emt_lab_1.service.AccommodationService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accommodations")
public class AccommodationController {
    private final AccommodationService accommodationService;

    public AccommodationController(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }
    @GetMapping
    public List<Accommodation> findAll(){
        return accommodationService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Accommodation> findById(@PathVariable Long id){
        return accommodationService.findById(id)
                .map(a -> ResponseEntity.ok().body(a))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping("/add")
    public ResponseEntity<Accommodation> save(@RequestBody AccommodationDTO accommodation){
        return accommodationService.save(accommodation)
                .map(a -> ResponseEntity.ok().body(a))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<Accommodation> update(@PathVariable Long id,@RequestBody AccommodationDTO accommodation){
        return accommodationService.update(id,accommodation)
                .map(c -> ResponseEntity.ok().body(c))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        if(accommodationService.findById(id).isPresent()){
            accommodationService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
