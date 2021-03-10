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

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        ComponentContext context = new ComponentContext();
        context.init(servletContext);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
//        ComponentContext context = ComponentContext.getInstance();
//        context.destroy();
        ComponentContext.getInstance().destroy();
    }

}
