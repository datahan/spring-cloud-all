package com.datahan.server.amager.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Jim Han
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Greeting {

    private long id;
    private String content;

}
