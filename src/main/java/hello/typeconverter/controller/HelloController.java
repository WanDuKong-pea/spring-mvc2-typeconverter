package hello.typeconverter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * [ 타입 컨버터 ]를 설명하기 위해 만든 컨트롤러
 * 프로그램을 만들다 보면 문자 <-> 숫자 간 변환하는 경우가 상당히 많음
 * 아래 코드들은 문자 <-> 숫자 간 변환이 필요한 예시
 */
@RestController
public class HelloController{
    /**
     * req.param()으로 넘어온 값을(문자)
     * 숫자로 변환 시키는 예시
     */
    @GetMapping("/hello-v1")
    public String helloV1(HttpServletRequest request){
        //문자 타입을 조회
        String data = request.getParameter("data");
        //숫자 타입으로 변경
        Integer intValue = Integer.valueOf(data);
        System.out.println("intValue= "+intValue);
        return "ok";
    }

    /**
     * @RequestParam 사용
     * 스프링이 중간에서 타입을 자동 변환해줌
     * @ModelAttribute(클래스 객체 인스턴스 타입 맞춰짐),
     * @PathVariable(path에 들어오는 문자 값 Integer로 받기 가능)
     */
    @GetMapping("/hello-v2")
    public String helloV2(@RequestParam Integer intValue){
        System.out.println("intValue= "+intValue);
        return "ok";
    }

    //[스프링 타입 컨버터]
    //타입을 변환해야 하는 경우는 상당히 많음
    //개발자가 직접 하나하나 타입 변환 X
        //-> 스프링이 타입 변환기를 사용해서 String Integer로 변환해주기 가능
        //-> 개발자는 편리하게 해당 타입을 바로 받기 가능
    //앞에서는 문자를 숫자로 변경하는 예시를 들었지만,
    //반대로 숫자를 문자로, Boolean 타입을 숫자로 변경하는 것도 가능,
    //만약 개발자가 새로운 타입을 만들어 변환하고 싶으면..???

    //[컨버터 인터페이스]
    // public interface Converter<S, T> {T convert(S source);}
    //스프링은 확장 가능한 컨버터 인터페이스 제공
    //개발자는 스프링에 추가적인 타입 변환이 필요하면 이 컨버터 인터페이스 구현, 등록하면 됨

}
