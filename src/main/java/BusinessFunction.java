import lombok.Value;

@Value
public class BusinessFunction {

    // removed the "final" since it is obsolete
    private String businessFunctionName;
    private String type;

    public boolean match(String businessFunctionName, String type) {
        return this.businessFunctionName.equalsIgnoreCase(businessFunctionName) &&
                this.type.equalsIgnoreCase(type);
    }
}