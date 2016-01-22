package com.roboprogs.hl7_4h;

import java.io.*;

import javax.script.ScriptEngineManager;

import jdk.nashorn.api.scripting.NashornScriptEngine;

/**
 * Java wrapper around HL7-4H Javascript library.
 */
public
class Hl7Factory {

    /** JS interpreter, loaded with any needed scripting */
    private static
    NashornScriptEngine engine = initEngine();

    /** init JS interpreter, loaded with any needed scripting */
    private static
    NashornScriptEngine initEngine() {
        NashornScriptEngine engine;

        try {
            engine = (NashornScriptEngine) ( new ScriptEngineManager() ) .
                    getEngineByName( "nashorn" );
            loadScript( engine, "/js/hl7_4h.js" );
            return engine;
        } catch ( Throwable e ) {
            throw new RuntimeException(
                    "Failed to initialize Javascript engine: " + e, e );
        }
    }

    /** Run (load) the indicated Javascript (resource) */
    private static
    void loadScript(
            NashornScriptEngine engine,
            String fname )
            throws Exception {
        Reader in;

        in = new BufferedReader( new InputStreamReader(
                Hl7Factory.class.getResourceAsStream( fname ) ) );
        try {
            engine.eval( in );
        } finally {
            in.close();
        }
    }

    /** create an HL7 message accessor from the given message text */
    public static
    Hl7Msg createMessage( String msgText ) {
        return new Hl7Msg();  // TODO - actual parsing
    }

}


// vi: ts=4 sw=4 expandtab
// *** EOF ***
