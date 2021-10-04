package converter.entity;

import converter.converter.BooleanToYNConverter;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter

@Table(name = "MEMBER_CONVERTER")
@Entity
//@Converter(autoApply = true) //모든 boolean에 컨버터를 사용하려면 이와 같은 옵션을 적용하면 된다.
    @Convert(converter = BooleanToYNConverter.class, attributeName="vip")
/*
    converter : 사용할 컨버터를 지정
    attributeName : 컨버터를 적용할 필드를 지정
    disableConversion : 글로벌 컨버터나 상속받은 컨버터를 사용하지 않는다.
 */
public class MemberConverter {
    @Id
    @GeneratedValue
    private Long id;

    private String username;

//    @Convert(converter = BooleanToYNConverter.class)
    private boolean vip;
}
