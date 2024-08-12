package com.ziyao.demo.core.api.controller;

import com.ziyao.demo.core.api.model.req.RequestEntity;
import com.ziyao.demo.core.api.model.req.adm.AddAdmUserReq;
import com.ziyao.demo.core.api.model.req.adm.GetAdmUserReq;
import com.ziyao.demo.core.api.model.res.ResponseEntity;
import com.ziyao.demo.core.api.model.res.adm.GetAdmUserListRes;
import com.ziyao.demo.core.api.model.res.adm.GetAdmUserRes;
import com.ziyao.demo.core.api.service.AdmService;
import com.ziyao.demo.core.controller.BaseController;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/adm")
@RequiredArgsConstructor
public class AdmController extends BaseController {

    private final AdmService admService;

    @PostMapping("/addAdmUser")
    @Operation(summary = "新增使用者", description = "新增使用者")
    public ResponseEntity<Void> addAdmUser(@RequestBody @Valid RequestEntity<AddAdmUserReq> req) {
        return success(admService.addAdmUser(req.getParams()));
    }

    @PostMapping("/getAdmUserList")
    @Operation(summary = "取得使用者清單", description = "取得使用者清單")
    public ResponseEntity<GetAdmUserListRes> getAdmUserList(@RequestBody @Valid RequestEntity req) {
        return success(admService.getAdmUserList());
    }

    @PostMapping("/getAdmUser")
    @Operation(summary = "取得使用者", description = "取得使用者")
    public ResponseEntity<GetAdmUserRes> getAdmUser(@RequestBody @Valid RequestEntity<GetAdmUserReq> req) {
        return success(admService.getAdmUser(req.getParams()));
    }
}
