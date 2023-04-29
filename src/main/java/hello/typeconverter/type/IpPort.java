package hello.typeconverter.type;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * 사용자 정의 타입 컨버터를 만들기 위한 사용자 정의 타입
 * 127.0.0.1:8080 과 같은 IP,PORT를 입력하면
 * IpPort 객체로 변환하는 컨버터를 만들 것.
 */
@Getter
@EqualsAndHashCode
//롬복의 @EqualsAndHashCode를 넣으면
//모든 필드를 사용해서 equals(), hasCode()를 생성
//따라서 모든 필드의 값이 같다면 a.equals(b)의 결과가 참이됨.
//(객체 주소 비교 X, TEST에서 사용했음)
public class IpPort {
    private String ip;
    private int port;
    public IpPort(String ip, int port){
        this.ip = ip;
        this.port = port;
    }
}
