package com.heypli.productsvc.errorhandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.heypli.productsvc.common.constant.RespCode;
import com.heypli.productsvc.common.response.CommonResponse;
import com.heypli.productsvc.exception.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class ErrorExceptionHandler {

    private final ObjectMapper objectMapper;

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<CommonResponse> handleException(HttpServletRequest request, HttpServletResponse response,
                                                          ProductNotFoundException exception) {
        log.error("########## ProductNotFoundException");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CommonResponse(RespCode.NO_PRODUCT, exception.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CommonResponse> handleException(HttpServletRequest request, HttpServletResponse response,
                                                          Exception exception) {
        log.error("####### COMMON ERROR: " + exception.getMessage());
        return ResponseEntity.status(response.getStatus()).body(new CommonResponse(RespCode.ERROR, exception.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CommonResponse> handleException(HttpServletRequest request, HttpServletResponse response,
                                                          MethodArgumentNotValidException exception) {
        log.error("######## MethodArgumentNotValidException : " + exception);
        List<ObjectError> allErrors = exception.getBindingResult().getAllErrors();
        Map<String, String> errors = new HashMap<>();

        for(ObjectError err: allErrors) {
            if(FieldError.class.isAssignableFrom(err.getClass())) {
                log.error("FIELD ERROR");
                errors.put(((FieldError) err).getField(), err.getDefaultMessage());
            } else {
                log.error("ELSE ");
                errors.put(err.getObjectName(), err.getDefaultMessage());
            }
        }

        String errMsg = "";

        try {
            errMsg = objectMapper.writeValueAsString(errors);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
        }


        return ResponseEntity.status(response.getStatus()).body(new CommonResponse(RespCode.ERROR, errMsg));

    }
}
