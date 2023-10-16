package com.example.hirajheelfoodmenu.response;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FailedResponse {
    public static CommonResponse makeFailedResponseBody(){
        log.info("COMMON FAILED RESPONSE INITIATED...");
        return CommonResponse.builder()
                .hasError(true)
                .message("Something went wrong!")
                .content(null).build();
    }
}
