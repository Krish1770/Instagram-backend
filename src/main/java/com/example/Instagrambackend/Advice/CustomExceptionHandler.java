package com.example.Instagrambackend.Advice;

import com.example.Instagrambackend.DTO.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


    @ControllerAdvice
    public class CustomExceptionHandler {


//@ResponseStatus(HttpStatus.BAD_REQUEST)
//        @ExceptionHandler(MethodArgumentNotValidException.class)
//        public Map<String,String> handleInvalidArgument(MethodArgumentNotValidException ex)
//        {
//            Map<String,String>errorMap=new HashMap<>();
//            ex.getBindingResult().getFieldErrors().forEach(error->
//            {
//                errorMap.put(error.getField(), error.getDefaultMessage());
//            });
//
//            return errorMap;
//        }


        @ExceptionHandler(UserNotFoundException.class)
        public ResponseEntity<ResponseDTO> exception(UserNotFoundException exception)
        {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDTO(HttpStatus.NOT_FOUND,"Email Not found exception",""));
        }

}
