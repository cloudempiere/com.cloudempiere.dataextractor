package com.cloudempiere.dataextractor.callout;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.adempiere.base.annotation.Callout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MTable;

import com.cloudempiere.dataextractor.model.MDEXTable;

@Callout(tableName = MDEXTable.Table_Name, 
columnName = {MDEXTable.COLUMNNAME_AD_Table_ID})
public class CalloutDEXTable implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		if(mField.getColumnName().equals(MDEXTable.COLUMNNAME_AD_Table_ID))
			return fromTable(ctx, WindowNo, mTab, mField, value, oldValue);
		
		return null;
	}
	
	public String fromTable(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		if(value==null)
			return null;
		
		int p_AD_Table_ID = (int)value;
		
		MTable table = new MTable(ctx, p_AD_Table_ID, null);
		
		mTab.setValue(MDEXTable.COLUMNNAME_TableName, table.getTableName());
		
		return null;
		
	}

}
