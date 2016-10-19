package genedata.molecule;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Molecule {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String formula;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFormula() {
        return formula;
    }

    void update(Molecule molecule) {
        this.formula = molecule.getFormula();
    }
}
