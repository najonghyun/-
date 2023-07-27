package com.inet.juchamsi.domain.user.api;

import com.inet.juchamsi.domain.user.application.TenantService;
import com.inet.juchamsi.domain.user.dto.request.CreateTenantRequest;
import com.inet.juchamsi.global.api.ApiResult;
import com.inet.juchamsi.global.error.AlreadyExistException;
import com.inet.juchamsi.global.error.NotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.inet.juchamsi.global.api.ApiResult.ERROR;
import static com.inet.juchamsi.global.api.ApiResult.OK;


@RestController
@Slf4j
@RequiredArgsConstructor
@Api(tags = {"세입자 계정"})
@RequestMapping("/tenant")
public class TenantApiController {

    private final TenantService tenantService;


    @ApiOperation(value = "세입자 회원가입", notes = "세입자가 회원가입 합니다")
    @PostMapping("")
    public ApiResult<Void> createUser(@ApiParam(value = "tenant-dto") @RequestBody CreateTenantRequest request) {
        log.debug("CreateTenantRequest={}", request);

        try {
            Long userId = tenantService.createUser(request);
        }
        catch(AlreadyExistException e) {
            return ERROR("동일한 회원 정보가 존재합니다.", HttpStatus.CONFLICT);
        }
        catch(NotFoundException e) {
            return ERROR("해당하는 빌라가 존재하지 않습니다.", HttpStatus.NO_CONTENT);
        }

        return OK(null);
    }


}
