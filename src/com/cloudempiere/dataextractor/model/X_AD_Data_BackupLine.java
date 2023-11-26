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

/** Generated Model for AD_Data_BackupLine
 *  @author iDempiere (generated) 
 *  @version Release 10 - $Id$ */
@org.adempiere.base.Model(table="AD_Data_BackupLine")
public class X_AD_Data_BackupLine extends PO implements I_AD_Data_BackupLine, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20231124L;

    /** Standard Constructor */
    public X_AD_Data_BackupLine (Properties ctx, int AD_Data_BackupLine_ID, String trxName)
    {
      super (ctx, AD_Data_BackupLine_ID, trxName);
      /** if (AD_Data_BackupLine_ID == 0)
        {
			setAD_BackupSchema_Table_ID (0);
			setAD_Data_Backup_ID (0);
			setAD_Data_BackupLine_ID (0);
			setSQLStatement (null);
        } */
    }

    /** Standard Constructor */
    public X_AD_Data_BackupLine (Properties ctx, int AD_Data_BackupLine_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, AD_Data_BackupLine_ID, trxName, virtualColumns);
      /** if (AD_Data_BackupLine_ID == 0)
        {
			setAD_BackupSchema_Table_ID (0);
			setAD_Data_Backup_ID (0);
			setAD_Data_BackupLine_ID (0);
			setSQLStatement (null);
        } */
    }

    /** Load Constructor */
    public X_AD_Data_BackupLine (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_AD_Data_BackupLine[")
        .append(get_ID()).append("]");
      return sb.toString();
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

	public I_AD_Data_Backup getAD_Data_Backup() throws RuntimeException
	{
		return (I_AD_Data_Backup)MTable.get(getCtx(), I_AD_Data_Backup.Table_ID)
			.getPO(getAD_Data_Backup_ID(), get_TrxName());
	}

	/** Set Data Backup.
		@param AD_Data_Backup_ID Data Backup
	*/
	public void setAD_Data_Backup_ID (int AD_Data_Backup_ID)
	{
		if (AD_Data_Backup_ID < 1)
			set_ValueNoCheck (COLUMNNAME_AD_Data_Backup_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_AD_Data_Backup_ID, Integer.valueOf(AD_Data_Backup_ID));
	}

	/** Get Data Backup.
		@return Data Backup	  */
	public int getAD_Data_Backup_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_Data_Backup_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Data Backup Line.
		@param AD_Data_BackupLine_ID Data Backup Line
	*/
	public void setAD_Data_BackupLine_ID (int AD_Data_BackupLine_ID)
	{
		if (AD_Data_BackupLine_ID < 1)
			set_ValueNoCheck (COLUMNNAME_AD_Data_BackupLine_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_AD_Data_BackupLine_ID, Integer.valueOf(AD_Data_BackupLine_ID));
	}

	/** Get Data Backup Line.
		@return Data Backup Line	  */
	public int getAD_Data_BackupLine_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_Data_BackupLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set AD_Data_BackupLine_UU.
		@param AD_Data_BackupLine_UU AD_Data_BackupLine_UU
	*/
	public void setAD_Data_BackupLine_UU (String AD_Data_BackupLine_UU)
	{
		set_ValueNoCheck (COLUMNNAME_AD_Data_BackupLine_UU, AD_Data_BackupLine_UU);
	}

	/** Get AD_Data_BackupLine_UU.
		@return AD_Data_BackupLine_UU	  */
	public String getAD_Data_BackupLine_UU()
	{
		return (String)get_Value(COLUMNNAME_AD_Data_BackupLine_UU);
	}

	/** Set SQL Expression/Statement.
		@param SQLStatement SQL Expression/Statement
	*/
	public void setSQLStatement (String SQLStatement)
	{
		set_Value (COLUMNNAME_SQLStatement, SQLStatement);
	}

	/** Get SQL Expression/Statement.
		@return SQL Expression/Statement	  */
	public String getSQLStatement()
	{
		return (String)get_Value(COLUMNNAME_SQLStatement);
	}
}