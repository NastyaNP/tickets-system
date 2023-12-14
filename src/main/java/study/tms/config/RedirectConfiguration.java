package study.tms.config;

import jakarta.servlet.Filter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedirectConfiguration {

    @Bean
    public FilterRegistrationBean nonApiRequestToRootPathForwarderFilterRegistrationbean() {
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter((request, response, chain) -> {
            HttpServletRequest request1 = (HttpServletRequest) request;
            if (!request1.getRequestURI().startsWith("/api/") && !request1.getRequestURI().equals("/") && !request1.getRequestURI().contains(".")) {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/");
                requestDispatcher.forward(request, response);
                return;
            }

            chain.doFilter(request, response);
        });
        return filterFilterRegistrationBean;
    }

}
