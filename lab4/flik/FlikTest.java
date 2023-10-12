package flik;

import static org.junit.Assert.*;

import org.junit.Test;

public class FlikTest {
    @Test
    public void test1() {
        assertTrue(flik.Flik.isSameNumber(0, 0));
    }

    @Test
    public void test2() {
        assertTrue(flik.Flik.isSameNumber(128, 128));
    }

    @Test
    public void test3() {
        assertTrue(flik.Flik.isSameNumber(-3, -3));
    }
}
