package ik.ijse.hms.advisor;

import ik.ijse.hms.handler.AppException;
import ik.ijse.hms.util.StanderdResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideAdvisor {

    @ExceptionHandler({Exception.class})
    public ResponseEntity handleMyErrorException(Exception ex) {
        return new ResponseEntity(new StanderdResponse(500, "Error", ex.getMessage()), HttpStatus.OK);
    }


    @ExceptionHandler({AppException.class})
    public String handleMyErrorException02(AppException ex) {
        return ex.getMessage();
    }
}
