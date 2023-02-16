package com.oms.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dext5.DEXT5Handler;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

/**
 * <pre>
 * Statements
 * </pre>
 *
 * @author dext5editor, 안경수
 * @since 2023. 2. 3.
 * @see
 */
@Tag(name = "DEXT5EditorController", description = "")
@CrossOrigin(origins="*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class DEXT5EditorController {
    
    
    /*
     * dext5editor사용중에 images등 업로드할때
     */
    @RequestMapping(value = "/dext5editor", method = {RequestMethod.GET, RequestMethod.POST})
    public void dext5editorHandler(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        String _allowFileExt = "gif, jpg, jpeg, png, bmp, wmv, asf, swf, avi, mpg, mpeg, mp4, txt, doc, docx, xls, xlsx, ppt, pptx, hwp, zip, pdf,flv";
        int upload_max_size = 2147483647;
        
        ServletContext application = request.getSession().getServletContext();

        DEXT5Handler DEXT5 = new DEXT5Handler();
        
        // 환경설정파일 물리적 폴더 (서버 환경변수를 사용할 경우)
        //DEXT5.SetConfigPhysicalPath("C:/dext5/config");

        //DEXT5.SetJpegQuality(100); // JPG 품질 (1 ~ 100)
        // (저품질, 용량 축소) 1 ~ 100 (고품질, 용량 증가) - jdk 1.5 이상에서만 사용가능합니다.
        //DEXT5.SetAntialiasing(true); // 이미지 안티앨리어싱 활성화

        // ***************보안 설정 : 업로드 가능한 경로 설정 - 이외의 경로로 업로드 불가능***************
//        String[] allowUploadDirectoryPath = { request.getSession().getServletContext().getRealPath("/") };
//        DEXT5.SetAllowUploadDirectoryPath(allowUploadDirectoryPath);

        // 물리적경로 설정 !!
        DEXT5.SetRealPath("D:\\temp");
      
        String result = DEXT5.DEXTProcess(request, response, application, _allowFileExt, upload_max_size);

        if(DEXT5.IsImageUpload()) {
            /*
            // 동일 폴더에 이미지 썸네일 생성하기
            String strSourceFile = DEXT5.LastSaveFile();
            int rtn_value = DEXT5.ImageThumbnail(strSourceFile, "_thumb", 600, 0);
            if (rtn_value != 0) {
                String strLastError = DEXT5.LastErrorMessage();
            }
            */

            /*
            // 동일 폴더에 이미지 썸네일 생성하기 (변경된 파일경로 리턴)
            String strSourceFile = DEXT5.LastSaveFile();
            String strChangedFile = DEXT5.ImageThumbnailEx(strSourceFile, "_thumb", 600, 0);
            if (strChangedFile.equals("")) {
                String strLastError = DEXT5.LastErrorMessage();
            }
            */
            
            /*
            // 썸네일 파일 생성
            String strSourceFile = DEXT5.LastSaveFile();
            String strNewFileName = strSourceFile.replaceAll("\\\\image\\\\", "\\thumbnail\\");
            int rtn_value = DEXT5.GetImageThumbOrNewEx(strSourceFile, strNewFileName, 200, 0, 0);
            if (rtn_value != 0) {
                String strLastError = DEXT5.LastErrorMessage();
            }
            */
            
            /*
            // 이미지 포멧 변경
            String strSourceFile = DEXT5.LastSaveFile();
            int rtn_value = DEXT5.ImageConvertFormat(strSourceFile, "png", 0);
            if (rtn_value != 0) {
                String strLastError = DEXT5.LastErrorMessage();
            }
            */

            /*
            // 이미지 포멧 변경 (변경된 파일경로 리턴)
            String strSourceFile = DEXT5.LastSaveFile();
            String strChangedFile = DEXT5.ImageConvertFormatEx(strSourceFile, "jpg", 0);
            if (strChangedFile.equals("")) {
                String strLastError = DEXT5.LastErrorMessage();
            }
            */
            
            /*
            // 이미지 크기 변환
            String strSourceFile = DEXT5.LastSaveFile();
            int rtn_value = DEXT5.ImageConvertSize(strSourceFile, 500, 30);
            if (rtn_value != 0) {
                String strLastError = DEXT5.LastErrorMessage();
            }
            */
            
            /*
            // 비율로 이미지 크기 변환
            String strSourceFile = DEXT5.LastSaveFile();
            int rtn_value = DEXT5.ImageConvertSizeByPercent(strSourceFile, 50);
            if (rtn_value != 0) {
                String strLastError = DEXT5.LastErrorMessage();
            }
            */
            
            /*
            // 비율로 이미지 크기 변환
            String strSourceFile = DEXT5.LastSaveFile();
            int rtn_value = DEXT5.ImageConvertSizeByPercent(strSourceFile, 50);
            if (rtn_value != 0) {
                String strLastError = DEXT5.LastErrorMessage();
            }
            */
            
            /*
            // 이미지 회전
            String strSourceFile = DEXT5.LastSaveFile();
            int rtn_value = DEXT5.ImageRotate(strSourceFile, 90);
            if (rtn_value != 0) {
                String strLastError = DEXT5.LastErrorMessage();
            }
            */
            
            /*
            // 이미지 워터마크
            String strSourceFile = DEXT5.LastSaveFile();
            String strWaterMarkFile = "C:\\Temp\\watermark.jpg";
            int rtn_value = DEXT5.ImageWaterMark(strSourceFile, strWaterMarkFile, "TOP", 10, "RIGHT", 10, 0);
            if (rtn_value != 0) {
                String strLastError = DEXT5.LastErrorMessage();
            }
            */

            /*
            // 텍스트 워터마크
            String strSourceFile = DEXT5.LastSaveFile();
            DEXT5.SetFontInfo("굴림", 50, "FF00FF");
            int rtn_value = DEXT5.TextWaterMark(strSourceFile, "DEXT5", "TOP", 10, "CENTER", 10, 0, 45);
            if (rtn_value != 0) {
                String strLastError = DEXT5.LastErrorMessage();
            }
            */
            
            /*
            // 다른 파일명.확장자 
            String strSourceFile = DEXT5.LastSaveFile();
            String rtn_value = DEXT5.GetNewFileNameEx("jpg", "TIME");
            if (rtn_value.equals("")) {
                String strLastError = DEXT5.LastErrorMessage();
            }
            */
            
            /*
            // 이미지 가로(Width) 크기
            String strSourceFile = DEXT5.LastSaveFile();
            int rtn_value = DEXT5.GetImageWidth(strSourceFile);
            if (rtn_value <= 0) {
                String strLastError = DEXT5.LastErrorMessage();
            }
            */
            
            /*
            // 이미지 세로(Height) 크기
            String strSourceFile = DEXT5.LastSaveFile();
            int rtn_value = DEXT5.GetImageHeight(strSourceFile);
            if (rtn_value <= 0) {
                String strLastError = DEXT5.LastErrorMessage();
            }
            */

            
            // 이미지 Format 정보
            String strSourceFile = DEXT5.LastSaveFile();
            String rtn_value = DEXT5.GetImageFormat(strSourceFile);
            if (rtn_value == "") {
                String strLastError = DEXT5.LastErrorMessage();
            }
            
            
            /*
            // 이미지 파일 크기
            String strSourceFile = DEXT5.LastSaveFile();
            long rtn_value = DEXT5.GetImageFileSize(strSourceFile);
            if (rtn_value <= 0) {
                String strLastError = DEXT5.LastErrorMessage();
            }
            */
            
            /*
            // 파일 삭제
            String strSourceFile = DEXT5.LastSaveFile();
            int rtn_value = DEXT5.DeleteFile(strSourceFile);
            if (rtn_value != 0) {
                String strLastError = DEXT5.LastErrorMessage();
            }
            */

            
            // 원본 파일명 가져오기
            String strOriginalFileName = DEXT5.OriginalFileName();
            
        }

        // 파일 저장 경로 (물리적 경로)
        if(DEXT5.LastSaveFile().length() > 0) { 
          System.out.println("save file : [" + DEXT5.LastSaveFile() + "]");
        }

        // 파일 저장 경로 (WEB URL)
        if(DEXT5.LastSaveUrl().length() > 0) { 
            System.out.println("save url : [" + DEXT5.LastSaveUrl() + "]");
        }

        // 에러 Message 
        if(DEXT5.LastErrorMessage().length() > 0) { 
          System.out.println("DEXT5 Handler Error : [" + DEXT5.LastErrorMessage() + "]");
        }
        
        if(!result.equals("")) {
            response.setContentType("text/html");
            ServletOutputStream out = response.getOutputStream();
            out.print(result);
            out.close();
        }
        
    }
    
    /*
     * dext5uploader 이용한 파일업로드할때
     */
    
    @RequestMapping(value = "/dext5upload", method = {RequestMethod.GET, RequestMethod.POST})
    public void dext5uploadHandler(HttpServletRequest request, HttpServletResponse response) throws IOException {
   
        request.setCharacterEncoding("UTF-8");

        Raonwiz.Dext5.UploadHandler upload = new Raonwiz.Dext5.UploadHandler();
        
      //디버깅
        //Log Type 설명
        
        //- C : 일반로그 출력(System.out.println 로그 출력)
        Raonwiz.Dext5.DEXT5ParameterVo parameterVo = new Raonwiz.Dext5.DEXT5ParameterVo();
        parameterVo.setIsDebugMode(true);
        parameterVo.setLogType("C");
        parameterVo.setLogLevel("DEBUG");
        upload.SetDebugMode(parameterVo);
        
        //- L : Log4j 로그 출력
        // JDK 1.5 이하인 경우
        // 1. Log4j 로그 출력을 위한 모듈 추가 (/handler/JAVA/jdk1.5-/log4j-1.2.17.jar)
        // 2. Log4j 로그 출력을 위한 설정파일 추가 (/handler/JAVA/jdk1.5-/ 폴더의 log4j.properties 파일을 WEB-INF/classes에 적용)
        // 3. 기존 설정파일이 존재할 경우 /handler/JAVA/jdk1.5-/ 폴더의 log4j.properties 파일 내용 중 "# Dext5 Upload Log" 항목을 기존 설정파일에 적용
        // 4. 기존 설정파일의 위치가 WEB-INF/classes/log4j.properties 경로가 아닐 경우 parameterVo.setLogConfigPath("...")에 해당 경로 설정
        // 5. WEB-INF/lib에 log4j-......jar 파일이 존재하지 않을 경우 DebugMode가 false로 설정됨
        // JDK 1.6 인 경우
        // 1. Log4j 로그 출력을 위한 모듈 추가 (/handler/JAVA/jdk1.6/log4j-api-2.3.2.jar, log4j-core-2.3.2.jar, log4j-1.2-api-2.3.2.jar)
        // 2. Log4j 로그 출력을 위한 설정파일 추가 (/handler/JAVA/jdk1.6/ 폴더의 log4j2.xml 파일을 WEB-INF/classes에 적용)
        // 3. 기존 설정파일이 존재할 경우 /handler/JAVA/jdk1.6/ 폴더의 log4j2.xml 파일 내용 중 Appenders 내의 항목들과 Logger를 기존 설정파일에 적용
        // 4. WEB-INF/lib에 log4j-......jar 파일이 존재하지 않을 경우 DebugMode가 false로 설정됨
        // JDK 1.7 인 경우
        // 1. Log4j 로그 출력을 위한 모듈 추가 (/handler/JAVA/jdk1.7/log4j-api-2.12.4.jar, log4j-core-2.12.4.jar, log4j-1.2-api-2.12.4.jar)
        // 2. Log4j 로그 출력을 위한 설정파일 추가 (/handler/JAVA/jdk1.7/ 폴더의 log4j2.xml 파일을 WEB-INF/classes에 적용)
        // 3. 기존 설정파일이 존재할 경우 /handler/JAVA/jdk1.7/ 폴더의 log4j2.xml 파일 내용 중 Appenders 내의 항목들과 Logger를 기존 설정파일에 적용
        // 4. WEB-INF/lib에 log4j-......jar 파일이 존재하지 않을 경우 DebugMode가 false로 설정됨
        // JDK 1.8 이상인 경우
        // 1. Log4j 로그 출력을 위한 모듈 추가 (/handler/JAVA/jdk1.8+/log4j-api-2.17.1.jar, log4j-core-2.17.1.jar, log4j-1.2-api-2.17.1.jar)
        // 2. Log4j 로그 출력을 위한 설정파일 추가 (/handler/JAVA/jdk1.8+/ 폴더의 log4j2.xml 파일을 WEB-INF/classes에 적용)
        // 3. 기존 설정파일이 존재할 경우 /handler/JAVA/jdk1.8+/ 폴더의 log4j2.xml 파일 내용 중 Appenders 내의 항목들과 Logger를 기존 설정파일에 적용
        // 4. WEB-INF/lib에 log4j-......jar 파일이 존재하지 않을 경우 DebugMode가 false로 설정됨
        //Raonwiz.Dext5.DEXT5ParameterVo parameterVo = new Raonwiz.Dext5.DEXT5ParameterVo();
        //parameterVo.setIsDebugMode(true);
        //parameterVo.setLogType("L");
        //upload.SetDebugMode(parameterVo);
        
        Raonwiz.Dext5.UploadCompleteEventClass event = new Raonwiz.Dext5.UploadCompleteEventClass();

     // 파일 저장전 이벤트
        /*
        event.addUploadBeforeInitializeEventListenerEx(new Raonwiz.Dext5.UploadBeforeInitializeEventListenerEx() {
            public void UploadBeforeInitializeEventEx(Raonwiz.Dext5.Process.Entity.UploadEventEntity parameterEntity) {
                // 파일 저장전 발생하는 이벤트 입니다.
                // 파일에 대한 저장 경로를 변경해야 하는 경우 사용합니다.
                // 아직 클라이언트 측으로 출력을 내보내기 전이므로, 이곳에서 Response값을 변경하시면 클라이언트로 적용된 값이 전달됩니다.
                
                HttpServletRequest request = parameterEntity.getRequest(); //Request Value
                HttpServletResponse response = parameterEntity.getResponse(); //Response Value
                String newFileLocation = parameterEntity.getNewFileLocation(); //NewFileLocation Value
                String responseFileName = parameterEntity.getResponseFileName(); //ResponseFileName Value
                
                parameterEntity.setNewFileLocation(newFileLocation); //Change NewFileLocation Value
                parameterEntity.setResponseFileName(responseFileName); //Change ResponseFileName Value

                //parameterEntity.setCustomError("사용자오류");
                //parameterEntity.setCustomError("999", "사용자오류"); //Error Code를 설정하실 때에는 900이상의 3자리로 설정
            }
        });
        */
        
        // 업로드 완료전 이벤트
        /*
        event.addUploadCompleteBeforeEventListenerEx(new Raonwiz.Dext5.UploadCompleteBeforeEventListenerEx() {
            public void UploadCompleteBeforeEventEx(Raonwiz.Dext5.Process.Entity.UploadEventEntity parameterEntity) {
                // 파일 업로드 완료전 발생하는 이벤트 입니다.
                // 업로드된 파일의 DRM을 해제와 같은 파일처리 작업이 필요할 경우 사용합니다.
                // 아직 클라이언트 측으로 출력을 내보내기 전이므로, 이곳에서 Response값을 변경하시면 클라이언트로 적용된 값이 전달됩니다.
                
                HttpServletRequest request = parameterEntity.getRequest(); //Request Value
                HttpServletResponse response = parameterEntity.getResponse(); //Response Value
                String newFileLocation = parameterEntity.getNewFileLocation(); //NewFileLocation Value
                String responseFileServerPath = parameterEntity.getResponseFileServerPath(); //ResponseFileServerPath Value
                String responseFileName = parameterEntity.getResponseFileName(); //ResponseFileName Value
                String responseGroupId = parameterEntity.getResponseGroupId(); //GroupId Value
                String fileIndex = parameterEntity.getFileIndex(); //FileIndex Value - 마지막 파일은 index 뒤에 z가 붙습니다.
                
                parameterEntity.setNewFileLocation(newFileLocation); //Change NewFileLocation Value
                parameterEntity.setResponseFileServerPath(responseFileServerPath); //Change ResponseFileServerPath Value
                parameterEntity.setResponseFileName(responseFileName); //Change ResponseFileName Value
                //parameterEntity.setResponseCustomValue("ResponseCustomValue"); //Set ResponseCustomValue (특수기호(:,::,*,|,\b)가 포함되면 ResponseCustomValue가 설정되지 않습니다.)
                //parameterEntity.setResponseGroupId(GroupId); //Change GroupId Value (특수기호(:,::,*,|,\b)가 포함되면 ResponseCustomValue가 설정되지 않습니다.)

                //parameterEntity.setCustomError("사용자오류");
                //parameterEntity.setCustomError("999", "사용자오류"); //Error Code를 설정하실 때에는 900이상의 3자리로 설정
            }
        });
        */

        // 업로드 완료후 이벤트
        /*
        event.addUploadCompleteEventListenerEx(new Raonwiz.Dext5.UploadCompleteEventListenerEx() {
            public void UploadCompleteEventEx(Raonwiz.Dext5.Process.Entity.UploadEventEntity parameterEntity) {
                // 파일 업로드 완료후 발생하는 이벤트 입니다.
                
                HttpServletRequest _request = parameterEntity.getRequest(); //Request Value
                HttpServletResponse _response = parameterEntity.getResponse(); //Response Value
                String _newFileLocation = parameterEntity.getNewFileLocation(); //NewFileLocation Value
                String _responseFileServerPath = parameterEntity.getResponseFileServerPath(); //ResponseFileServerPath Value
                String _responseFileName = parameterEntity.getResponseFileName(); //ResponseFileName Value
                
                // 이미지 처리 관련 API
                Raonwiz.Dext5.Common.Dext5Image dextImage = new Raonwiz.Dext5.Common.Dext5Image();
                try {
                    //dextImage.SetJpegQuality(100); // JPG 품질 (1 ~ 100) - jdk 1.5 이상에서만 사용가능합니다.
                    //dextImage.SetAntialiasing(true); // 이미지 안티앨리어싱 활성화
                    
                    String tempFilePath = "";                
                    String sourceFileFullPath = _newFileLocation;
                    
                    // 동일 폴더에 이미지 썸네일 생성하기
                    //tempFilePath = dextImage.MakeThumbnail(sourceFileFullPath, "", 200, 0, true);

                    // 특정위치에 이미지 썸네일 생성하기
                    //String targetFileFullPath = "c:\\temp\\test_thumb.jpg";
                    //tempFilePath = dextImage.MakeThumbnailEX(sourceFileFullPath, targetFileFullPath, 200, 0, false);

                    // 이미지 포멧 변경
                    //tempFilePath = dextImage.ConvertImageFormat(sourceFileFullPath, "", "png", false, false);

                    // 이미지 크기 변환
                    //dextImage.ConvertImageSize(sourceFileFullPath, 500, 30);

                    // 비율로 이미지 크기 변환
                    //dextImage.ConvertImageSizeByPercent(sourceFileFullPath, 50);

                    // 이미지 회전
                    //dextImage.Rotate(sourceFileFullPath, 90);

                    // 이미지 워터마크
                    //String waterMarkFilePath = "c:\\temp\\dext5_logo.png";
                    //dextImage.SetImageWaterMark(sourceFileFullPath, waterMarkFilePath, "TOP", 10, "RIGHT", 10, 0);

                    // 텍스트 워터마크
                    //Raonwiz.Dext5.Common.Entity.TextWaterMark txtWaterMark = new Raonwiz.Dext5.Common.Entity.TextWaterMark("DEXT5 Upload", "굴림", 12, "#FF00FF");                
                    //dextImage.SetTextWaterMark(sourceFileFullPath, txtWaterMark, "TOP", 10, "CENTER", 10, 0, 0);

                    // 이미지 크기
                    //java.awt.Dimension size = dextImage.GetImageSize(sourceFileFullPath);
                    //int _width = size.width;
                    //int _height = size.height;
                    
                    // EXIF 추출 (Exif standard 2.2, JEITA CP-2451)
                    // jdk 1.6 이상에서만 사용가능합니다.
                    // 기능 활성화를 원하시면 1.6버전으로 컴파일된 jar를 고객센터로 요청하십시오.
                    //Raonwiz.Dext5.Common.Dext5ImageExif dextImageExif = new Raonwiz.Dext5.Common.Dext5ImageExif();
                    //Raonwiz.Dext5.Common.Exif.ExifEntity exifData = dextImageExif.GetExifData(sourceFileFullPath);

                } catch (Exception ex) {
                    String errorMsg = ex.getMessage();
                }
            }
        });
        */

        // 다운로드 경로변경 이벤트
        /*
        event.addOpenDownloadPathChangeEventListenerEx(new Raonwiz.Dext5.OpenDownloadPathChangeEventListenerEx() {
            public void OpenDownloadPathChangeEventEx(Raonwiz.Dext5.Process.Entity.UploadEventEntity parameterEntity) {
                // 파일 열기 및 다운로드시 발생하는 이벤트 입니다.
                // 파일 열기 및 다운로드 경로변경시 사용됩니다.
                HttpServletRequest request = parameterEntity.getRequest(); //Request Value
                HttpServletResponse response = parameterEntity.getResponse(); //Response Value
                String[] downloadFilePath = parameterEntity.getDownloadFilePath(); //DownloadFilePath Value
                String[] downloadFileName = parameterEntity.getDownloadFileName(); //DownloadFileName Value
                String[] downloadCustomValue = parameterEntity.getDownloadCustomValue(); //DownloadCustomValue
                
                parameterEntity.setDownloadFilePath(downloadFilePath); //Change DownloadFilePath Value

                //parameterEntity.setCustomError("사용자오류");
                //parameterEntity.setCustomError("999", "사용자오류"); //Error Code를 설정하실 때에는 900이상의 3자리로 설정
            }
        });
        */

        // 다운로드 전 이벤트
        /*
        event.addOpenDownloadBeforeInitializeEventListenerEx(new Raonwiz.Dext5.OpenDownloadBeforeInitializeEventListenerEx() {
            public void OpenDownloadBeforeInitializeEventEx(Raonwiz.Dext5.Process.Entity.UploadEventEntity parameterEntity) {
                // 파일 열기 및 다운로드시 발생하는 이벤트 입니다.
                HttpServletRequest request = parameterEntity.getRequest(); //Request Value
                HttpServletResponse response = parameterEntity.getResponse(); //Response Value
                String[] downloadFilePath = parameterEntity.getDownloadFilePath(); //DownloadFilePath Value
                String[] downloadFileName = parameterEntity.getDownloadFileName(); //DownloadFileName Value
                String[] downloadCustomValue = parameterEntity.getDownloadCustomValue(); //DownloadCustomValue
                
                parameterEntity.setDownloadFilePath(downloadFilePath); //Change DownloadFilePath Value
                parameterEntity.setDownloadFileName(downloadFileName); //Change DownloadFileName Value
                //parameterEntity.setUseDownloadServerFileName(true); //DownloadFileName 변경했을 경우 설정해야 합니다.

                //parameterEntity.setCustomError("사용자오류");
                //parameterEntity.setCustomError("999", "사용자오류"); //Error Code를 설정하실 때에는 900이상의 3자리로 설정
            }
        });
        */

        // 다운로드 완료후 이벤트
        /*
        event.addOpenDownloadCompleteEventListenerEx(new Raonwiz.Dext5.OpenDownloadCompleteEventListenerEx() {
            public void OpenDownloadCompleteEventEx(Raonwiz.Dext5.Process.Entity.UploadEventEntity parameterEntity) {
                // 파일 업로드 열기 및 다운로드시 발생하는 이벤트 입니다.
                
                HttpServletRequest request = parameterEntity.getRequest(); //Request Value
                HttpServletResponse response = parameterEntity.getResponse(); //Response Value
                String[] downloadFilePath = parameterEntity.getDownloadFilePath(); //DownloadFilePath Value
                String[] downloadFileName = parameterEntity.getDownloadFileName(); //DownloadFileName Value
                String[] downloadCustomValue = parameterEntity.getDownloadCustomValue(); //DownloadCustomValue
            }
        });
        */

        // 로그 출력 전 이벤트
        /*
        event.addLoggerEventListener(new Raonwiz.Dext5.LoggerEventListener() {
            public void LoggerEvent(Raonwiz.Dext5.Process.Entity.UploadEventEntity parameterEntity) {
                //로그 출력 전에 발생하는 이벤트 입니다.
                //로그 출력 전에 로그 정보를 변경하거나 로그 출력 여부를 변경하려는 경우 사용합니다.
                
                String strDateTime = parameterEntity.getDatetime(); //DateTime Value
                String strPathInfo = parameterEntity.getPathInfo(); //PathInfo Value
                String strLogMode = parameterEntity.getLogMode(); //LogMode Value (FATAL,ERROR,WARN,INFO,DEBUG)
                String strLogText = parameterEntity.getLogText(); //LogText Value
                
                parameterEntity.setDatetime(strDateTime); //Change DateTime Value
                parameterEntity.setPathInfo(strPathInfo); //Change PathInfo Value
                parameterEntity.setLogMode(strLogMode); //Change LogMode Value (FATAL,ERROR,WARN,INFO,DEBUG)
                parameterEntity.setLogText(strLogText); //Change LogText Value
                parameterEntity.setLogWriteFlag(true); // 로그 출력여부 설정
            }
        });
        */
        
        // 실제 업로드 할 기본경로 설정 (가상경로와 물리적 경로로 설정 가능)
        // 폴더명 제일 뒤에 .과 공백이 있다면 제거하시고 설정해 주세요.(운영체제에서 지원되지 않는 문자열입니다.)
        
        //-------------------- [설정방법1] 물리적 경로 설정 시작 --------------------//
        // 해당 설정은 PhysicalPath를 DEXT5 Upload 제품폴더\dext5uploaddata\ 를 저장 Root 경로로 설정하는 내용입니다.
//        String saveRootFolder = request.getServletPath();
        String saveRootFolder = "D:\\temp2";
//        saveRootFolder = saveRootFolder.substring(0,saveRootFolder.lastIndexOf("/"));
//        saveRootFolder = request.getSession().getServletContext().getRealPath(saveRootFolder.substring(0,saveRootFolder.lastIndexOf("/")));
        String sPathChar = java.io.File.separator;
        upload.SetPhysicalPath(saveRootFolder + sPathChar + "dext5uploaddata");

        // 임시파일 물리적 경로설정 ( SetPhysicalPath에 설정된 경로 + dext5temp )
        upload.SetTempPath(saveRootFolder + sPathChar + "dext5uploaddata" + sPathChar + "dext5temp");

        // ***************보안 설정 : 업로드 가능한 경로 설정 - 이외의 경로로 업로드 불가능***************
        String[] allowUploadDirectoryPath = {saveRootFolder};
        upload.SetAllowUploadDirectoryPath(allowUploadDirectoryPath);

        // ***************보안 설정 : 다운로드 가능한 경로 설정 - 이외의 경로에서 다운로드 불가능***************
        // request.getSession().getServletContext().getRealPath("/") 값은 샘플 동작을 위한 설정으로 실제 작업 시 제외하시면 됩니다.
//        String[] allowDownloadDirectoryPath = {saveRootFolder, request.getSession().getServletContext().getRealPath("/")};
        String[] allowDownloadDirectoryPath = {saveRootFolder};
        upload.SetAllowDownloadDirectoryPath(allowDownloadDirectoryPath);
        //-------------------- [설정방법1] 물리적 경로 설정 끝 --------------------//

        //-------------------- [설정방법2] 가상경로 설정 시작 --------------------//
        /*
        upload.SetVirtualPath("/dext5uploaddata");

        // 임시파일 물리적 경로설정 ( SetVirtualPath에 설정된 경로 + dext5temp )
        upload.SetTempPath(request.getSession().getServletContext().getRealPath("/dext5uploaddata") + java.io.File.separator + "dext5temp");

        // ***************보안 설정 : 업로드 가능한 경로 설정 - 이외의 경로로 업로드 불가능***************
        String[] allowUploadDirectoryPath = {request.getSession().getServletContext().getRealPath("/dext5uploaddata")};
        upload.SetAllowUploadDirectoryPath(allowUploadDirectoryPath);

        // ***************보안 설정 : 다운로드 가능한 경로 설정 - 이외의 경로에서 다운로드 불가능***************
        // request.getSession().getServletContext().getRealPath("/") 값은 샘플 동작을 위한 설정으로 실제 작업 시 제외하시면 됩니다.
        String[] allowDownloadDirectoryPath = {request.getSession().getServletContext().getRealPath("/dext5uploaddata"), request.getSession().getServletContext().getRealPath("/")};
        upload.SetAllowDownloadDirectoryPath(allowDownloadDirectoryPath);
        */
        //-------------------- [설정방법2] 가상경로 설정 끝 ----------------------//

        // 위에 설정된 임시파일 물리적 경로에서 불필요한 파일을 삭제 처리하는 설정 (단위: 일)
        upload.SetGarbageCleanDay(2);

        // 환경설정파일 물리적 폴더 (서버 환경변수를 사용할 경우)
        // upload.SetConfigPhysicalPath("D:\\temp");

        // 서버 구성정보중 Context Path가 있다며, 아래와 같이 설정해주세요. (SetVirtualPath 사용시만 필요)
        // upload.SetContextPath("Context Path");
        
        // upload.SetZipFileName("download.zip");

        //***************보안 설정 : 업로드 제한 확장자 설정***************
        // DEXT5 Upload는 업로드시 클라이언트와 서버에서 보안을 위하여 이중으로 확장자 체크를 합니다.
        // 서버 확장자 체크는 클라이언트에서 적용한 값으로 기본 설정되며, 
        // 아래 부분을 적용하시면, 설정한 값으로 서버에서 확장자 체크가 이루어집니다.
        // 1번째 인자는 0: 제한으로 설정, 1: 허용으로 설정, 두번째 인자는 확장자 목록 : jpg,exe (구분자,)
        // 적용에 필요 없는 확장자는 제외하시면 됩니다.
        upload.SetUploadCheckFileExtension(0, "exe,bat,sh,jsp,php");
        

        // DEXT5 Upload는 업로드시 서버에서 파일명에대한 제어를 위한 설정 기능을 제공합니다.
        // String[] tempWordList  = {"hacking"};
        // upload.SetFileBlackWordList(tempWordList);
        
        // DEXT5 Upload는 다운로드시 서버에서 보안을 위하여 확장자 체크를 합니다. (부모 경로 접근을 이용한 서버파일 다운로드 방지 등)
        // 아래 부분을 적용하시면, 설정한 값으로 서버에서 확장자 체크가 이루어집니다.
        // 1번째 인자는 0: 제한으로 설정, 1: 허용으로 설정, 두번째 인자는 확장자 목록 : jpg,exe (구분자,)
        // upload.SetDownloadCheckFileExtension(0, "exe,aspx,jsp");

        //String result = upload.Process(request, response, application, event); // 서버 이벤트 사용시 반드시 4번째 파라미터의 event 객체를 Setting 해줘야 합니다.

        //if(!result.equals("")) {
            //out.print(result);
        //}

        // Servlet으로 handler 작업을 하시려면 다음과 같이 작성해 주세요.
        // Servlet으로 구성하실 때 해당 Function의 Return Type은 void로 선언 후 return 되는 값은 반드시 없어야합니다.
        ServletContext application = request.getSession().getServletContext();

        String result = "";
        try {
            result = upload.Process(request, response, application, event); // 서버 이벤트 사용시 반드시 4번째 파라미터의 event 객체를 Setting 해줘야 합니다.
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if(!result.equals("")) {
            response.setContentType("text/html");
            ServletOutputStream out = response.getOutputStream();
            out.print(result);
            out.close();
        }
    }
}
