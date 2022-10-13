package hello.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE) // type이면 class레벨에 붙는거
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {
}
