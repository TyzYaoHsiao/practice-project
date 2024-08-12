package com.ziyao.demo.core.api.service.impl;

import com.ziyao.demo.core.api.model.req.adm.AddAdmUserReq;
import com.ziyao.demo.core.api.model.req.adm.GetAdmUserReq;
import com.ziyao.demo.core.api.model.res.adm.GetAdmUserListRes;
import com.ziyao.demo.core.api.model.res.adm.GetAdmUserRes;
import com.ziyao.demo.core.api.service.AdmService;
import com.ziyao.demo.core.constant.MessageConst;
import com.ziyao.demo.core.constant.SysConst;
import com.ziyao.demo.core.domain.UserProfile;
import com.ziyao.demo.core.entity.AdmUser;
import com.ziyao.demo.core.error.DemoException;
import com.ziyao.demo.core.repository.AdmUserRepository;
import com.ziyao.demo.core.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdmServiceImpl implements AdmService {

    private final UserProfile userProfile;
    private final AdmUserRepository admUserRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Void addAdmUser(AddAdmUserReq req) {

        AdmUser admUser = AdmUser.builder()
                .userId(req.getUserId())
                .userName(req.getUserName())
                .createTime(DateUtil.getNow())
                .createBy(userProfile.getUserId())
                .createBy(SysConst.SYSTEM)
                .build();
        admUserRepository.save(admUser);
        return null;
    }

    @Override
    public GetAdmUserRes getAdmUser(GetAdmUserReq req) {

        AdmUser admUser = admUserRepository.findByUserId(req.getUserId());
        if (admUser == null) {
            throw new DemoException(MessageConst.RtnCode.DATA_NOT_FOUND);
        }

        GetAdmUserRes getAdmUserRes = new GetAdmUserRes();
        BeanUtils.copyProperties(admUser, getAdmUserRes);
        return getAdmUserRes;
    }

    @Override
    public GetAdmUserListRes getAdmUserList() {

        List<AdmUser> sourceList = admUserRepository.findAll();
        if (CollectionUtils.isEmpty(sourceList)) {
            throw new DemoException(MessageConst.RtnCode.DATA_NOT_FOUND);
        }

        List<GetAdmUserListRes.AdmUser> admUserList = sourceList.stream()
                .map(r -> {
                    GetAdmUserListRes.AdmUser admUser = new GetAdmUserListRes.AdmUser();
                    BeanUtils.copyProperties(r, admUser);
                    return admUser;
                })
                .toList();

        return GetAdmUserListRes.builder()
                .admUserList(admUserList)
                .build();
    }
}
