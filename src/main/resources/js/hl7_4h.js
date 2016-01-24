/**
 * Namespace for the HL7-4H library.
 * @type {{}}
 */
var hl7_4h = (
    function () {

        /** sanitize undefined (or otherwise falsey) values to null for the sake of Java callers */
        var un2null = function ( val ) {
            return val ? val : null
        }

        /** parse the segment text, update and return map of segments */
        var parse_segment = function (seg, seg_map ) {
            var seg_flds, seg_code, seg_list

            seg_flds = seg.split( '|' )  // TODO: alternate delim from MSH-1
            seg_code = seg_flds[ 0 ]
            seg_list = seg_map[ seg_code ]
            seg_list = seg_list ?
                seg_list : []
            seg_list.push( seg_flds )
            seg_map[ seg_code ] = seg_list
            return seg_map
        }

        return {

            /** create an accessor object, given a well formed HL7 message text */
            create_message: function ( msg_text ) {
                var segs, seg_map, msg_seg_codes

                segs = msg_text.split( '\r' )
                seg_map = {}
                segs.forEach( function ( seg ) {
                    if ( seg ) {
                        seg_map = parse_segment( seg, seg_map )
                    }  // else: ignore empty string
                })
                msg_seg_codes = Object.getOwnPropertyNames( seg_map )

                return {

                    /** return the HL7 message text "deserialized */
                    to_string: function () { return msg_text },  // TODO: mutable messages

                    /** return the message segment codes */
                    get_segment_codes: function () { return msg_seg_codes },

                    /** return the indicated segment, if it exists */
                    get: function ( seg_code, n1 ) {
                        var seg_list

                        seg_list = seg_map[ seg_code ]
                        return un2null( seg_list ?
                                seg_list[ n1 - 1 ] : null )
                    }

                }
            }

        }
    }
)()


// vi: ts=4 sw=4 expandtab
// *** EOF ***
