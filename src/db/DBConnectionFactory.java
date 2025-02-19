package db;

import db.mongodb.MongoDBConnection;
import db.mysql.MySQLConnection;

public interface DBConnectionFactory {
	// This should change based on the pipeline.
	static final String DEFAULT_DB = "mysql";
//	static final String DEFAULT_DB = "mongodb";

	
	public static DBConnection getConnection(String db) {
		switch (db) {
		case "mysql":
			return new MySQLConnection();
//			return null;
		case "mongodb":
			// return new MongoDBConnection();
			return new MongoDBConnection();
		default:
			throw new IllegalArgumentException("Invalid db:" + db);
		}

	}

	public static DBConnection getConnection() {
		return getConnection(DEFAULT_DB);
	}


}
