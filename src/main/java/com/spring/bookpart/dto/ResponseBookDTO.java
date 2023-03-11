package com.spring.bookpart.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseBookDTO
{
    private String message;
    private Object object;
    public ResponseBookDTO(String message,Object object)
    {
        this.message=message;
        this.object=object;
    }
}
