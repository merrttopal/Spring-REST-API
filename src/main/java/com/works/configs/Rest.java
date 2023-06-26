package com.works.configs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class Rest {

    private Boolean status;
    private Object result;

}
