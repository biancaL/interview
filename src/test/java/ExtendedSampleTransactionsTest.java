import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ExtendedSampleTransactionsTest {

    @Test
    public void shouldPrintAaa() {
        ExtendedSampleTransactions extended = new ExtendedSampleTransactionsImpl();

        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        extended.aaa();

        verify(out).println("aaa");
    }
}
