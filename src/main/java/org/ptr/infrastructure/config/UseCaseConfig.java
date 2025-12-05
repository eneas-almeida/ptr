package org.ptr.infrastructure.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for use case beans.
 * Ensures all use cases are scanned and registered as Spring beans.
 */
@Configuration
@ComponentScan(basePackages = {
        "org.ptr.application.usecase",
        "org.ptr.infrastructure.client",
        "org.ptr.infrastructure.repository"
})
public class UseCaseConfig {
}