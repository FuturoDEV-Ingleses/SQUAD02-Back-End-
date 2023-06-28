package com.senai.devinadoption.exeptions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties({"suppressed", "localizedMessage", "cause", "stackTrace"})
public class HttpException extends Exception {
    String message = "";
    int status = 0;

}