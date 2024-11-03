package dev.java10x.ninjaregistration.Ninjas;

import lombok.Data;
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
    public NinjaDTO createNinja(@RequestBody NinjaDTO ninja) {
        return ninjaService.createNinja(ninja);
    }

    // Show All Ninjas (READ)
    @GetMapping("/list")
    public List<NinjaDTO> showAllNinjas() {
        return ninjaService.showAllNinjas();
    }

    // Show Ninjas by ID (READ)
    @GetMapping("/list/{id}")
    public NinjaDTO showAllNinjasByID(@PathVariable Long id) {
        return ninjaService.showAllNinjasByID(id);
    }

    // Alter Ninja data (UPDATE)
    @PutMapping("/alter/{id}")
    public NinjaDTO alterNinjaByID(@PathVariable Long id, @RequestBody NinjaDTO ninjaAltered) {
        return ninjaService.alterNinjaByID(id, ninjaAltered);
    }

    // Delete Ninja (DELETE)
    @DeleteMapping("/delete/{id}")
    public void deleteNinjaByID(@PathVariable Long id) {
        ninjaService.deleteNinjaByID(id);
    }


}
