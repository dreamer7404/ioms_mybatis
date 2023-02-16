package com.oms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import able.cloud.core.web.HController;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oms.model.CodeMgmt;
import com.oms.service.CodeMgmtService;
import lombok.RequiredArgsConstructor;


/**
 * <pre>
 * CodeMgmt Controller
 * </pre>
 * 
 * @ClassName   : CodeMgmtController.java
 * @Description : 
 * @author 안경수 
 * @since 2023.1.19
 * @see
 */

@CrossOrigin(origins="*")
@RequiredArgsConstructor
@RestController
public class CodeMgmtController extends HController {

    /**
     * CodeMgmtService 선언 (CodeMgmtService) Class Injection)
     */
	private final CodeMgmtService codeMgmtService;

   
}