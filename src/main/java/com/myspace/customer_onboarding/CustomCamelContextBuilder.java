package com.myspace.customer_onboarding;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jbpm.config.CamelContextBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CustomCamelContextBuilder implements CamelContextBuilder {

    @Override
    public CamelContext buildCamelContext() {
        RouteBuilder routeBuilder = new RouteBuilder() {

            @Override
            public void configure() throws Exception {
                restConfiguration().component("http4");
            }
        };

        CamelContext camelContext = new DefaultCamelContext();
        try {
            camelContext.addRoutes(routeBuilder);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return camelContext;

    }

}
