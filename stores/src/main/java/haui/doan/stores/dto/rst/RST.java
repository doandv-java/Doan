package haui.doan.stores.dto.rst;

import haui.doan.stores.dto.response.RESPONSE;

import java.io.Serializable;

public abstract class RST implements Serializable {

    private static final long serialVersionUID = 5116764857472682572L;

    public abstract <T extends RESPONSE> T toResponse();
}
