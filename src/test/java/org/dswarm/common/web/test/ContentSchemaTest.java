/*
 * Copyright (C) 2013 – 2015 SLUB Dresden & Avantgarde Labs GmbH (<code@dswarm.org>)
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

package org.dswarm.common.web.test;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.Assert;
import org.junit.Test;

import org.dswarm.common.model.Attribute;
import org.dswarm.common.model.AttributePath;
import org.dswarm.common.model.ContentSchema;

/**
 * @author tgaengler
 */
public class ContentSchemaTest {

	private static final ObjectMapper objectMapper = new ObjectMapper();
	public static final String HTTP_WWW_DDB_DE_PROFESSIONELL_MABXML_MABXML_1_XSD_FELD = "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#feld";
	public static final String HTTP_WWW_W3_ORG_1999_02_22_RDF_SYNTAX_NS_VALUE         = "http://www.w3.org/1999/02/22-rdf-syntax-ns#value";
	public static final String HTTP_WWW_DDB_DE_PROFESSIONELL_MABXML_MABXML_1_XSD_ID   = "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#id";
	public static final String HTTP_WWW_DDB_DE_PROFESSIONELL_MABXML_MABXML_1_XSD_NR   = "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#nr";
	public static final String HTTP_WWW_DDB_DE_PROFESSIONELL_MABXML_MABXML_1_XSD_IND = "http://www.ddb.de/professionell/mabxml/mabxml-1.xsd#ind";

	@Test
	public void deserializeContentSchemaTest() throws IOException {

		final URL fileURL = Resources.getResource("contentschema.json");
		final String contentSchemaJSONString = Resources.toString(fileURL, Charsets.UTF_8);

		final ContentSchema contentSchema = objectMapper.readValue(contentSchemaJSONString, ContentSchema.class);

		// record identifier attribute path
		final AttributePath recordIdentifierAttributePath = contentSchema.getRecordIdentifierAttributePath();

		Assert.assertNotNull(recordIdentifierAttributePath);

		final LinkedList<Attribute> attributes = recordIdentifierAttributePath.getAttributes();

		Assert.assertNotNull(attributes);
		Assert.assertEquals(1, attributes.size());

		final Attribute attribute = attributes.get(0);

		Assert.assertNotNull(attribute);

		final String uri = attribute.getUri();

		Assert.assertNotNull(uri);
		Assert.assertEquals(HTTP_WWW_DDB_DE_PROFESSIONELL_MABXML_MABXML_1_XSD_ID, uri);

		// key attribute paths
		final LinkedList<AttributePath> keyAttributePaths = contentSchema.getKeyAttributePaths();

		Assert.assertNotNull(keyAttributePaths);
		Assert.assertEquals(2, keyAttributePaths.size());

		final AttributePath attributePath = keyAttributePaths.get(0);

		Assert.assertNotNull(attributePath);

		final LinkedList<Attribute> attributes1 = attributePath.getAttributes();

		Assert.assertNotNull(attributes1);
		Assert.assertEquals(2, attributes1.size());

		final Attribute attribute3 = attributes1.get(0);

		Assert.assertNotNull(attribute3);

		final String uri3 = attribute3.getUri();

		Assert.assertNotNull(uri3);
		Assert.assertEquals(HTTP_WWW_DDB_DE_PROFESSIONELL_MABXML_MABXML_1_XSD_FELD, uri3);

		final Attribute attribute4 = attributes1.get(1);

		Assert.assertNotNull(attribute4);

		final String uri4 = attribute4.getUri();

		Assert.assertNotNull(uri4);
		Assert.assertEquals(HTTP_WWW_DDB_DE_PROFESSIONELL_MABXML_MABXML_1_XSD_NR, uri4);

		final AttributePath attributePath1 = keyAttributePaths.get(1);

		Assert.assertNotNull(attributePath1);

		final LinkedList<Attribute> attributes2 = attributePath1.getAttributes();

		Assert.assertNotNull(attributes2);
		Assert.assertEquals(2, attributes2.size());

		final Attribute attribute5 = attributes2.get(0);

		Assert.assertNotNull(attribute5);

		final String uri5 = attribute5.getUri();

		Assert.assertNotNull(uri5);
		Assert.assertEquals(HTTP_WWW_DDB_DE_PROFESSIONELL_MABXML_MABXML_1_XSD_FELD, uri5);

		final Attribute attribute6 = attributes2.get(1);

		Assert.assertNotNull(attribute6);

		final String uri6 = attribute6.getUri();

		Assert.assertNotNull(uri6);
		Assert.assertEquals(HTTP_WWW_DDB_DE_PROFESSIONELL_MABXML_MABXML_1_XSD_IND, uri6);

		// value attribute path
		final AttributePath valueAttributePath = contentSchema.getValueAttributePath();

		Assert.assertNotNull(valueAttributePath);

		final LinkedList<Attribute> valueAttributePathAttributes = valueAttributePath.getAttributes();

		Assert.assertNotNull(valueAttributePathAttributes);
		Assert.assertEquals(2, valueAttributePathAttributes.size());

		final Attribute attribute1 = valueAttributePathAttributes.get(0);

		Assert.assertNotNull(attribute1);

		final String uri1 = attribute1.getUri();

		Assert.assertNotNull(uri1);
		Assert.assertEquals(HTTP_WWW_DDB_DE_PROFESSIONELL_MABXML_MABXML_1_XSD_FELD, uri1);

		final Attribute attribute2 = valueAttributePathAttributes.get(1);

		Assert.assertNotNull(attribute2);

		final String uri2 = attribute2.getUri();

		Assert.assertNotNull(uri2);
		Assert.assertEquals(HTTP_WWW_W3_ORG_1999_02_22_RDF_SYNTAX_NS_VALUE, uri2);
	}
}
