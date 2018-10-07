package be.kdg.foundation.contact;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DistanceCalculatorTest {

    @Test
    public void getDistance() {
        Position paris = new Position(48.853858, 2.347560);
        Position brussels = new Position(50.845298, 4.350642);
        assertEquals(260, DistanceCalculator.getDistance(paris, brussels), 5);
    }
}