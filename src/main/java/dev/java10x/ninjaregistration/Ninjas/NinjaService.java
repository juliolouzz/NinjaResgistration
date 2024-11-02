package dev.java10x.ninjaregistration.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {


    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    // List all ninjas
    public List<NinjaModel> showAllNinjas() {
        return ninjaRepository.findAll();
    }

    // List all ninjas by ID
    public NinjaModel showAllNinjasByID(Long id) {
        Optional<NinjaModel> ninjaById = ninjaRepository.findById(id);
        return ninjaById.orElse(null);
    }

    // Create a new Ninja
    public NinjaModel createNinja(NinjaModel ninja) {
        return ninjaRepository.save(ninja);
    }


    // Delete a Ninja - need to be void method
    public void deleteNinjaByID(Long id) {
        ninjaRepository.deleteById(id);
    }

    // Alter/Update Ninja data
    public NinjaModel alterNinjaByID(Long id, NinjaModel ninjaAltered) {
        if (ninjaRepository.existsById(id)) {
            ninjaAltered.setId(id);
            return ninjaRepository.save(ninjaAltered);
        }
        return null;
    }


}
