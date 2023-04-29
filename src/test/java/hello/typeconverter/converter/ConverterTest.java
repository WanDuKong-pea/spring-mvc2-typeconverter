package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 만든 타입 컨버터인
 * IntegerToString, StringToInteger, StringToIpPortConverter 를
 * 테스트 해보자
 */
class ConverterTest {
    @Test
    void StringToInteger(){
        StringToIntegerConverter converter = new StringToIntegerConverter();
        Integer result = converter.convert("10");
        Assertions.assertThat(result).isEqualTo(10);
    }

    @Test
    void IntegerToString(){
        IntegerToString converter = new IntegerToString();
        String result = converter.convert(10);
        Assertions.assertThat(result).isEqualTo("10");
    }

    @Test
    void StringToIpPort(){
        StringToIpPortConverter converter = new StringToIpPortConverter();
        String source = "127.0.0.1:8080";
        IpPort result = converter.convert(source);
        Assertions.assertThat(result).isEqualTo(new IpPort("127.0.0.1",8080));
    }

    @Test
    void IpPortToString(){
        IpPortToStringConverter converter = new IpPortToStringConverter();
        IpPort source = new IpPort("127.0.0.1",8080);
        String result = converter.convert(source);
        Assertions.assertThat(result).isEqualTo("127.0.0.1:8080");
    }
}
