package dev.java10x.ninjaregistration.Ninjas;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome to Ninja Registration";
    }

    // Add Ninja (CREATE)
    @PostMapping("/create")
    public ResponseEntity<String> createNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO newNinja = ninjaService.createNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja created successfully: " + newNinja.getName() + " (ID): " + newNinja.getId());
    }

    // Show All Ninjas (READ)
    @GetMapping("/list")
    public ResponseEntity<List<NinjaDTO>> showAllNinjas() {
        List<NinjaDTO> ninjas = ninjaService.showAllNinjas();
        return ResponseEntity.ok(ninjas);
    }

    // Show Ninjas by ID (READ)
    @GetMapping("/list/{id}")
    public ResponseEntity<?> showAllNinjasByID(@PathVariable Long id) {
        NinjaDTO ninja = ninjaService.showAllNinjasByID(id);
        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja with ID " + id + " not found");
        }
    }

    // Alter Ninja data (UPDATE)
    @PutMapping("/alter/{id}")
    public ResponseEntity<?> alterNinjaByID(@PathVariable Long id, @RequestBody NinjaDTO ninjaAltered) {
        NinjaDTO ninja = ninjaService.alterNinjaByID(id, ninjaAltered);
        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja with ID " + id + " not found");
        }

    }

    // Delete Ninja (DELETE)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteNinjaByID(@PathVariable Long id) {
        if (ninjaService.showAllNinjasByID(id) != null) {
            ninjaService.deleteNinjaByID(id);
            return ResponseEntity.ok("Ninja with ID " + id + " deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja with ID " + id + " not found");
        }
    }


}
