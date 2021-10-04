package converter.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class BooleanToYNConverter implements AttributeConverter<Boolean,String> {
    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
        return (attribute != null && attribute)? "Y":"N";
        /*
            엔티티의 데이터를 데이터베이스 컬럼에 저장할 데이터로 변환
         */
    }

    @Override
    public Boolean convertToEntityAttribute(String dbData) {
        return "Y".equals(dbData);
    }
    /*
        데이터베이스에서 조회한 컬럼 데이터를 엔티티 데이터로 변환
     */
}
