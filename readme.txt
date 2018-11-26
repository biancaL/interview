Given:

@Value
@AllArgsConstructor
public class ContextConfigurationEntry {
    private Optional<BusinessFunction[]> businessFunctions;

    public boolean hasBusinessFunction(String businessFunctionName, String type) {
            ...
    }
}

@Value
public class BusinessFunction {

    private final String businessFunctionName;

    private final String type;

    public boolean match(String businessFunctionName, String type) {
        return businessFunctionName.equalsIgnoreCase(businessFunctionName) && type.equalsIgnoreCase(type);
    }
}

Please implement in java8 way method: hasBusinessFunction()