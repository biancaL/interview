import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.Arrays;
import java.util.Optional;

@Value
@AllArgsConstructor
public class ContextConfigurationEntry {
    private Optional<BusinessFunction[]> businessFunctions;

    public boolean hasBusinessFunction(String businessFunctionName, String type) {
       return businessFunctions.isPresent() &&
               Arrays.stream(businessFunctions.get()).anyMatch(e -> e.match(businessFunctionName, type));
    }
}