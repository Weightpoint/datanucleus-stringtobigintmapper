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
