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

/** Generated Model for AD_BackupSchema_Column
 *  @author iDempiere (generated) 
 *  @version Release 10 - $Id$ */
@org.adempiere.base.Model(table="AD_BackupSchema_Column")
public class X_AD_BackupSchema_Column extends PO implements I_AD_BackupSchema_Column, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20231126L;

    /** Standard Constructor */
    public X_AD_BackupSchema_Column (Properties ctx, int AD_BackupSchema_Column_ID, String trxName)
    {
      super (ctx, AD_BackupSchema_Column_ID, trxName);
      /** if (AD_BackupSchema_Column_ID == 0)
        {
			setAD_BackupSchema_Column_ID (0);
			setAD_BackupSchema_Table_ID (0);
			setAD_Column_ID (0);
			setDataType (null);
// S
        } */
    }

    /** Standard Constructor */
    public X_AD_BackupSchema_Column (Properties ctx, int AD_BackupSchema_Column_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, AD_BackupSchema_Column_ID, trxName, virtualColumns);
      /** if (AD_BackupSchema_Column_ID == 0)
        {
			setAD_BackupSchema_Column_ID (0);
			setAD_BackupSchema_Table_ID (0);
			setAD_Column_ID (0);
			setDataType (null);
// S
        } */
    }

    /** Load Constructor */
    public X_AD_BackupSchema_Column (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_AD_BackupSchema_Column[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Backup Schema Column.
		@param AD_BackupSchema_Column_ID Backup Schema Column
	*/
	public void setAD_BackupSchema_Column_ID (int AD_BackupSchema_Column_ID)
	{
		if (AD_BackupSchema_Column_ID < 1)
			set_ValueNoCheck (COLUMNNAME_AD_BackupSchema_Column_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_AD_BackupSchema_Column_ID, Integer.valueOf(AD_BackupSchema_Column_ID));
	}

	/** Get Backup Schema Column.
		@return Backup Schema Column	  */
	public int getAD_BackupSchema_Column_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_BackupSchema_Column_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set AD_BackupSchema_Column_UU.
		@param AD_BackupSchema_Column_UU AD_BackupSchema_Column_UU
	*/
	public void setAD_BackupSchema_Column_UU (String AD_BackupSchema_Column_UU)
	{
		set_ValueNoCheck (COLUMNNAME_AD_BackupSchema_Column_UU, AD_BackupSchema_Column_UU);
	}

	/** Get AD_BackupSchema_Column_UU.
		@return AD_BackupSchema_Column_UU	  */
	public String getAD_BackupSchema_Column_UU()
	{
		return (String)get_Value(COLUMNNAME_AD_BackupSchema_Column_UU);
	}

	public I_AD_BackupSchema_Table getAD_BackupSchema_Table() throws RuntimeException
	{
		return (I_AD_BackupSchema_Table)MTable.get(getCtx(), I_AD_BackupSchema_Table.Table_ID)
			.getPO(getAD_BackupSchema_Table_ID(), get_TrxName());
	}

	/** Set Backup Schema Table.
		@param AD_BackupSchema_Table_ID Backup Schema Table
	*/
	public void setAD_BackupSchema_Table_ID (int AD_BackupSchema_Table_ID)
	{
		if (AD_BackupSchema_Table_ID < 1)
			set_ValueNoCheck (COLUMNNAME_AD_BackupSchema_Table_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_AD_BackupSchema_Table_ID, Integer.valueOf(AD_BackupSchema_Table_ID));
	}

	/** Get Backup Schema Table.
		@return Backup Schema Table	  */
	public int getAD_BackupSchema_Table_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_BackupSchema_Table_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	/** DataType AD_Reference_ID=209 */
	public static final int DATATYPE_AD_Reference_ID=209;
	/** Comma Separated = C */
	public static final String DATATYPE_CommaSeparated = "C";
	/** Fixed Position = F */
	public static final String DATATYPE_FixedPosition = "F";
	/** Tab Separated = T */
	public static final String DATATYPE_TabSeparated = "T";
	/** Custom Separator Char = U */
	public static final String DATATYPE_CustomSeparatorChar = "U";
	/** XML = X */
	public static final String DATATYPE_XML = "X";
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
}