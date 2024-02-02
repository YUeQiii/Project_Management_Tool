package io.yueqi.pmtool.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProjectException {
    public PorjectIdException(String message){
        super(message);

    }

}
