package com.roboprogs.hl7_4h;

import jdk.nashorn.api.scripting.ScriptObjectMirror;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test HL7 Messages library.
 */
public
class Hl7MsgTest
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
    public Hl7MsgTest( String testName ) {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static
    Test suite() {
        return new TestSuite( Hl7MsgTest.class );
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

    /** verify that an unmodified message retains its content */
    public
    void testMsgIdentity() {
        Hl7Msg msg;

        msg = new Hl7Msg( MIN_MSG_TEXT );
        // note that use of \r return chars cause overwrites on console
        assertEquals( "Original message text should be returned",
                MIN_MSG_TEXT, msg.toString() );
    }

}


// vi: ts=4 sw=4 expandtab
// *** EOF ***
