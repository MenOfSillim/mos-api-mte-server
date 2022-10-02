package club.menofsillim.apimte.contents.mainpage.domain.type;

public enum SkillType {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드"),
    DEVOPS("데브옵스"),
    DATABASE("데이터베이스"),
    INFRA("인프라"),
    SERVER("서버"),
    AI("인공지능");

    final String skillType;

    SkillType(String skillType) {
        this.skillType = skillType;
    }

    public String getSkillType() {
        return skillType;
    }
}
