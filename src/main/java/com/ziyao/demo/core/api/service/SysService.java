package com.ziyao.demo.core.api.service;

import com.ziyao.demo.core.api.model.req.sys.GetSysApiLogListReq;
import com.ziyao.demo.core.api.model.req.sys.GetSysExternalApiLogListReq;
import com.ziyao.demo.core.api.model.res.sys.GetSysApiLogListRes;
import com.ziyao.demo.core.api.model.res.sys.GetSysExternalApiLogListRes;

public interface SysService {

    GetSysApiLogListRes getSysApiLogList(GetSysApiLogListReq req);

    GetSysExternalApiLogListRes getSysExternalApiLogList(GetSysExternalApiLogListReq req);
}
