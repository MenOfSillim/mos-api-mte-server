package club.menofsillim.apimte.global.common.enums;

public enum SkillType {
    BACKEND("SKILL_BACK_END", "백엔드"),
    FRONTEND("SKILL_FRONT_END", "프론트엔드"),
    DEVOPS("SKILL_DEVOPS", "데브옵스"),
    DBA("SKILL_DBA", "데이터베이스");

    private final String skillType;
    private final String skillTypeName;

    public String getSkillType() {
        return skillType;
    }

    public String getSkillTypeName() {
        return skillTypeName;
    }

    SkillType(String skillType, String skillTypeName) {
        this.skillType = skillType;
        this.skillTypeName = skillTypeName;
    }
}
