package com.oms.cmm.exception;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import able.cloud.core.exception.BusinessException;
import able.cloud.core.exception.ErrorResponse;
/**
 *
 * <pre>
 * DispatcherServelt 이후의 영역에서 공통 Exception 처리를 구현한다.
 * Exception 별 구분해서 처리 가능하다
 * </pre>
 *
 * @author sunny
 * @since 2020. 9. 4.
 * @see
 */
@ControllerAdvice
public class GlobalExceptinoHandler {

	protected final Logger logger   = LoggerFactory.getLogger(getClass());

	/**
	 *
	 * default 처리 로직이 들어간다
	 *
	 * @param Exception
	 * @return 페이지경로 string
	 */
    @ExceptionHandler
    protected String handleDefault(Exception e) {
    	logger.error("GlobalExceptinoHandler default exception handle");
        //final ErrorResponse response = ErrorResponse.of(ErrorCode.INTERNAL_SERVER_ERROR);
        return "/common/defaultErrorView";
    }

    /**
     * BusinessException 발생 시 처리 로직이 들어긴다.
     * @param BusinessException
     * @return ResponseEntity
     */

	@ExceptionHandler(BusinessException.class)
	protected ResponseEntity<ErrorResponse> handleBusinessException(BusinessException e) {
		logger.error("GlobalExceptinoHandler  BusinessException", e.getMessage());
		final ErrorResponse response =
				  ErrorResponse.of(500, "Invalid Error");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	/**
	 *
	 * RestException 발생 시 처리 로직이 들어간다.
	 *
	 * @param RestException e
	 * @return ResponseEntity
	 */
	@ExceptionHandler(RestException.class)
	protected ResponseEntity<Object> handleRestException(RestException e) {
		logger.error("GlobalExceptinoHandler RestException", e.getMessage());
		Map<String, Object> resBody = new HashMap<>();
		resBody.put("message", e.getMessage());
		resBody.put("result", "F");
		return new ResponseEntity<Object>(resBody, HttpStatus.OK);
	}

	/**
	 *
	 * SecurityException 발생시 처리 로직이 들어간다.
	 *
	 * @param SecurityException e
	 * @return ResponseEntity
	 */
	@ExceptionHandler(able.cloud.core.exception.SecurityException.class)
	protected ResponseEntity<ErrorResponse> handleSecurityException(able.cloud.core.exception.SecurityException e) {
		logger.error("GlobalExceptinoHandler SecurityException", e.getMessage());
		final ErrorResponse response =
				  ErrorResponse.of(500, e.getMessage());

		return new ResponseEntity<>(response, HttpStatus.OK);
	}


}
