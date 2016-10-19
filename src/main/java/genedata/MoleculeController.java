package genedata;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class MoleculeController {

    @RequestMapping(path = "molecules")
    public List<String> get() {
        return Arrays.asList("H2O", "CO2", "COOH");
    }
}
