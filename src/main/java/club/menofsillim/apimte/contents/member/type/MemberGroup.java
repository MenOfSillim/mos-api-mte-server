package club.menofsillim.apimte.contents.member.type;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "멤버 그룹", value = "멤버 그룹그룹")
public enum MemberGroup {
    OWNER("오너"),
    MASTER("마스터"),
    BASIC("일반");

    private String name;

    MemberGroup(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
