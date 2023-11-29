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

/** Generated Model for DEX_Processor
 *  @author iDempiere (generated) 
 *  @version Release 10 - $Id$ */
@org.adempiere.base.Model(table="DEX_Processor")
public class X_DEX_Processor extends PO implements I_DEX_Processor, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20231129L;

    /** Standard Constructor */
    public X_DEX_Processor (Properties ctx, int DEX_Processor_ID, String trxName)
    {
      super (ctx, DEX_Processor_ID, trxName);
      /** if (DEX_Processor_ID == 0)
        {
			setClassname (null);
			setDEX_Processor_ID (0);
			setName (null);
        } */
    }

    /** Standard Constructor */
    public X_DEX_Processor (Properties ctx, int DEX_Processor_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, DEX_Processor_ID, trxName, virtualColumns);
      /** if (DEX_Processor_ID == 0)
        {
			setClassname (null);
			setDEX_Processor_ID (0);
			setName (null);
        } */
    }

    /** Load Constructor */
    public X_DEX_Processor (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 4 - System 
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
      StringBuilder sb = new StringBuilder ("X_DEX_Processor[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
    }

	/** Set Classname.
		@param Classname Java Classname
	*/
	public void setClassname (String Classname)
	{
		set_Value (COLUMNNAME_Classname, Classname);
	}

	/** Get Classname.
		@return Java Classname
	  */
	public String getClassname()
	{
		return (String)get_Value(COLUMNNAME_Classname);
	}

	/** Set Data Extractor Processor.
		@param DEX_Processor_ID Data Extractor Processor
	*/
	public void setDEX_Processor_ID (int DEX_Processor_ID)
	{
		if (DEX_Processor_ID < 1)
			set_ValueNoCheck (COLUMNNAME_DEX_Processor_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_DEX_Processor_ID, Integer.valueOf(DEX_Processor_ID));
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

	/** Set DEX_Processor_UU.
		@param DEX_Processor_UU DEX_Processor_UU
	*/
	public void setDEX_Processor_UU (String DEX_Processor_UU)
	{
		set_Value (COLUMNNAME_DEX_Processor_UU, DEX_Processor_UU);
	}

	/** Get DEX_Processor_UU.
		@return DEX_Processor_UU	  */
	public String getDEX_Processor_UU()
	{
		return (String)get_Value(COLUMNNAME_DEX_Processor_UU);
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