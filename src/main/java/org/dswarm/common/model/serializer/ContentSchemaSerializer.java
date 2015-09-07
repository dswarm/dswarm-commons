/**
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
package org.dswarm.common.model.serializer;

import java.io.IOException;
import java.util.LinkedList;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import org.dswarm.common.model.AttributePath;
import org.dswarm.common.model.ContentSchema;
import org.dswarm.common.model.util.ContentSchemaUtil;

/**
 * @author tgaengler
 */
public class ContentSchemaSerializer extends JsonSerializer<ContentSchema> {

	@Override
	public void serialize(final ContentSchema contentSchema, final JsonGenerator jsonGenerator, final SerializerProvider serializerProvider)
			throws IOException {

		if(contentSchema == null) {

			return;
		}

		jsonGenerator.writeStartObject();

		final AttributePath recordIdentifierAttributePath = contentSchema.getRecordIdentifierAttributePath();

		if(recordIdentifierAttributePath != null) {

			jsonGenerator.writeFieldName(ContentSchemaUtil.RECORD_IDENTIFIER_ATTRIBUTE_PATH);
			jsonGenerator.writeString(recordIdentifierAttributePath.toString());
		}

		final LinkedList<AttributePath> keyAttributePaths = contentSchema.getKeyAttributePaths();

		if(keyAttributePaths != null) {

			jsonGenerator.writeFieldName(ContentSchemaUtil.KEY_ATTRIBUTE_PATHS);
			jsonGenerator.writeStartArray();

			for(final AttributePath kexAttributePath : keyAttributePaths) {

				jsonGenerator.writeString(kexAttributePath.toString());
			}

			jsonGenerator.writeEndArray();
		}

		final AttributePath valueAttributePath = contentSchema.getValueAttributePath();

		if(valueAttributePath != null) {

			jsonGenerator.writeFieldName(ContentSchemaUtil.VALUE_ATTRIBUTE_PATH);
			jsonGenerator.writeString(valueAttributePath.toString());
		}

		jsonGenerator.writeEndObject();
	}
}
