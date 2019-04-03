package tw.idv.josp.buildmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages={"tw.idv.josp.buildmvc.*"},
    excludeFilters={
        @Filter(type=FilterType.ANNOTATION, value= EnableWebMvc.class)
    })
public class RootConfig {

}
