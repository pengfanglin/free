package com.free.controller.app;

import com.fanglin.common.annotation.NoToken;
import com.fanglin.common.annotation.Token;
import com.fanglin.common.core.others.Ajax;
import com.fanglin.common.util.UploadUtils;
import com.free.enums.others.CodeTypeEnum;
import com.free.service.app.AppCommonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 其他接口控制器
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:36
 **/
@RestController
@RequestMapping("/app/common/")
@Token("user")
@Api(value = "/app/common/", tags = {"APP-公共"})
public class AppCommonController {

    @Autowired
    AppCommonService commonService;

    @ApiOperation("上传多个文件")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "files", value = "图片文件", required = true),
        @ApiImplicitParam(name = "path", value = "保存路径", defaultValue = "/files/others")
    })
    @PostMapping("uploadFiles")
    public Ajax uploadFiles(@RequestParam("files") MultipartFile[] files, String path) {
        return UploadUtils.uploadFiles(files, false, path);
    }

    @ApiOperation("区域缓存")
    @PostMapping("regionCache")
    @NoToken
    public Ajax<List<String>> regionCache() {
        return Ajax.ok(commonService.regionCache());
    }

    @ApiOperation("发送验证码")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "mobile", value = "手机号", required = true),
        @ApiImplicitParam(name = "type", value = "验证码类型", required = true)
    })
    @PostMapping("sendCode")
    public Ajax sendCode(@RequestParam String mobile, @RequestParam CodeTypeEnum type) {
        commonService.sendCode(mobile, type.toString());
        return Ajax.ok("发送成功");
    }

    @ApiOperation("发送测试验证码")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "mobile", value = "手机号", required = true),
        @ApiImplicitParam(name = "type", value = "验证码类型", required = true)
    })
    @PostMapping("sendCodeTest")
    public Ajax sendCodeTest(@RequestParam String mobile, @RequestParam CodeTypeEnum type) {
        String code = commonService.sendTestCode(mobile, type.toString());
        return Ajax.ok(code);
    }
}
