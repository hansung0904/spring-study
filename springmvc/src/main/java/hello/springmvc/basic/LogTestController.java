package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController //httpmessageBody에 데이터를 그대로 넣어버림
public class LogTestController {

//    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        System.out.println("name = " + name);
        log.info(" info log = " + name); //이렇게 사용하면 안된다. 왜? 자바언어의 특징과 관련있는데 +를 하게되면 연산이 일어나게 됨. 그러면 메모리랑 CPU를 사용하게된다.

        log.trace(" trace log= {}", name); //파라미터만 넘기기때문에 연산을 하지 않는다 위의 로그와 아주 큰 차이가 있기 때문에 제대로 알고 사용하도록 하자.
        log.debug(" debug log= {}", name);
        log.info("info log = {}", name);
        log.warn("warn log = {}", name);
        log.error("error log = {}", name);

        return "ok";
    }
}
