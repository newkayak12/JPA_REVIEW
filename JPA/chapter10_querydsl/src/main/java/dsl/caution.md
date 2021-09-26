# 오류
```java
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QMember_queryDSL is a Querydsl query type for Member_queryDSL
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QMember extends EntityPathBase<Member_queryDSL> { ... }

```
- 위에서 @Generated 관련해서 패키지를 못 찾는 상황이 발생

```xml

        <dependency>
            <groupId>javax.annotation</groupId>
            <artifactId>javax.annotation-api</artifactId>
            <version>1.3.2</version>
        </dependency>
        
        
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>1.7.25</version>
        </dependency>



```
문제를 해결하기 위해서 javax.annotion을 추가 헀지만
slf4j 관련 SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".  
에러가 지속적으로 나서 추가적으로 slf4j 추가.
