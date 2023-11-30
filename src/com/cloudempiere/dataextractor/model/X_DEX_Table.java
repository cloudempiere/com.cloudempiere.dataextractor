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

/** Generated Model for DEX_Table
 *  @author iDempiere (generated) 
 *  @version Release 10 - $Id$ */
@org.adempiere.base.Model(table="DEX_Table")
public class X_DEX_Table extends PO implements I_DEX_Table, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20231130L;

    /** Standard Constructor */
    public X_DEX_Table (Properties ctx, int DEX_Table_ID, String trxName)
    {
      super (ctx, DEX_Table_ID, trxName);
      /** if (DEX_Table_ID == 0)
        {
			setAD_Table_ID (0);
			setDEX_Schema_ID (0);
			setDEX_Table_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_DEX_Table (Properties ctx, int DEX_Table_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, DEX_Table_ID, trxName, virtualColumns);
      /** if (DEX_Table_ID == 0)
        {
			setAD_Table_ID (0);
			setDEX_Schema_ID (0);
			setDEX_Table_ID (0);
        } */
    }

    /** Load Constructor */
    public X_DEX_Table (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_DEX_Table[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_AD_Table getAD_Table() throws RuntimeException
	{
		return (org.compiere.model.I_AD_Table)MTable.get(getCtx(), org.compiere.model.I_AD_Table.Table_ID)
			.getPO(getAD_Table_ID(), get_TrxName());
	}

	/** Set Table.
		@param AD_Table_ID Database Table information
	*/
	public void setAD_Table_ID (int AD_Table_ID)
	{
		if (AD_Table_ID < 1)
			set_Value (COLUMNNAME_AD_Table_ID, null);
		else
			set_Value (COLUMNNAME_AD_Table_ID, Integer.valueOf(AD_Table_ID));
	}

	/** Get Table.
		@return Database Table information
	  */
	public int getAD_Table_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_Table_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_DEX_Schema getDEX_Schema() throws RuntimeException
	{
		return (I_DEX_Schema)MTable.get(getCtx(), I_DEX_Schema.Table_ID)
			.getPO(getDEX_Schema_ID(), get_TrxName());
	}

	/** Set Data Extractor Schema.
		@param DEX_Schema_ID Data Extractor Schema
	*/
	public void setDEX_Schema_ID (int DEX_Schema_ID)
	{
		if (DEX_Schema_ID < 1)
			set_ValueNoCheck (COLUMNNAME_DEX_Schema_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_DEX_Schema_ID, Integer.valueOf(DEX_Schema_ID));
	}

	/** Get Data Extractor Schema.
		@return Data Extractor Schema	  */
	public int getDEX_Schema_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_DEX_Schema_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	/** Set DEX_Table_UU.
		@param DEX_Table_UU DEX_Table_UU
	*/
	public void setDEX_Table_UU (String DEX_Table_UU)
	{
		set_Value (COLUMNNAME_DEX_Table_UU, DEX_Table_UU);
	}

	/** Get DEX_Table_UU.
		@return DEX_Table_UU	  */
	public String getDEX_Table_UU()
	{
		return (String)get_Value(COLUMNNAME_DEX_Table_UU);
	}

	/** Set Limit Data.
		@param LimitData Maximum Data
	*/
	public void setLimitData (int LimitData)
	{
		set_Value (COLUMNNAME_LimitData, Integer.valueOf(LimitData));
	}

	/** Get Limit Data.
		@return Maximum Data
	  */
	public int getLimitData()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LimitData);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Sql ORDER BY.
		@param OrderByClause Fully qualified ORDER BY clause
	*/
	public void setOrderByClause (String OrderByClause)
	{
		set_Value (COLUMNNAME_OrderByClause, OrderByClause);
	}

	/** Get Sql ORDER BY.
		@return Fully qualified ORDER BY clause
	  */
	public String getOrderByClause()
	{
		return (String)get_Value(COLUMNNAME_OrderByClause);
	}

	/** Set DB Table Name.
		@param TableName Name of the table in the database
	*/
	public void setTableName (String TableName)
	{
		set_Value (COLUMNNAME_TableName, TableName);
	}

	/** Get DB Table Name.
		@return Name of the table in the database
	  */
	public String getTableName()
	{
		return (String)get_Value(COLUMNNAME_TableName);
	}

	/** Set Sql WHERE.
		@param WhereClause Fully qualified SQL WHERE clause
	*/
	public void setWhereClause (String WhereClause)
	{
		set_Value (COLUMNNAME_WhereClause, WhereClause);
	}

	/** Get Sql WHERE.
		@return Fully qualified SQL WHERE clause
	  */
	public String getWhereClause()
	{
		return (String)get_Value(COLUMNNAME_WhereClause);
	}
}