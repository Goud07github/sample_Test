package in.prashuIT.exception;
	
	public class ErrorResponse {
		
		private String message;
		private String errCode;
		
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public String getErrCode() {
			return errCode;
		}
		public void setErrCode(String errCode) {
			this.errCode = errCode;
		}

}
