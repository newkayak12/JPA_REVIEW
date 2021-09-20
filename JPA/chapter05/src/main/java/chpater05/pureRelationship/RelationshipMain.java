package chpater05.pureRelationship;

public class RelationshipMain {
    public static void main(String[] args) {
//        순수한 객체 간의 연관 관계
        Member member1 = new Member("member1", "회원1");
        Member member2 = new Member("member2", "회원2");
        Team team1 = new Team("team1", "팀1");

        member1.setTeam(team1);
        member2.setTeam(team1);

        Team findTeam = member1.getTeam();
    }
}
