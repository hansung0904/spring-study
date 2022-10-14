package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {

        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("안녕 롬복 테스트");

        String name = helloLombok.getName();
        System.out.println("helloLombok = " + helloLombok);
    }
}
