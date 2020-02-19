/*
 * Copyright
 */

package com.firstproject.backend.init;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Initializer of spring boot application.
 * Using for servlet container.
 *
 * @since 0.0.1
 */
public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected final Class<?>[] getRootConfigClasses() {
        return new Class[] {SpringBootConfig.class};
    }

    @Override
    protected final Class<?>[] getServletConfigClasses() {
        return new Class[] {};
    }

    @Override
    protected final String[] getServletMappings() {
        return new String[]{"/services/*"};
    }

    @Override
    protected final String getServletName() {
        return "webservlet";
    }
}
