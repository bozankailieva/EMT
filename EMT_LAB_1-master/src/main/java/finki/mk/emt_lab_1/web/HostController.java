package finki.mk.emt_lab_1.web;

import finki.mk.emt_lab_1.model.Accommodation;
import finki.mk.emt_lab_1.model.Country;
import finki.mk.emt_lab_1.model.Host;
import finki.mk.emt_lab_1.model.dto.AccommodationDTO;
import finki.mk.emt_lab_1.model.dto.HostDTO;
import finki.mk.emt_lab_1.service.HostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hosts")
public class HostController {
    private final HostService hostService;

    public HostController(HostService hostService) {
        this.hostService = hostService;
    }
    @GetMapping
    public List<Host> findAll(){
        return hostService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Host> findById(@PathVariable Long id){
        return hostService.findById(id)
                .map(c -> ResponseEntity.ok().body(c))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping("/add")
    public ResponseEntity<Host> save(@RequestBody HostDTO host){
        return hostService.save(host)
                .map(a -> ResponseEntity.ok().body(a))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<Host> update(@PathVariable Long id,@RequestBody HostDTO host){
        return hostService.update(id,host)
                .map(c -> ResponseEntity.ok().body(c))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        if(hostService.findById(id).isPresent()){
            hostService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
