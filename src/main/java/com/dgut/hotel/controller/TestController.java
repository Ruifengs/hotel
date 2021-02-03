package com.dgut.hotel.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dgut.hotel.common.api.CommonPage;
import com.dgut.hotel.common.api.CommonResult;
import com.dgut.hotel.model.Test;
import com.dgut.hotel.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ruifeng
 * @since 2021-02-03
 */
@RestController
@RequestMapping("/hotel")
@Api("测试")
public class TestController {

    public static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private TestService testService;
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ApiOperation(value = "分页查询列表")
    @ResponseBody
    public CommonResult<CommonPage<Test>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                               @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                               @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {

        Page<Test> page = new Page<>(pageNum, pageSize);
        Page<Test> pageResult = testService.page(page);
        return CommonResult.success(CommonPage.restPage(pageResult));
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ApiOperation(value = "新增")
    @ResponseBody
    public CommonResult<Test> create(@RequestBody Test test) {
        CommonResult<Test> commonResult;
        boolean result = testService.save(test);
        if (result) {
            commonResult = CommonResult.success(test);
            LOGGER.debug("createTest success:{}", test);
        } else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("createTest failed:{}", test);
        }
        return commonResult;
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ApiOperation(value = "删除")
    @ResponseBody
    public CommonResult<String> delete(@PathVariable Long id) {
        boolean result = testService.removeById(id);
        if (result) {
            LOGGER.debug("deleteTest success :id={}", id);
            return CommonResult.success(null);
        } else {
            LOGGER.debug("deleteTest failed :id={}", id);
            return CommonResult.failed("操作失败");
        }
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation(value = "更新")
    @ResponseBody
    public CommonResult<Test> update(@RequestBody Test test) {
        CommonResult<Test> commonResult;
        boolean result = testService.updateById(test);
        if (result) {
            commonResult = CommonResult.success(test);
            LOGGER.debug("updateTest success:{}", test);
        } else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("updateTest failed:{}", test);
        }
        return commonResult;
    }

    @ApiOperation("获取指定id的用户")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<Test> brand(@PathVariable("id") Long id) {
        return CommonResult.success(testService.getById(id));
    }
    
}

