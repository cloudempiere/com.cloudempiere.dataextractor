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

/** Generated Interface for DEX_Job_Table
 *  @author iDempiere (generated) 
 *  @version Release 10
 */
@SuppressWarnings("all")
public interface I_DEX_Job_Table 
{

    /** TableName=DEX_Job_Table */
    public static final String Table_Name = "DEX_Job_Table";

    /** AD_Table_ID=1000036 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 6 - System - Client 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(6);

    /** Load Meta Data */

    /** Column name AD_Client_ID */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/** Get Tenant.
	  * Tenant for this installation.
	  */
	public int getAD_Client_ID();

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

    /** Column name DEX_Job_ID */
    public static final String COLUMNNAME_DEX_Job_ID = "DEX_Job_ID";

	/** Set Data Extractor Job	  */
	public void setDEX_Job_ID (int DEX_Job_ID);

	/** Get Data Extractor Job	  */
	public int getDEX_Job_ID();

	public I_DEX_Job getDEX_Job() throws RuntimeException;

    /** Column name DEX_Job_Table_ID */
    public static final String COLUMNNAME_DEX_Job_Table_ID = "DEX_Job_Table_ID";

	/** Set Job Table	  */
	public void setDEX_Job_Table_ID (int DEX_Job_Table_ID);

	/** Get Job Table	  */
	public int getDEX_Job_Table_ID();

    /** Column name DEX_Job_Table_UU */
    public static final String COLUMNNAME_DEX_Job_Table_UU = "DEX_Job_Table_UU";

	/** Set DEX_Job_Table_UU	  */
	public void setDEX_Job_Table_UU (String DEX_Job_Table_UU);

	/** Get DEX_Job_Table_UU	  */
	public String getDEX_Job_Table_UU();

    /** Column name DEX_Table_ID */
    public static final String COLUMNNAME_DEX_Table_ID = "DEX_Table_ID";

	/** Set Data Extractor Table	  */
	public void setDEX_Table_ID (int DEX_Table_ID);

	/** Get Data Extractor Table	  */
	public int getDEX_Table_ID();

	public I_DEX_Table getDEX_Table() throws RuntimeException;

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

    /** Column name Processed */
    public static final String COLUMNNAME_Processed = "Processed";

	/** Set Processed.
	  * The document has been processed
	  */
	public void setProcessed (boolean Processed);

	/** Get Processed.
	  * The document has been processed
	  */
	public boolean isProcessed();

    /** Column name TotalRows */
    public static final String COLUMNNAME_TotalRows = "TotalRows";

	/** Set Total Rows	  */
	public void setTotalRows (int TotalRows);

	/** Get Total Rows	  */
	public int getTotalRows();

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
