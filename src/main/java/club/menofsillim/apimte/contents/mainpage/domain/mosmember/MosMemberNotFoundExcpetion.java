package club.menofsillim.apimte.contents.mainpage.domain.mosmember;

import club.menofsillim.apimte.global.common.exception.ResourceNotFoundException;

public class MosMemberNotFoundExcpetion extends ResourceNotFoundException {
    public MosMemberNotFoundExcpetion(String message) {
        super(message);
    }

    public MosMemberNotFoundExcpetion() {
        super();
    }
}
