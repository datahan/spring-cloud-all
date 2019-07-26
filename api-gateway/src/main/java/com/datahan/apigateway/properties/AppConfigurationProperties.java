package com.datahan.apigateway.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Jim Han
 */
@Data
@Component
@ConfigurationProperties("app.httpbin")
public class AppConfigurationProperties {

    private String uri = "https://example.org";

}
