package dat.service;

import java.sql.SQLException;

import db.connect.MyExecuteData;
import db.connect.MyGetData;
import db.define.DBConfig;
import db.define.MyTableModel;

public class Keyword
{
	public MyExecuteData mExec;
	public MyGetData mGet;

	public Keyword(DBConfig mConfigObj) throws Exception
	{
		try
		{
			mExec = new MyExecuteData(mConfigObj);
			mGet = new MyGetData(mConfigObj);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	
	/**
	 * 
	 * @param Type
	 *            <p>
	 *            Type = 1: Lấy chi tiết 1 Record (Para_1 = KeywordID)
	 *            </p>
	 *            <p>
	 *            Type = 4: Lấy tin theo (Para_1 = Keyword) 
	 *            </p>
	 * @param Para_1
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public MyTableModel Select(int Type, String Para_1) throws Exception, SQLException
	{
		try
		{
			String Arr_Name[] = { "Type", "Para_1" };
			String Arr_Value[] = { Integer.toString(Type), Para_1 };

			return mGet.GetData_Pro("Sp_Keyword_Select", Arr_Name, Arr_Value);
		}
		catch (SQLException ex)
		{
			throw ex;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	
	public Integer GetPartnerID(String Keyword) throws Exception
	{
		MyTableModel mTable =  Select(4, Keyword);
		if(mTable.GetRowCount() > 0)
		{
			if(mTable.GetValueAt(0, "PartnerID") != null)
			{
				return Integer.parseInt(mTable.GetValueAt(0, "PartnerID").toString());
			}
				
		}
		return 0;
	}

}
