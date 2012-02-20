/*
 * Copyright 2012 Weightpoint AB
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package se.weightpoint.datanucleus.mapped.mapping;

import org.datanucleus.store.mapped.DatastoreField;
import org.datanucleus.store.mapped.MappedStoreManager;
import org.datanucleus.store.mapped.mapping.JavaTypeMapping;
import org.datanucleus.store.rdbms.mapping.BigIntRDBMSMapping;

public class StringToBigIntRDBMSMaping extends BigIntRDBMSMapping {

	public StringToBigIntRDBMSMaping(JavaTypeMapping mapping,
			MappedStoreManager storeMgr, DatastoreField field) {
		super(mapping, storeMgr, field);
	}

	public StringToBigIntRDBMSMaping(MappedStoreManager storeMgr,
			JavaTypeMapping mapping) {
		super(storeMgr, mapping);
	}

	@Override
	public void setString(Object preparedStatement, int exprIndex, String value) {
		super.setLong(preparedStatement, exprIndex, Long.parseLong(value));
	}

	@Override
	public String getString(Object resultSet, int exprIndex) {
		return Long.toString(super.getLong(resultSet, exprIndex));
	}
	
}
