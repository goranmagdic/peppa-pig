package genedata.molecule.formula;

import genedata.molecule.Molecule;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class FormulaController {

    @RequestMapping(path = "api/v1/molecules/{id}/formula", method = GET)
    public Iterable<Molecule> getFormula() {
        throw new SecurityException("You are not authorized to see formula");
    }
}
