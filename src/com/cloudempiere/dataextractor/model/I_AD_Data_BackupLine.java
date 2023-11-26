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
package com.cloudempiere.dataextractor.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Interface for AD_Data_BackupLine
 *  @author iDempiere (generated) 
 *  @version Release 10
 */
@SuppressWarnings("all")
public interface I_AD_Data_BackupLine 
{

    /** TableName=AD_Data_BackupLine */
    public static final String Table_Name = "AD_Data_BackupLine";

    /** AD_Table_ID=1000028 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 6 - System - Client 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(6);

    /** Load Meta Data */

    /** Column name AD_BackupSchema_Table_ID */
    public static final String COLUMNNAME_AD_BackupSchema_Table_ID = "AD_BackupSchema_Table_ID";

	/** Set Backup Schema Table	  */
	public void setAD_BackupSchema_Table_ID (int AD_BackupSchema_Table_ID);

	/** Get Backup Schema Table	  */
	public int getAD_BackupSchema_Table_ID();

	public I_AD_BackupSchema_Table getAD_BackupSchema_Table() throws RuntimeException;

    /** Column name AD_Client_ID */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/** Get Tenant.
	  * Tenant for this installation.
	  */
	public int getAD_Client_ID();

    /** Column name AD_Data_Backup_ID */
    public static final String COLUMNNAME_AD_Data_Backup_ID = "AD_Data_Backup_ID";

	/** Set Data Backup	  */
	public void setAD_Data_Backup_ID (int AD_Data_Backup_ID);

	/** Get Data Backup	  */
	public int getAD_Data_Backup_ID();

	public I_AD_Data_Backup getAD_Data_Backup() throws RuntimeException;

    /** Column name AD_Data_BackupLine_ID */
    public static final String COLUMNNAME_AD_Data_BackupLine_ID = "AD_Data_BackupLine_ID";

	/** Set Data Backup Line	  */
	public void setAD_Data_BackupLine_ID (int AD_Data_BackupLine_ID);

	/** Get Data Backup Line	  */
	public int getAD_Data_BackupLine_ID();

    /** Column name AD_Data_BackupLine_UU */
    public static final String COLUMNNAME_AD_Data_BackupLine_UU = "AD_Data_BackupLine_UU";

	/** Set AD_Data_BackupLine_UU	  */
	public void setAD_Data_BackupLine_UU (String AD_Data_BackupLine_UU);

	/** Get AD_Data_BackupLine_UU	  */
	public String getAD_Data_BackupLine_UU();

    /** Column name AD_Org_ID */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/** Set Organization.
	  * Organizational entity within tenant
	  */
	public void setAD_Org_ID (int AD_Org_ID);

	/** Get Organization.
	  * Organizational entity within tenant
	  */
	public int getAD_Org_ID();

    /** Column name Created */
    public static final String COLUMNNAME_Created = "Created";

	/** Get Created.
	  * Date this record was created
	  */
	public Timestamp getCreated();

    /** Column name CreatedBy */
    public static final String COLUMNNAME_CreatedBy = "CreatedBy";

	/** Get Created By.
	  * User who created this records
	  */
	public int getCreatedBy();

    /** Column name IsActive */
    public static final String COLUMNNAME_IsActive = "IsActive";

	/** Set Active.
	  * The record is active in the system
	  */
	public void setIsActive (boolean IsActive);

	/** Get Active.
	  * The record is active in the system
	  */
	public boolean isActive();

    /** Column name SQLStatement */
    public static final String COLUMNNAME_SQLStatement = "SQLStatement";

	/** Set SQL Expression/Statement	  */
	public void setSQLStatement (String SQLStatement);

	/** Get SQL Expression/Statement	  */
	public String getSQLStatement();

    /** Column name Updated */
    public static final String COLUMNNAME_Updated = "Updated";

	/** Get Updated.
	  * Date this record was updated
	  */
	public Timestamp getUpdated();

    /** Column name UpdatedBy */
    public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";

	/** Get Updated By.
	  * User who updated this records
	  */
	public int getUpdatedBy();
}
