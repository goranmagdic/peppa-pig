package genedata.molecule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("api/v1/")
public class MoleculeController {

    @Autowired
    private MoleculeRepository moleculeRepository;

    @RequestMapping(path = "molecules", method = GET)
    public Iterable<Molecule> get() {
        return moleculeRepository.findAll();
    }



    @RequestMapping(path = "molecules/{id}", method = GET)
    public Molecule get(
            @PathVariable Long id
    ) {
        Molecule one = moleculeRepository.findOne(id);
        if(one == null){
            throw new EntityNotFoundException("Molecule with id " + id + " was not found.");
        }
        return one;
    }

    @RequestMapping(path = "molecules", method = POST)
    public Molecule add(@RequestBody Molecule molecule) {
        return moleculeRepository.save(molecule);
    }

    @RequestMapping(path = "molecules/{id}", method = PUT)
    public Molecule update(
            @PathVariable Long id,
            @RequestBody Molecule molecule
    ) {
        Molecule one = moleculeRepository.findOne(id);
        one.update(molecule);
        return one;
    }

    @RequestMapping(path = "molecules/{id}", method = DELETE)
    public void delete(
            @PathVariable Long id
    ) {
        moleculeRepository.delete(id);
    }


}
