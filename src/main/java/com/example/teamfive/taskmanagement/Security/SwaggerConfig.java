package com.example.teamfive.taskmanagement.Security;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@OpenAPIDefinition(info = @Info(contact = @Contact(name = "yassine elouali"), 
description = "OpenApi documentation for the Back-End application", 
title = "OpenAPI Specification", version = "0.0.1"))
@SecurityScheme(name = "bearerAuth", scheme = "bearer", 
type = SecuritySchemeType.HTTP, bearerFormat = "JWT", in = SecuritySchemeIn.HEADER)
public class SwaggerConfig {

}
