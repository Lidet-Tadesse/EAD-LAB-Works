package com.carelink.Manos.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, Model model) {
        // Log the error details
        e.printStackTrace();

        // Add the error message to the model to display in the error page
        model.addAttribute("errorMessage", "Something went wrong. Please try again later.");
        return "error"; // This will return error.html
    }
}
