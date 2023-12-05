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

/** Generated Model for DEX_Schema
 *  @author iDempiere (generated) 
 *  @version Release 10 - $Id$ */
@org.adempiere.base.Model(table="DEX_Schema")
public class X_DEX_Schema extends PO implements I_DEX_Schema, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20231205L;

    /** Standard Constructor */
    public X_DEX_Schema (Properties ctx, int DEX_Schema_ID, String trxName)
    {
      super (ctx, DEX_Schema_ID, trxName);
      /** if (DEX_Schema_ID == 0)
        {
			setDEX_Schema_ID (0);
			setName (null);
        } */
    }

    /** Standard Constructor */
    public X_DEX_Schema (Properties ctx, int DEX_Schema_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, DEX_Schema_ID, trxName, virtualColumns);
      /** if (DEX_Schema_ID == 0)
        {
			setDEX_Schema_ID (0);
			setName (null);
        } */
    }

    /** Load Constructor */
    public X_DEX_Schema (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_DEX_Schema[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
    }

	/** Set Description.
		@param Description Optional short description of the record
	*/
	public void setDescription (String Description)
	{
		set_Value (COLUMNNAME_Description, Description);
	}

	/** Get Description.
		@return Optional short description of the record
	  */
	public String getDescription()
	{
		return (String)get_Value(COLUMNNAME_Description);
	}

	public I_DEX_Processor getDEX_Processor() throws RuntimeException
	{
		return (I_DEX_Processor)MTable.get(getCtx(), I_DEX_Processor.Table_ID)
			.getPO(getDEX_Processor_ID(), get_TrxName());
	}

	/** Set Data Extractor Processor.
		@param DEX_Processor_ID Data Extractor Processor
	*/
	public void setDEX_Processor_ID (int DEX_Processor_ID)
	{
		if (DEX_Processor_ID < 1)
			set_Value (COLUMNNAME_DEX_Processor_ID, null);
		else
			set_Value (COLUMNNAME_DEX_Processor_ID, Integer.valueOf(DEX_Processor_ID));
	}

	/** Get Data Extractor Processor.
		@return Data Extractor Processor	  */
	public int getDEX_Processor_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_DEX_Processor_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	/** Set DEX_Schema_UU.
		@param DEX_Schema_UU DEX_Schema_UU
	*/
	public void setDEX_Schema_UU (String DEX_Schema_UU)
	{
		set_Value (COLUMNNAME_DEX_Schema_UU, DEX_Schema_UU);
	}

	/** Get DEX_Schema_UU.
		@return DEX_Schema_UU	  */
	public String getDEX_Schema_UU()
	{
		return (String)get_Value(COLUMNNAME_DEX_Schema_UU);
	}

	/** Set Valid.
		@param IsValid Element is valid
	*/
	public void setIsValid (boolean IsValid)
	{
		set_Value (COLUMNNAME_IsValid, Boolean.valueOf(IsValid));
	}

	/** Get Valid.
		@return Element is valid
	  */
	public boolean isValid()
	{
		Object oo = get_Value(COLUMNNAME_IsValid);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
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

	/** Set Process Now.
		@param Processing Process Now
	*/
	public void setProcessing (boolean Processing)
	{
		set_Value (COLUMNNAME_Processing, Boolean.valueOf(Processing));
	}

	/** Get Process Now.
		@return Process Now	  */
	public boolean isProcessing()
	{
		Object oo = get_Value(COLUMNNAME_Processing);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
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