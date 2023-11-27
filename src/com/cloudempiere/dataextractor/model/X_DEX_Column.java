/******************************************************************************
 * Product: iDempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2012 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
/** Generated Model - DO NOT CHANGE */
package com.cloudempiere.dataextractor.model;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.*;

/** Generated Model for DEX_Column
 *  @author iDempiere (generated) 
 *  @version Release 10 - $Id$ */
@org.adempiere.base.Model(table="DEX_Column")
public class X_DEX_Column extends PO implements I_DEX_Column, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20231127L;

    /** Standard Constructor */
    public X_DEX_Column (Properties ctx, int DEX_Column_ID, String trxName)
    {
      super (ctx, DEX_Column_ID, trxName);
      /** if (DEX_Column_ID == 0)
        {
			setDEX_Column_ID (0);
			setDEX_Table_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_DEX_Column (Properties ctx, int DEX_Column_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, DEX_Column_ID, trxName, virtualColumns);
      /** if (DEX_Column_ID == 0)
        {
			setDEX_Column_ID (0);
			setDEX_Table_ID (0);
        } */
    }

    /** Load Constructor */
    public X_DEX_Column (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 6 - System - Client 
      */
    protected int get_AccessLevel()
    {
      return accessLevel.intValue();
    }

    /** Load Meta Data */
    protected POInfo initPO (Properties ctx)
    {
      POInfo poi = POInfo.getPOInfo (ctx, Table_ID, get_TrxName());
      return poi;
    }

    public String toString()
    {
      StringBuilder sb = new StringBuilder ("X_DEX_Column[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_AD_Column getAD_Column() throws RuntimeException
	{
		return (org.compiere.model.I_AD_Column)MTable.get(getCtx(), org.compiere.model.I_AD_Column.Table_ID)
			.getPO(getAD_Column_ID(), get_TrxName());
	}

	/** Set Column.
		@param AD_Column_ID Column in the table
	*/
	public void setAD_Column_ID (int AD_Column_ID)
	{
		if (AD_Column_ID < 1)
			set_Value (COLUMNNAME_AD_Column_ID, null);
		else
			set_Value (COLUMNNAME_AD_Column_ID, Integer.valueOf(AD_Column_ID));
	}

	/** Get Column.
		@return Column in the table
	  */
	public int getAD_Column_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_Column_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set DB Column Name.
		@param ColumnName Name of the column in the database
	*/
	public void setColumnName (String ColumnName)
	{
		set_Value (COLUMNNAME_ColumnName, ColumnName);
	}

	/** Get DB Column Name.
		@return Name of the column in the database
	  */
	public String getColumnName()
	{
		return (String)get_Value(COLUMNNAME_ColumnName);
	}
	
	/** Number = N */
	public static final String DATATYPE_Number = "N";
	/** String = S */
	public static final String DATATYPE_String = "S";
	/** Set Data Type.
		@param DataType Type of data
	*/
	public void setDataType (String DataType)
	{

		set_Value (COLUMNNAME_DataType, DataType);
	}

	/** Get Data Type.
		@return Type of data
	  */
	public String getDataType()
	{
		return (String)get_Value(COLUMNNAME_DataType);
	}

	/** Set Data Extractor Column.
		@param DEX_Column_ID Data Extractor Column
	*/
	public void setDEX_Column_ID (int DEX_Column_ID)
	{
		if (DEX_Column_ID < 1)
			set_ValueNoCheck (COLUMNNAME_DEX_Column_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_DEX_Column_ID, Integer.valueOf(DEX_Column_ID));
	}

	/** Get Data Extractor Column.
		@return Data Extractor Column	  */
	public int getDEX_Column_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_DEX_Column_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set DEX_Column_UU.
		@param DEX_Column_UU DEX_Column_UU
	*/
	public void setDEX_Column_UU (String DEX_Column_UU)
	{
		set_Value (COLUMNNAME_DEX_Column_UU, DEX_Column_UU);
	}

	/** Get DEX_Column_UU.
		@return DEX_Column_UU	  */
	public String getDEX_Column_UU()
	{
		return (String)get_Value(COLUMNNAME_DEX_Column_UU);
	}

	public I_DEX_Table getDEX_Table() throws RuntimeException
	{
		return (I_DEX_Table)MTable.get(getCtx(), I_DEX_Table.Table_ID)
			.getPO(getDEX_Table_ID(), get_TrxName());
	}

	/** Set Data Extractor Table.
		@param DEX_Table_ID Data Extractor Table
	*/
	public void setDEX_Table_ID (int DEX_Table_ID)
	{
		if (DEX_Table_ID < 1)
			set_ValueNoCheck (COLUMNNAME_DEX_Table_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_DEX_Table_ID, Integer.valueOf(DEX_Table_ID));
	}

	/** Get Data Extractor Table.
		@return Data Extractor Table	  */
	public int getDEX_Table_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_DEX_Table_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}