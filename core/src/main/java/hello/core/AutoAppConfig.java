package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) // ComponentScan으로 다 찾아서 스프링 빈으로 다 등록해주는데 그 중에서 제외할것들을 지정해주는 것
)
public class AutoAppConfig {

}
