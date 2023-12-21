package com.cloudempiere.dataextractor.callout;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.adempiere.base.annotation.Callout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MColumn;
import org.compiere.util.DisplayType;

import com.cloudempiere.dataextractor.model.MDEXColumn;

@Callout(tableName = MDEXColumn.Table_Name, 
columnName = {MDEXColumn.COLUMNNAME_AD_Column_ID})
public class CalloutDEXColumn implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		if(mField.getColumnName().equals(MDEXColumn.COLUMNNAME_AD_Column_ID)) {
			fromColumn(ctx, WindowNo, mTab, mField, value, oldValue);
		}
		
		return null;
	}
	
	public String fromColumn(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		if(value==null)
			return null;
		
		int p_AD_Column_ID = (int)value;
		
		MColumn column = new MColumn(ctx, p_AD_Column_ID, null);
		
		mTab.setValue(MDEXColumn.COLUMNNAME_ColumnName, column.getColumnName());
		if(DisplayType.isID(column.getAD_Reference_ID()))
			mTab.setValue(MDEXColumn.COLUMNNAME_DataType, MDEXColumn.DATATYPE_Number);
		else if(DisplayType.isLOB(column.getAD_Reference_ID()))
			mTab.setValue(MDEXColumn.COLUMNNAME_DataType, MDEXColumn.DATATYPE_Blob);
		else
			mTab.setValue(MDEXColumn.COLUMNNAME_DataType, MDEXColumn.DATATYPE_String);
		
		return null;
		
	}

}
