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

/**
 * Created by tgaengler on 14.03.16.
 */
public enum MediaType {

	TURTLE(MediaTypeUtil.TURTLE_TYPE, MediaTypeUtil.TURTLE, MediaTypeUtil.TURTLE_FILE_EXTENSION),
	TRIG(MediaTypeUtil.TRIG_TYPE, MediaTypeUtil.TRIG, MediaTypeUtil.TRIG_FILE_EXTENSION),
	TRIX(MediaTypeUtil.TRIX_TYPE, MediaTypeUtil.TRIX, MediaTypeUtil.TRIX_FILE_EXTENSION),
	NQUADS(MediaTypeUtil.N_QUADS_TYPE, MediaTypeUtil.N_QUADS, MediaTypeUtil.N_QUADS_FILE_EXTENSION),
	NTRIPLES(MediaTypeUtil.N_TRIPLES_TYPE, MediaTypeUtil.N_TRIPLES, MediaTypeUtil.N_TRIPLES_FILE_EXTENSION),
	RDFXML(MediaTypeUtil.RDF_XML_TYPE, MediaTypeUtil.RDF_XML, MediaTypeUtil.RDF_XML_FILE_EXTENSION),
	RDFTHRIFT(MediaTypeUtil.RDF_THRIFT_TYPE, MediaTypeUtil.RDF_THRIFT, MediaTypeUtil.RDF_THRIFT_FILE_EXTENSION),
	N3(MediaTypeUtil.N3_TYPE, MediaTypeUtil.N3, MediaTypeUtil.N3_FILE_EXTENSION),
	JSONLD(MediaTypeUtil.JSONLD_TYPE, MediaTypeUtil.JSONLD, MediaTypeUtil.JSONLD_FILE_EXTENSION);

	private final javax.ws.rs.core.MediaType mediaType;

	private final String name;

	private final String fileExtension;

	MediaType(final javax.ws.rs.core.MediaType mediaTypeArg,
	          final String mediaTypeName,
	          final String fileExtensionArg) {

		mediaType = mediaTypeArg;
		name = mediaTypeName;
		fileExtension = fileExtensionArg;
	}

	public javax.ws.rs.core.MediaType getMediaType() {

		return mediaType;
	}

	public String getName() {

		return name;
	}

	public String getFileExtension() {

		return fileExtension;
	}

	public static MediaType getMediaTypeByName(final String name) throws DSWARMException {

		if (name == null) {

			throw new DSWARMException("media type name shouldn't be null");
		}

		for (final MediaType resourceType : MediaType.values()) {

			if (resourceType.getName().equals(name)) {

				return resourceType;
			}
		}

		final String message = String.format("couldn't determine media type for resource name = %s", name);

		throw new DSWARMException(message);
	}
}
