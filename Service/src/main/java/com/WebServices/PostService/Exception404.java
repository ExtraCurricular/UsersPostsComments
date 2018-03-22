package com.WebServices.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class Exception404 extends RuntimeException{
    public Exception404(String path, long id){
        super(String.format("%s with id %s was not found", path, id));
    }
}