package com.ziyao.demo.core.api.service.impl;

import com.ziyao.demo.core.api.model.req.sys.GetSysApiLogListReq;
import com.ziyao.demo.core.api.model.req.sys.GetSysExternalApiLogListReq;
import com.ziyao.demo.core.api.model.res.sys.GetSysApiLogListRes;
import com.ziyao.demo.core.api.model.res.sys.GetSysExternalApiLogListRes;
import com.ziyao.demo.core.api.service.SysService;
import com.ziyao.demo.core.constant.MessageConst;
import com.ziyao.demo.core.entity.SysApiLog;
import com.ziyao.demo.core.entity.SysExternalApiLog;
import com.ziyao.demo.core.error.DemoException;
import com.ziyao.demo.core.repository.SysApiLogRepository;
import com.ziyao.demo.core.repository.SysExternalApiLogRepository;
import com.ziyao.demo.core.util.DateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SysServiceImpl implements SysService {

    private final SysApiLogRepository sysApiLogRepository;
    private final SysExternalApiLogRepository sysExternalApiLogRepository;

    @Override
    public GetSysApiLogListRes getSysApiLogList(GetSysApiLogListReq req) {

        List<SysApiLog> sysApiLogList =  sysApiLogRepository.findAllByOrderByIdDesc();
        if (CollectionUtils.isEmpty(sysApiLogList)){
            throw new DemoException(MessageConst.RtnCode.DATA_NOT_FOUND);
        }

        return GetSysApiLogListRes.builder()
                .sysApiLogList(sysApiLogList.stream()
                        .map(r -> {
                            GetSysApiLogListRes.SysApiLog sysApiLog = new GetSysApiLogListRes.SysApiLog();
                            BeanUtils.copyProperties(r, sysApiLog);
                            sysApiLog.setCreateTime(DateUtil.formatDateToStr(r.getCreateTime(), DateUtil.BASIC_FORMAT));
                            return sysApiLog;
                        })
                        .collect(Collectors.toList()))
                .build();
    }

    @Override
    public GetSysExternalApiLogListRes getSysExternalApiLogList(GetSysExternalApiLogListReq req) {

        List<SysExternalApiLog> sysExternalApiLogList =  sysExternalApiLogRepository.findAllByOrderByIdDesc();
        if (CollectionUtils.isEmpty(sysExternalApiLogList)){
            throw new DemoException(MessageConst.RtnCode.DATA_NOT_FOUND);
        }

        return GetSysExternalApiLogListRes.builder()
                .sysExternalApiLogList(sysExternalApiLogList.stream()
                        .map(r -> {
                            GetSysExternalApiLogListRes.SysExternalApiLog sysExternalApiLog = new GetSysExternalApiLogListRes.SysExternalApiLog();
                            BeanUtils.copyProperties(r, sysExternalApiLog);
                            sysExternalApiLog.setCreateTime(DateUtil.formatDateToStr(r.getCreateTime(), DateUtil.BASIC_FORMAT));
                            return sysExternalApiLog;
                        })
                        .collect(Collectors.toList()))
                .build();
    }
}
