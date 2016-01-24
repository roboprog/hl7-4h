package com.roboprogs.hl7_4h;

import jdk.nashorn.api.scripting.ScriptObjectMirror;

/**
 * Convenience wrapper around HL7 message implementation (in Javascript).
 */
public
class Hl7Msg {

    /** internal (js) representation of message */
    final
    ScriptObjectMirror msg;

    /** init */
    public
    Hl7Msg( String msg ) {
        this.msg = Hl7Utils.createMessage( msg );
    }

    /**
     * Re-serialize the message text.
     * Beware of how \r return characters display on most systems!
     */
    public
    String toString() {
        return (String) this.msg.callMember( "to_string" );
    }

    /** return internal (js) representation of message */
    final public
    ScriptObjectMirror getRawImpl() {
        return this.msg;
    }

}


// vi: ts=4 sw=4 expandtab
// *** EOF ***
