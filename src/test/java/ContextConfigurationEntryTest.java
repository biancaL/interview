import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class ContextConfigurationEntryTest {

    @Test
    public void shouldReturnFalseForEmptyBusinessFunctions() {
        Optional<BusinessFunction[]> businessFunctions = Optional.empty();
        ContextConfigurationEntry entry = new ContextConfigurationEntry(businessFunctions);
        boolean result = entry.hasBusinessFunction("name", "type");

        assertFalse(result);

    }

    @Test
    public void shouldReturnFalseForOtherBusinessFunction() {
        BusinessFunction[] businessFunctions = buildBusinessFunctions("businessFunctionName", "type");

        ContextConfigurationEntry entry = new ContextConfigurationEntry(Optional.of(businessFunctions));

        boolean result = entry.hasBusinessFunction("otherName", "otherType");

        assertFalse(result);

    }

    @Test
    public void shouldReturnTrueForMatchingBusinessFunction() {
        BusinessFunction[] businessFunctions = buildBusinessFunctions("name", "businessType");

        ContextConfigurationEntry entry = new ContextConfigurationEntry(Optional.of(businessFunctions));

        boolean result = entry.hasBusinessFunction("name", "businessType");

        assertTrue(result);

    }

    @Test
    public void shouldReturnTrueForMatchingBusinessFunctionWithCapitalLetters() {
        BusinessFunction[] businessFunctions = buildBusinessFunctions("name", "type");

        ContextConfigurationEntry entry = new ContextConfigurationEntry(Optional.of(businessFunctions));

        boolean result = entry.hasBusinessFunction("Name", "Type");

        assertTrue(result);
    }

    private BusinessFunction[] buildBusinessFunctions(String name, String type) {
        BusinessFunction businessFunction = new BusinessFunction(name, type);
        BusinessFunction[] businessFunctions = new BusinessFunction[1];
        businessFunctions[0] = businessFunction;
        return businessFunctions;
    }
}
