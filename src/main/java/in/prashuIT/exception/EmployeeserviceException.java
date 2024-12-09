package in.prashuIT.exception;

public class EmployeeserviceException extends RuntimeException{
		
		private String errorCode;
		
		public EmployeeserviceException() {
			
		}

		public EmployeeserviceException(String msg , String errorCode) {
			super(msg);
			this.errorCode = errorCode;
		}

		public String getErrorCode() {  //this getter method show only errorCode in AppExceptionhandlerClass
			return errorCode;
		}

}
