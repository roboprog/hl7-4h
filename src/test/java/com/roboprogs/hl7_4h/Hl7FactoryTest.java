package com.roboprogs.hl7_4h;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public
class Hl7FactoryTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public
    Hl7FactoryTest( String testName ) {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static
    Test suite() {
        return new TestSuite( Hl7FactoryTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public
    void testApp() {
        assertTrue( true );
    }

}
