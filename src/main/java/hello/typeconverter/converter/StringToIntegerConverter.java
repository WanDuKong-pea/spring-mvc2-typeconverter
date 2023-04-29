package hello.typeconverter.converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

/**
 * 문자를 숫자로 바꾸는 타입 컨버터
 * implements Converter<변환전 타입, 변환할 타입>
 * Converter가 많기 떄문에 import시 주의하기
 */
@Slf4j
public class StringToIntegerConverter implements Converter<String, Integer> {
    @Override
    public Integer convert(String source) {
        log.info("convert source={}",source);
        return Integer.valueOf(source);
    }
}
