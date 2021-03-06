package psidev.psi.pi.validator.objectrules;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import psidev.psi.tools.ontology_manager.OntologyManager;
import psidev.psi.tools.validator.Context;
import psidev.psi.tools.validator.MessageLevel;
import psidev.psi.tools.validator.ValidatorException;
import psidev.psi.tools.validator.ValidatorMessage;
import uk.ac.ebi.jmzidml.MzIdentMLElement;
import uk.ac.ebi.jmzidml.model.mzidml.SpectrumIdentificationItem;

/**
 * Checks: if there is a calculatedMassToCharge in the
 * SpectrumIdentificationItem.
 * 
 * @author Salva
 * 
 */
public class SpectrumIdentificationItemObjectRule extends AObjectRule<SpectrumIdentificationItem> {

    /**
     * Constants.
     */
    private static final Context SII_CONTEXT = new Context(MzIdentMLElement.SpectrumIdentificationItem.getXpath());

    /**
     * Constructor.
     */
    public SpectrumIdentificationItemObjectRule() {
        this(null);
    }

    /**
     * Constructor.
     * @param ontologyManager the ontology manager
     */
    public SpectrumIdentificationItemObjectRule(OntologyManager ontologyManager) {
        super(ontologyManager);
    }

    /**
     * Checks, if the object is a SpectrumIdentificationItem.
     * 
     * @param obj   the object to check
     * @return true, if obj is an SpectrumIdentificationItem
     */
    @Override
    public boolean canCheck(Object obj) {
        return (obj instanceof SpectrumIdentificationItem);
    }

    /**
     * 
     * @param spectrumIdentificationItem the SpectrumIdentificationItem element
     * @return collection of messages
     * @throws ValidatorException validator exception
     */
    @Override
    public Collection<ValidatorMessage> check(SpectrumIdentificationItem spectrumIdentificationItem) throws ValidatorException {
        List<ValidatorMessage> messages = new ArrayList<>();

        if (spectrumIdentificationItem.getCalculatedMassToCharge() == null) {
            messages.add(new ValidatorMessage(
                "There is not a definition of the calculatedMassToCharge in SpectrumIdentificationItem (id='"
                + spectrumIdentificationItem.getId()
                + "') element at "
                + SpectrumIdentificationItemObjectRule.SII_CONTEXT.getContext(), MessageLevel.INFO, SII_CONTEXT, this));
        }

        return messages;
    }

    /**
     * Gets the tips how to fix the error.
     * 
     * @return  collection of tips
     */
    @Override
    public Collection<String> getHowToFixTips() {
        List<String> ret = new ArrayList<>();

        ret.add("Add the attribute 'calculatedMassToCharge' to the SpectrumIdentificationItem at " + SpectrumIdentificationItemObjectRule.SII_CONTEXT.getContext());
        
        return ret;
    }
}
