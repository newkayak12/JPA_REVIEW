package jpabook.start.chpater05.pureRelationship;

public class Member {
    private String id;
    private String userName;
    private Team team;
    //팀과 참조 관계를 갖는다.

    public Member(String id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public void setTeam(Team team){
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }
}


