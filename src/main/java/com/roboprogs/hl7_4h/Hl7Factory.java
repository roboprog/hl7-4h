package com.roboprogs.hl7_4h;

/**
 * Java wrapper around HL7-4H Javascript library.
 */
public
class Hl7Factory {

    public static
    void main( String[] args ) {
        System.out.println( "Hello World!" );
    }

    /** create an HL7 message accessor from the given message text */
    public static
    Hl7Msg createMessage( String msgText ) {
        return new Hl7Msg();  // TODO - actual parsing
    }

}


// vi: ts=4 sw=4 expandtab
// *** EOF ***
