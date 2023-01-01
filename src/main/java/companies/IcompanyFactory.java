package companies;

import Client.database;

public interface IcompanyFactory {
		public company chooseCompany(String theOrder,database data);
}
