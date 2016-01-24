/**
 * Namespace for the HL7-4H library.
 * @type {{}}
 */
var hl7_4h = (
    function () {
        return {

            /** create an accessor object, given a well formed HL7 message text */
            create_message: function ( msg_text ) {

                return {

                    /** return the HL7 message text "deserialized */
                    to_string: function () { return msg_text }  // TODO: mutable messages
                }
            }

        }
    }
)()


// vi: ts=4 sw=4 expandtab
// *** EOF ***
