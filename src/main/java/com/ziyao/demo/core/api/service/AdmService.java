package com.ziyao.demo.core.api.service;

import com.ziyao.demo.core.api.model.req.adm.AddAdmUserReq;
import com.ziyao.demo.core.api.model.req.adm.GetAdmUserReq;
import com.ziyao.demo.core.api.model.res.adm.GetAdmUserListRes;
import com.ziyao.demo.core.api.model.res.adm.GetAdmUserRes;

public interface AdmService {

    Void addAdmUser(AddAdmUserReq req);

    GetAdmUserListRes getAdmUserList();

    GetAdmUserRes getAdmUser(GetAdmUserReq req);
}
