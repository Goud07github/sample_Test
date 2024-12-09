package in.prashuIT.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
	
	@RestControllerAdvice // it is used to GobalException Handler Class
	public class AppExceptionHandler {
		
		@ExceptionHandler(value = EmployeeserviceException.class)
		public ResponseEntity<ErrorResponse> handleProductServiceException(EmployeeserviceException emp){
		  ErrorResponse response = new ErrorResponse();
		  response.setMessage(emp.getMessage());
		  response.setErrCode(emp.getErrorCode());
		  return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}


}
