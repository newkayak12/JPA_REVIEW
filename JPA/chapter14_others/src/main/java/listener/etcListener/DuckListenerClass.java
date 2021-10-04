package listener.etcListener;

import javax.persistence.*;

public class DuckListenerClass {

    @PrePersist
    public void prePersist(Object obj){
        System.out.println("Duck.prePersist id=" + obj);
    }
    @PostPersist
    public void postPersist(Object obj){
        System.out.println("Duck.postPersist id=" + obj);
    }
    @PostLoad
    public void postLoad(Object obj){
        System.out.println("Duck.postLoad id=" + obj);
    }
    @PreRemove
    public void preRemove(Object obj){
        System.out.println("Duck.preRemove id=" + obj);
    }
    @PostRemove
    public void postRemove(Object obj){
        System.out.println("Duck.postRemove id=" + obj);
    }
}
