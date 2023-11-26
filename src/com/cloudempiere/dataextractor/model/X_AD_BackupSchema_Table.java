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

/** Generated Model for AD_BackupSchema_Table
 *  @author iDempiere (generated) 
 *  @version Release 10 - $Id$ */
@org.adempiere.base.Model(table="AD_BackupSchema_Table")
public class X_AD_BackupSchema_Table extends PO implements I_AD_BackupSchema_Table, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20231126L;

    /** Standard Constructor */
    public X_AD_BackupSchema_Table (Properties ctx, int AD_BackupSchema_Table_ID, String trxName)
    {
      super (ctx, AD_BackupSchema_Table_ID, trxName);
      /** if (AD_BackupSchema_Table_ID == 0)
        {
			setAD_BackupSchema_ID (0);
			setAD_BackupSchema_Table_ID (0);
			setAD_Table_ID (0);
			setName (null);
        } */
    }

    /** Standard Constructor */
    public X_AD_BackupSchema_Table (Properties ctx, int AD_BackupSchema_Table_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, AD_BackupSchema_Table_ID, trxName, virtualColumns);
      /** if (AD_BackupSchema_Table_ID == 0)
        {
			setAD_BackupSchema_ID (0);
			setAD_BackupSchema_Table_ID (0);
			setAD_Table_ID (0);
			setName (null);
        } */
    }

    /** Load Constructor */
    public X_AD_BackupSchema_Table (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_AD_BackupSchema_Table[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
    }

	public I_AD_BackupSchema getAD_BackupSchema() throws RuntimeException
	{
		return (I_AD_BackupSchema)MTable.get(getCtx(), I_AD_BackupSchema.Table_ID)
			.getPO(getAD_BackupSchema_ID(), get_TrxName());
	}

	/** Set Backup Schema.
		@param AD_BackupSchema_ID Backup Schema
	*/
	public void setAD_BackupSchema_ID (int AD_BackupSchema_ID)
	{
		if (AD_BackupSchema_ID < 1)
			set_ValueNoCheck (COLUMNNAME_AD_BackupSchema_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_AD_BackupSchema_ID, Integer.valueOf(AD_BackupSchema_ID));
	}

	/** Get Backup Schema.
		@return Backup Schema	  */
	public int getAD_BackupSchema_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_BackupSchema_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	/** Set AD_BackupSchema_Table_UU.
		@param AD_BackupSchema_Table_UU AD_BackupSchema_Table_UU
	*/
	public void setAD_BackupSchema_Table_UU (String AD_BackupSchema_Table_UU)
	{
		set_ValueNoCheck (COLUMNNAME_AD_BackupSchema_Table_UU, AD_BackupSchema_Table_UU);
	}

	/** Get AD_BackupSchema_Table_UU.
		@return AD_BackupSchema_Table_UU	  */
	public String getAD_BackupSchema_Table_UU()
	{
		return (String)get_Value(COLUMNNAME_AD_BackupSchema_Table_UU);
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

	/** Set Name.
		@param Name Alphanumeric identifier of the entity
	*/
	public void setName (String Name)
	{
		set_Value (COLUMNNAME_Name, Name);
	}

	/** Get Name.
		@return Alphanumeric identifier of the entity
	  */
	public String getName()
	{
		return (String)get_Value(COLUMNNAME_Name);
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