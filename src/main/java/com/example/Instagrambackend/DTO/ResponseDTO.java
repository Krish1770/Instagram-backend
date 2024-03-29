package com.example.Instagrambackend.DTO;

import org.springframework.http.HttpStatus;

public class ResponseDTO {
        private HttpStatus httpStatus;
        public ResponseDTO(){
        }

        public ResponseDTO(HttpStatus httpStatus, String message, Object data) {
            this.httpStatus = httpStatus;
            this.message = message;
            this.data = data;
        }

        private String message;

        public HttpStatus getHttpStatus() {
            return httpStatus;
        }

        public void setHttpStatus(HttpStatus httpStatus) {
            this.httpStatus = httpStatus;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        private Object data;

    }
