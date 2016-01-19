/**
 * Copyright (C) 2013 – 2016 SLUB Dresden & Avantgarde Labs GmbH (<code@dswarm.org>)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dswarm.common;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MediaTypeUtil {

	private static final Logger		LOG				= LoggerFactory.getLogger(MediaTypeUtil.class);

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


}
