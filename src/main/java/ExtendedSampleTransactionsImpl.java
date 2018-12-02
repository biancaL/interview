import lombok.experimental.Delegate;

public class ExtendedSampleTransactionsImpl implements ExtendedSampleTransactions {


    @Delegate(types=SampleTransactions.class)
    private final SampleTransactions sampleTransactions = new SampleTransactionsImpl();

    @Override
    public void ddd() {
        System.out.println("ddd");
    }
}
