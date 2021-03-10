package org.geektimes.projects.user.web.listener;

import org.geektimes.context.ComponentContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import static org.geektimes.context.ComponentContext.CONTEXT_NAME;

/**
 * {@link ComponentContext} 初始化器
 * ContextLoaderListener
 */
public class ComponentContextInitializerListener implements ServletContextListener {

    private ServletContext servletContext;

    private ComponentContext context;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        this.servletContext = sce.getServletContext();
        this.context = new ComponentContext();
        ComponentContext.setServletContext(servletContext);
        servletContext.setAttribute(CONTEXT_NAME, context);
        context.init(servletContext);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        context.destroy();
    }

}
