package controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import service.DataServiceImpl;
import sun.rmi.runtime.Log;

@Controller
public class ExceptionHandlerController {
    private static final Logger LOG = LoggerFactory.getLogger(ExceptionHandlerController.class);

    @ExceptionHandler(RestException.class)
    public @ResponseBody
    String handleException(RestException restException){
        LOG.error("Ошибка: "+restException.getMessage(),restException);
        return "Ошибка: "+restException.getMessage();
    }
}
