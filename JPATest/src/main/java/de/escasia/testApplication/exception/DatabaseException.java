package de.escasia.testApplication.exception;

public class DatabaseException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String databaseName;
	private final String databaseType;
	private final String errMessage;
	
	public DatabaseException(String databaseName, String databaseType,
			String errMessage) {
		super();
		this.databaseName = databaseName;
		this.databaseType = databaseType;
		this.errMessage = errMessage;
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public String getDatabaseType() {
		return databaseType;
	}

	public String getErrMessage() {
		return errMessage;
	}

	@Override
	public String toString() {
		return "DatabaseException [databaseName=" + databaseName
				+ ", databaseType=" + databaseType + ", errMessage="
				+ errMessage + "]";
	}

}
