import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.gridnine.testing.*;

import java.util.ArrayList;

public class FlightFilterTest {
    ArrayList newFlights;
    @Before
    public void createNewFlights(){
        newFlights = new ArrayList<>(Main.flights);
    }
    @Test
    public void departureDateBeforeNowShouldWork (){
        newFlights.remove(2);
        Assert.assertEquals(newFlights,FlightFilter.departureDateBeforeNow(Main.flights));
    }
    @Test
    public void arrivalBeforeDepartureShouldWork (){
        newFlights.remove(3);
        Assert.assertEquals(newFlights,FlightFilter.arrivalBeforeDeparture(Main.flights));
    }
    @Test
    public void bigBreakShouldWork (){
        newFlights.remove(4);
        newFlights.remove(4);
        Assert.assertEquals(newFlights,FlightFilter.bigBreak(Main.flights));
    }
}
