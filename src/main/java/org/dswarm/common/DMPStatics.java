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
/**
 * This file is part of d:swarm graph extension.
 *
 * d:swarm graph extension is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * d:swarm graph extension is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with d:swarm graph extension.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.dswarm.common;

/**
 * Holds references for static fields.
 *
 * @author tgaengler
 */
public interface DMPStatics {

	/**
	 * The delimiter of an attribute path.
	 */
	Character ATTRIBUTE_DELIMITER = '\u001E';

	String RECORD_CLASS_URI_IDENTIFIER = "record_class_uri";

	String RECORD_URI_IDENTIFIER = "record_uri";

	String RECORD_ID_IDENTIFIER = "record_id";

	String LEGACY_RECORD_IDENTIFIER_ATTRIBUTE_PATH = "legacy_record_identifier_attribute_path";

	String KEY_ATTRIBUTE_PATH_IDENTIFIER = "key_attribute_path";

	String SEARCH_VALUE_IDENTIFIER = "search_value";

	String DATA_MODEL_URI_IDENTIFIER = "data_model_uri";

	String RECORDS_IDENTIFIER = "records";

	String CONTENT_SCHEMA_IDENTIFIER = "content_schema";

	String DEPRECATE_MISSING_RECORDS_IDENTIFIER = "deprecate_missing_records";

	String VERSION_IDENTIFIER = "version";

	String ROOT_ATTRIBUTE_PATH_IDENTIFIER = "root_attribute_path";

	String RECORD_TAG_IDENTIFIER = "record_tag";

	String ORIGINAL_DATA_TYPE_IDENTIFIER = "original_data_type";

	String XML_DATA_TYPE = "xml";

	String AT_MOST_IDENTIFIER = "at_most";

	String ENABLE_VERSIONING_IDENTIFIER = "enable_versioning";

	String ALL_VERSIONS_IDENTIFIER = "all_versions";
}
