package listener.etcListener;

import javax.persistence.*;

@Table(name = "DUCK_LISTENER")
@Entity
@EntityListeners(DuckListenerClass.class)
//@ExcludeDefaultListeners
//@ExcludeSuperclassListeners
// 위의 두 개는 조금 더 세밀한 설정이다.
public class DuckListener {
    @Id
    @GeneratedValue
    public Long id;

}
