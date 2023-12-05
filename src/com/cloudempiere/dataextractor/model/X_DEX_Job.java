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
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.*;

/** Generated Model for DEX_Job
 *  @author iDempiere (generated) 
 *  @version Release 10 - $Id$ */
@org.adempiere.base.Model(table="DEX_Job")
public class X_DEX_Job extends PO implements I_DEX_Job, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20231204L;

    /** Standard Constructor */
    public X_DEX_Job (Properties ctx, int DEX_Job_ID, String trxName)
    {
      super (ctx, DEX_Job_ID, trxName);
      /** if (DEX_Job_ID == 0)
        {
			setDEX_Job_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_DEX_Job (Properties ctx, int DEX_Job_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, DEX_Job_ID, trxName, virtualColumns);
      /** if (DEX_Job_ID == 0)
        {
			setDEX_Job_ID (0);
        } */
    }

    /** Load Constructor */
    public X_DEX_Job (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_DEX_Job[")
        .append(get_ID()).append("]");
      return sb.toString();
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

	/** Set DEX_Job_UU.
		@param DEX_Job_UU DEX_Job_UU
	*/
	public void setDEX_Job_UU (String DEX_Job_UU)
	{
		set_Value (COLUMNNAME_DEX_Job_UU, DEX_Job_UU);
	}

	/** Get DEX_Job_UU.
		@return DEX_Job_UU	  */
	public String getDEX_Job_UU()
	{
		return (String)get_Value(COLUMNNAME_DEX_Job_UU);
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
			set_Value (COLUMNNAME_DEX_Schema_ID, null);
		else
			set_Value (COLUMNNAME_DEX_Schema_ID, Integer.valueOf(DEX_Schema_ID));
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

	/** Canceled = C */
	public static final String DEX_STATUS_Canceled = "C";
	/** Done = D */
	public static final String DEX_STATUS_Done = "D";
	/** New = N */
	public static final String DEX_STATUS_New = "N";
	/** Processing = P */
	public static final String DEX_STATUS_Processing = "P";
	/** Set Extraction Status.
		@param DEX_Status Extraction Status
	*/
	public void setDEX_Status (String DEX_Status)
	{

		set_Value (COLUMNNAME_DEX_Status, DEX_Status);
	}

	/** Get Extraction Status.
		@return Extraction Status	  */
	public String getDEX_Status()
	{
		return (String)get_Value(COLUMNNAME_DEX_Status);
	}

	/** Set Expire On.
		@param Expiration Expire On
	*/
	public void setExpiration (Timestamp Expiration)
	{
		set_Value (COLUMNNAME_Expiration, Expiration);
	}

	/** Get Expire On.
		@return Expire On
	  */
	public Timestamp getExpiration()
	{
		return (Timestamp)get_Value(COLUMNNAME_Expiration);
	}

	/** Set File Name.
		@param FileName Name of the local file or URL
	*/
	public void setFileName (String FileName)
	{
		set_Value (COLUMNNAME_FileName, FileName);
	}

	/** Get File Name.
		@return Name of the local file or URL
	  */
	public String getFileName()
	{
		return (String)get_Value(COLUMNNAME_FileName);
	}

	/** Set Link URL.
		@param LinkURL Contains URL to a target
	*/
	public void setLinkURL (String LinkURL)
	{
		set_Value (COLUMNNAME_LinkURL, LinkURL);
	}

	/** Get Link URL.
		@return Contains URL to a target
	  */
	public String getLinkURL()
	{
		return (String)get_Value(COLUMNNAME_LinkURL);
	}

	/** Set Start Time.
		@param StartTime Time started
	*/
	public void setStartTime (Timestamp StartTime)
	{
		set_Value (COLUMNNAME_StartTime, StartTime);
	}

	/** Get Start Time.
		@return Time started
	  */
	public Timestamp getStartTime()
	{
		return (Timestamp)get_Value(COLUMNNAME_StartTime);
	}
}