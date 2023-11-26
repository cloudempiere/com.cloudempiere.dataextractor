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

/** Generated Model for AD_Data_Backup
 *  @author iDempiere (generated) 
 *  @version Release 10 - $Id$ */
@org.adempiere.base.Model(table="AD_Data_Backup")
public class X_AD_Data_Backup extends PO implements I_AD_Data_Backup, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20231124L;

    /** Standard Constructor */
    public X_AD_Data_Backup (Properties ctx, int AD_Data_Backup_ID, String trxName)
    {
      super (ctx, AD_Data_Backup_ID, trxName);
      /** if (AD_Data_Backup_ID == 0)
        {
			setAD_Data_Backup_ID (0);
			setBackupFrequency (null);
// O
			setStartTime (new Timestamp( System.currentTimeMillis() ));
			setValue (null);
        } */
    }

    /** Standard Constructor */
    public X_AD_Data_Backup (Properties ctx, int AD_Data_Backup_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, AD_Data_Backup_ID, trxName, virtualColumns);
      /** if (AD_Data_Backup_ID == 0)
        {
			setAD_Data_Backup_ID (0);
			setBackupFrequency (null);
// O
			setStartTime (new Timestamp( System.currentTimeMillis() ));
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_AD_Data_Backup (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_AD_Data_Backup[")
        .append(get_ID()).append("]");
      return sb.toString();
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

	/** Set AD_Data_Backup_UU.
		@param AD_Data_Backup_UU AD_Data_Backup_UU
	*/
	public void setAD_Data_Backup_UU (String AD_Data_Backup_UU)
	{
		set_ValueNoCheck (COLUMNNAME_AD_Data_Backup_UU, AD_Data_Backup_UU);
	}

	/** Get AD_Data_Backup_UU.
		@return AD_Data_Backup_UU	  */
	public String getAD_Data_Backup_UU()
	{
		return (String)get_Value(COLUMNNAME_AD_Data_Backup_UU);
	}

	/** Daily = D */
	public static final String BACKUPFREQUENCY_Daily = "D";
	/** Once Time = O */
	public static final String BACKUPFREQUENCY_OnceTime = "O";
	/** Weekly = W */
	public static final String BACKUPFREQUENCY_Weekly = "W";
	/** Set Backup Frequency.
		@param BackupFrequency Backup Frequency
	*/
	public void setBackupFrequency (String BackupFrequency)
	{

		set_Value (COLUMNNAME_BackupFrequency, BackupFrequency);
	}

	/** Get Backup Frequency.
		@return Backup Frequency	  */
	public String getBackupFrequency()
	{
		return (String)get_Value(COLUMNNAME_BackupFrequency);
	}

	/** Canceled = C */
	public static final String DATABACKUPSTATUS_Canceled = "C";
	/** Exported = E */
	public static final String DATABACKUPSTATUS_Exported = "E";
	/** New = N */
	public static final String DATABACKUPSTATUS_New = "N";
	/** Waiting = W */
	public static final String DATABACKUPSTATUS_Waiting = "W";
	/** Set Data Backup Status.
		@param DataBackupStatus Data Backup Status
	*/
	public void setDataBackupStatus (String DataBackupStatus)
	{

		set_Value (COLUMNNAME_DataBackupStatus, DataBackupStatus);
	}

	/** Get Data Backup Status.
		@return Data Backup Status	  */
	public String getDataBackupStatus()
	{
		return (String)get_Value(COLUMNNAME_DataBackupStatus);
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

	/** Set Search Key.
		@param Value Search key for the record in the format required - must be unique
	*/
	public void setValue (String Value)
	{
		set_Value (COLUMNNAME_Value, Value);
	}

	/** Get Search Key.
		@return Search key for the record in the format required - must be unique
	  */
	public String getValue()
	{
		return (String)get_Value(COLUMNNAME_Value);
	}
}