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

    /** Minimal test of parsing a partial message. */
    public
    void testMin() {
        final String MIN_MSG_TEXT =
"MSH|^~\r" +
"EVN\r" +
"PID\r" ;

        Hl7Msg msg;

        msg = Hl7Factory.createMessage( MIN_MSG_TEXT );
        assertNotNull( "Message object should be returned", msg );
    }

}


// vi: ts=4 sw=4 expandtab
// *** EOF ***
