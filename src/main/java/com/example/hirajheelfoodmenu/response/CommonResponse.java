package com.example.hirajheelfoodmenu.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommonResponse {
    private Boolean hasError;
    private String message;
    private String content;
}
