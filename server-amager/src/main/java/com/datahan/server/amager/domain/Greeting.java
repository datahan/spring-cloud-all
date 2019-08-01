package com.datahan.server.amager.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jim Han
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Greeting {

    private long id;
    private String content;

}
