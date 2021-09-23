package compositeKey.equalsNhasCodeExam;

public class Main {
    public static void main(String[] args) {
        ParentNoImpl id1 = new ParentNoImpl();
        id1.setId1("myId1");
        id1.setId2("myId2");

        ParentNoImpl id2 = new ParentNoImpl();
        id2.setId1("myId1");
        id2.setId2("myId2");

        System.out.println("before equals, hashCode override : Are these same?  _ "+id1.equals(id2));


        ParentImpl id3 = new ParentImpl();
        id3.setId1("myId1");
        id3.setId2("myId2");

        ParentImpl id4 = new ParentImpl();
        id4.setId1("myId1");
        id4.setId2("myId2");

        System.out.println("after equals, hashCode override : Are these same?  _ "+id3.equals(id4));

        // EQUALS 오버라이드 객체간의 동등성 비교를 보장하고 hashcode 오버라이드로 Hashtable 등 hash를 이용하는 곳에서도 같은 해시 값을 받도록하여 객체의 동등성을 보장한다.

        /*
            JPA에서 영속성 컨텍스트는 엔티티의 식별자를 키로 사용해서 엔티티를 관리한다. 그리고 식별자를 비교할 떄 equals와 hashCode를 사용한다. 따라서 식별자 객체의 동등서잉 보장 되지 않으면
            예상과 다른 엔티티가 조회되거나 엔티티를 찾을 수 없는 등의 영속성 컨텍스트가 엔티티를 관리하는데 심각한 문제를 발생시킨다.
         */
    }
}
