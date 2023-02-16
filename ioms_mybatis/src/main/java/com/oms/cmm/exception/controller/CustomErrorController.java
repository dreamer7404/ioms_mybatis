package com.oms.cmm.exception.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
*
* <pre>
* DispatcherServelt 이전의 영역(Filter 등)에서 Exception 처리를 구현한다.
* &#64;ControllerAdvice/@ExceptionHandler에서 처리되지 않은 Exception의 경우 여기서 처리된다.
* errorHtml 함수 안에 공통으로 처리 할 로직을 구현하면, mediatype이 text/html 이려 경우 실행된다.
* error 함수안에 공통으로 처리 할 로직을 구현다면, rest 통신 시 json 형태의 에러 처리를 한다
* </pre>
*
* @author sunny
* @since 2020. 9. 3.
* @see
*/
@Controller
@RequestMapping("${server.error.path:${error.path:/error}}")
public class CustomErrorController extends BasicErrorController {

   private static final Logger logger = LoggerFactory.getLogger(CustomErrorController.class);

   /**
    * 생성자
    *
    * @param errorAttributes
    * @param serverProperties
    * @param errorViewResolvers
    */
   public CustomErrorController(ErrorAttributes errorAttributes, ServerProperties serverProperties,
           List<ErrorViewResolver> errorViewResolvers) {
       super(errorAttributes, serverProperties.getError(), errorViewResolvers);
   }

   /**
    * mediatype이 text/html일 경우 실행된다.
    * 결과를 화면명으로 리턴한다.
    *
    * @param request
    * @param response
    * @return ModelAndView
    */
   @RequestMapping(produces = MediaType.TEXT_HTML_VALUE)
   public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
       //logger.info("CustomErrorController errorHtml : 여기에 공통로그 처리 만들면 됩니다.");
       //logger(request); // 로그 추가
//       HttpStatus status = getStatus(request);
//       Map<String, Object> model = Collections
//               .unmodifiableMap(getErrorAttributes(request, getErrorAttributeOptions(request, MediaType.TEXT_HTML)));
//       response.setStatus(status.value());
//       ModelAndView modelAndView = resolveErrorView(request, response, status, model);
//       return (modelAndView != null) ? modelAndView : new ModelAndView("common/defaultErrorView", model);
       return new ModelAndView("/index", new HashMap<String, Object>());
   }
   
   


   /**
    * error 함수 안에 공통으로 처리 할 로직을 구현한다.
    * error 함수는 보통 rest통신 시 json 형태의 에러 처리를 구현한다.
    *
    * @param request
    * @return ResponseEntity
    * @see org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController#error(javax.servlet.http.HttpServletRequest)
    */
   @Override
   public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
       //logger.info("CustomErrorController json : 여기다 공통로그 처리 만들면 됩니다.");
       //logger(request);
       HttpStatus status = getStatus(request);
       if (status == HttpStatus.NO_CONTENT) {
           return new ResponseEntity<>(status);
       }
       //Map<String, Object> body = getErrorAttributes(request, getErrorAttributeOptions(request, MediaType.ALL));
       Map<String, Object> body = new LinkedHashMap<String, Object>();
       body.put("result", "F");
       body.put("message", "Error");
       return new ResponseEntity<>(body, status);
   }

   /**
    * 로그형태를 공통으로 만들경우 사용한다
    *
    * @param request
    */
   private void logger(HttpServletRequest request) {
       logger.error("CustomErrorController error {}", request.getServletPath());
   }
   
 

}
