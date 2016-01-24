package com.roboprogs.hl7_4h;

import jdk.nashorn.api.scripting.ScriptObjectMirror;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public
class Hl7FactoryTest
        extends TestCase {

    /** a very minimal (partial) message text */
    private static final
    String MIN_MSG_TEXT =
"MSH|^~\r" +
"EVN\r" +
"PID\r" ;

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
        Hl7Msg msg;

        msg = new Hl7Msg( MIN_MSG_TEXT );
        assertNotNull( "Message object should be returned", msg );
    }

    /** Minimal test that the underlying JS implementation object was made/attached */
    public
    void testJsPresent() {
        ScriptObjectMirror jsObj;

        jsObj = ( new Hl7Msg( MIN_MSG_TEXT ) ).getRawImpl();
        assertNotNull( "Message implementation scripting object should be returned",
                jsObj );
    }

}


// vi: ts=4 sw=4 expandtab
// *** EOF ***
