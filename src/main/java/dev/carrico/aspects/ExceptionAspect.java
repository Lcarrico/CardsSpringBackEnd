package dev.carrico.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.util.NoSuchElementException;

@Component
@Aspect
@RestControllerAdvice
public class ExceptionAspect {

    private static Logger logger = Logger.getLogger(LoggingAspect.class);

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Not Found")
    @ExceptionHandler({NoSuchElementException.class})
    public void handleEntityNotFound(NoSuchElementException e){
        logger.error("Entity not found");
        logger.error(e.getMessage());
        logger.error(e.getStackTrace());
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error")
    @ExceptionHandler({SQLException.class})
    public void handleInternalServerErrorException(SQLException e){
        logger.error("SQL Exception");
        logger.error(e.getMessage());
        logger.error(e.getStackTrace());
    }
}
