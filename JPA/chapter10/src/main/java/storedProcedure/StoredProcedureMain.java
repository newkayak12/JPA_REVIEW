package storedProcedure;

import javax.persistence.*;

public class StoredProcedureMain {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
    static EntityManager em = emf.createEntityManager();
    static EntityTransaction tx = em.getTransaction();

    public static void proce(){
//        프로시저...
        StoredProcedureQuery spq = em.createStoredProcedureQuery("proc_multiple");
        spq.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
//        spq.registerStoredProcedureParameter("inParam", Integer.class, ParameterMode.IN);

        spq.registerStoredProcedureParameter(2, Integer.class, ParameterMode.OUT);
//        spq.registerStoredProcedureParameter("outParam", Integer.class, ParameterMode.OUT);
// 이와 같이 파라미터에 순서 뿐만 아니라 이름도 사용할 수 있다.
        spq.setParameter(1,100);
        spq.execute();

        Integer out = (Integer) spq.getOutputParameterValue(2);
        System.out.println("out  :"+out);
    }

}
