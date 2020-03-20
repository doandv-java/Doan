package haui.doan.stores.dto.request;

import haui.doan.stores.dto.dxo.DXO;

import java.io.Serializable;

public abstract class REQUEST implements Serializable {

    private static final long serialVersionUID = -896116241956430451L;

    public abstract <T extends DXO> T toDxo();

}
