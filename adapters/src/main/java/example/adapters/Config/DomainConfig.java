package example.adapters.Config;

import example.DomainConfig.DomainService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = {"example"}, includeFilters = {@ComponentScan.Filter(
        type = FilterType.ANNOTATION, classes = {DomainService.class}
)})
public class DomainConfig {
}
