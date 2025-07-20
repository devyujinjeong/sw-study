package com.dbwls.cqrs.exception;

import com.dbwls.cqrs.common.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClient;

@RestControllerAdvice
// 전역적인 예외를 받아주는 클래스?
public class GlobalExceptionHandler {

    private final RestClient.Builder builder;

    public GlobalExceptionHandler(RestClient.Builder builder) {
        this.builder = builder;
    }


    /* 내가 작성한 코드에서 예외가 발생하는 경우임 */
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiResponse> handleBusinessException(BusinessException e){
        ErrorCode errorCode = e.getErrorCode();
        //데이터 부분은 비어있기 때문에!
        ApiResponse<Void> response
                = ApiResponse.failure(errorCode.getCode(), errorCode.getMessage());

        return new ResponseEntity<>(response,errorCode.getHttpStatus());
    }

    /* 입력 값 검증 */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Void>> handleValidationException(MethodArgumentNotValidException e){
        ErrorCode errorCode = ErrorCode.VALIDATION_ERROR;
        StringBuilder errorMessage = new StringBuilder(errorCode.getMessage());

        /* 어떤 필드에서 어떤 오류가 나는지 */
        for(FieldError error : e.getBindingResult().getFieldErrors()){
            errorMessage.append(String.format("[%s : %s]", error.getField(), error.getDefaultMessage()));
        }

        ApiResponse<Void> response
                = ApiResponse.failure(errorCode.getCode(), errorMessage.toString());

        return new ResponseEntity<>(response,errorCode.getHttpStatus());
    }

    /* 상위 타입의 예외 하나 선언하기 : 위의 2가지 예외를 제외하고선 만들면 되는 것*/
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleException(){
        ErrorCode errorCode = ErrorCode.INTERNAL_SERVER_ERROR;

        ApiResponse<Void> response
                = ApiResponse.failure(errorCode.getCode(), errorCode.getMessage());

        return new ResponseEntity<>(response,errorCode.getHttpStatus());
    }

}
