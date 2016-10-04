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

	private static final Logger LOG = LoggerFactory.getLogger(MediaTypeUtil.class);

	// using W3C MIME type standards which partly differ from {@link org.apache.jena.riot.Lang} (see TriG and N3 MIME types in
	// Lang)
	public static final MediaType TURTLE_TYPE = new MediaType("text", "turtle");
	public static final String TURTLE = "text/turtle";
	public static final String TURTLE_FILE_EXTENSION = "ttl";
	public static final MediaType TRIG_TYPE = new MediaType("application", "trig");
	public static final String TRIG = "application/trig";
	public static final String TRIG_FILE_EXTENSION = "trig";
	public static final MediaType TRIX_TYPE = new MediaType("application", "trix");
	public static final String TRIX = "application/trix";
	public static final String TRIX_FILE_EXTENSION = "trix";
	public static final MediaType N_QUADS_TYPE = new MediaType("application", "n-quads");
	public static final String N_QUADS = "application/n-quads";
	public static final String N_QUADS_FILE_EXTENSION = "nq";
	public static final MediaType N_TRIPLES_TYPE = new MediaType("application", "n-triples");
	public static final String N_TRIPLES = "application/n-triples";
	public static final String N_TRIPLES_FILE_EXTENSION = "nt";
	public static final MediaType RDF_XML_TYPE = new MediaType("application", "rdf+xml");
	public static final String RDF_XML = "application/rdf+xml";
	public static final String RDF_XML_FILE_EXTENSION = "rdf";
	public static final MediaType RDF_THRIFT_TYPE = new MediaType("application", "rdf+thrift");
	public static final String RDF_THRIFT = "application/rdf+thrift";
	public static final String RDF_THRIFT_FILE_EXTENSION = "rt";
	public static final MediaType N3_TYPE = new MediaType("text", "n3");
	public static final String N3 = "text/n3";
	public static final String N3_FILE_EXTENSION = "n3";
	public static final MediaType SOLR_UPDATE_XML_TYPE = new MediaType("application", "solr+update+xml");
	public static final String SOLR_UPDATE_XML = "application/solr+update+xml";
	public static final String SOLR_UPDATE_XML_FILE_EXTENSION = "xml";
	public static final MediaType GDM_JSON_TYPE = new MediaType("application", "gdm+json");
	public static final String GDM_JSON = "application/gdm+json";
	public static final String GDM_JSON_FILE_EXTENSION = "json";
	public static final MediaType GDM_COMPACT_JSON_TYPE = new MediaType("application", "gdm+compact+json");
	public static final String GDM_COMPACT_JSON = "application/gdm+compact+json";
	public static final String GDM_COMPACT_JSON_FILE_EXTENSION = "json";
	public static final MediaType GDM_COMPACT_FE_JSON_TYPE = new MediaType("application", "gdm+compact+fe+json");
	public static final String GDM_COMPACT_FE_JSON = "application/gdm+compact+fe+json";
	public static final String GDM_COMPACT_FE_JSON_FILE_EXTENSION = "json";
	public static final MediaType GDM_SIMPLE_JSON_TYPE = new MediaType("application", "gdm+simple+json");
	public static final String GDM_SIMPLE_JSON = "application/gdm+simple+json";
	public static final String GDM_SIMPLE_JSON_FILE_EXTENSION = "json";
	public static final MediaType GDM_SIMPLE_SHORT_JSON_TYPE = new MediaType("application", "gdm+simple+short+json");
	public static final String GDM_SIMPLE_SHORT_JSON = "application/gdm+simple+short+json";
	public static final String GDM_SIMPLE_SHORT_JSON_FILE_EXTENSION = "json";

	/**
	 * Hint: There is no LD+JSON parser in jena RIOT, maybe use this one if required:
	 * http://mail-archives.apache.org/mod_mbox/jena-dev/201303.mbox/<513248F7.5010803@apache.org>
	 */
	public static final MediaType JSONLD_TYPE = new MediaType("application", "ld+json");
	public static final String JSONLD = "application/ld+json";
	public static final String JSONLD_FILE_EXTENSION = "jsonld";
}
