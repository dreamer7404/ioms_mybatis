package com.oms.cmm.exception;

import able.cloud.core.exception.BaseException;
/**
 *
 * <pre>
 * BaseException을 확장해서 만들었고,
 * Rest 통신 시 발생하는 exception 처리를 위한 클래스이다
 * </pre>
 *
 * @author sunny
 * @since 2020. 9. 4.
 * @see
 */
public class RestException extends BaseException {

	private static final long serialVersionUID = 1L;

	public RestException() {
        super("RestExceptin No Message");
    }

	public RestException(String message) {
        super(message);
    }

}
