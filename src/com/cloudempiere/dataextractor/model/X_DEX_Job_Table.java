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

/** Generated Model for DEX_Job_Table
 *  @author iDempiere (generated) 
 *  @version Release 10 - $Id$ */
@org.adempiere.base.Model(table="DEX_Job_Table")
public class X_DEX_Job_Table extends PO implements I_DEX_Job_Table, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20231204L;

    /** Standard Constructor */
    public X_DEX_Job_Table (Properties ctx, int DEX_Job_Table_ID, String trxName)
    {
      super (ctx, DEX_Job_Table_ID, trxName);
      /** if (DEX_Job_Table_ID == 0)
        {
			setDEX_Job_ID (0);
			setDEX_Job_Table_ID (0);
			setDEX_Table_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_DEX_Job_Table (Properties ctx, int DEX_Job_Table_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, DEX_Job_Table_ID, trxName, virtualColumns);
      /** if (DEX_Job_Table_ID == 0)
        {
			setDEX_Job_ID (0);
			setDEX_Job_Table_ID (0);
			setDEX_Table_ID (0);
        } */
    }

    /** Load Constructor */
    public X_DEX_Job_Table (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_DEX_Job_Table[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public I_DEX_Job getDEX_Job() throws RuntimeException
	{
		return (I_DEX_Job)MTable.get(getCtx(), I_DEX_Job.Table_ID)
			.getPO(getDEX_Job_ID(), get_TrxName());
	}

	/** Set Data Extractor Job.
		@param DEX_Job_ID Data Extractor Job
	*/
	public void setDEX_Job_ID (int DEX_Job_ID)
	{
		if (DEX_Job_ID < 1)
			set_ValueNoCheck (COLUMNNAME_DEX_Job_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_DEX_Job_ID, Integer.valueOf(DEX_Job_ID));
	}

	/** Get Data Extractor Job.
		@return Data Extractor Job	  */
	public int getDEX_Job_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_DEX_Job_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Job Table.
		@param DEX_Job_Table_ID Job Table
	*/
	public void setDEX_Job_Table_ID (int DEX_Job_Table_ID)
	{
		if (DEX_Job_Table_ID < 1)
			set_ValueNoCheck (COLUMNNAME_DEX_Job_Table_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_DEX_Job_Table_ID, Integer.valueOf(DEX_Job_Table_ID));
	}

	/** Get Job Table.
		@return Job Table	  */
	public int getDEX_Job_Table_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_DEX_Job_Table_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set DEX_Job_Table_UU.
		@param DEX_Job_Table_UU DEX_Job_Table_UU
	*/
	public void setDEX_Job_Table_UU (String DEX_Job_Table_UU)
	{
		set_Value (COLUMNNAME_DEX_Job_Table_UU, DEX_Job_Table_UU);
	}

	/** Get DEX_Job_Table_UU.
		@return DEX_Job_Table_UU	  */
	public String getDEX_Job_Table_UU()
	{
		return (String)get_Value(COLUMNNAME_DEX_Job_Table_UU);
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

	/** Set Processed.
		@param Processed The document has been processed
	*/
	public void setProcessed (boolean Processed)
	{
		set_Value (COLUMNNAME_Processed, Boolean.valueOf(Processed));
	}

	/** Get Processed.
		@return The document has been processed
	  */
	public boolean isProcessed()
	{
		Object oo = get_Value(COLUMNNAME_Processed);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Total Rows.
		@param TotalRows Total Rows
	*/
	public void setTotalRows (int TotalRows)
	{
		set_Value (COLUMNNAME_TotalRows, Integer.valueOf(TotalRows));
	}

	/** Get Total Rows.
		@return Total Rows	  */
	public int getTotalRows()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TotalRows);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}