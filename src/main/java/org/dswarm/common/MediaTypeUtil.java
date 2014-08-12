package org.dswarm.common;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MediaTypeUtil {
	
	private static final Logger	LOG				= LoggerFactory.getLogger(MediaTypeUtil.class);
	
	// using W3C MIME type standards which partly differ from {@link org.apache.jena.riot.Lang} (see TriG and N3 MIME types in
	// Lang)
	public static final MediaType	TURTLE_TYPE		= new MediaType("text", "turtle");
	public static final String		TURTLE			= "text/turtle";
	public static final MediaType	TRIG_TYPE		= new MediaType("application", "trig");
	public static final String		TRIG			= "application/trig";
	public static final MediaType	N_QUADS_TYPE	= new MediaType("application", "n-quads");
	public static final String		N_QUADS			= "application/n-quads";
	public static final MediaType	RDF_XML_TYPE	= new MediaType("application", "rdf+xml");
	public static final String		RDF_XML			= "application/rdf+xml";
	public static final MediaType	N3_TYPE			= new MediaType("text", "n3");
	public static final String		N3				= "text/n3";
	
	/**
	 * Hint: There is no LD+JSON parser in jena RIOT, maybe use this one if required:
	 * http://mail-archives.apache.org/mod_mbox/jena-dev/201303.mbox/<513248F7.5010803@apache.org>
	 */
	public static final MediaType	JSONLD_TYPE		= new MediaType("application", "ld+json");
	
	// public static final String JSONLD = "ld+json";

	
	
	/**
	 * build a {@link MediaType} from a {@link String}, assuming format consists of a type and a sub type separated by "/", e.g. "application/n-quads"
	 * 
	 * @param format String to build a {@link MediaType} from  
	 * @param defaultType default to be used if {@link MediaType} can not be built from parameter format
	 * @return 
	 */
	public static MediaType getMediaType(final String format, MediaType defaultType) {

		LOG.debug("got format: \"" + format + "\"");

		final String[] formatStrings = format.split("/", 2);
		final MediaType formatType;
		if (formatStrings.length == 2) {
			formatType = new MediaType(formatStrings[0], formatStrings[1]);
		} else {
			formatType = defaultType;
		}
		return formatType;
	}



}
