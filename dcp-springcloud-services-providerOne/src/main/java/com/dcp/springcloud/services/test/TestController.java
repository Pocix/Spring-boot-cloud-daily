package com.dcp.springcloud.services.test;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dcp.springcloud.mybatis.model.UserInfo;
import com.dcp.springcloud.services.dao.UserInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "测试接口", description = "基于SpringCloud的Restful测试接口" )  
@RestController
public class TestController {

	private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;
    
    @Autowired
    private UserInfoService userInfoService;

    @ApiOperation(value="两个值求和", notes="根据参数a、b求两值的和",produces = "application/json")
	@ApiImplicitParams({ 
		@ApiImplicitParam(paramType="query",name = "a", value = "参数A", required = true, dataType = "Integer"),
		@ApiImplicitParam(paramType="query",name = "b", value = "参数B", required = true, dataType = "Integer") })
    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    @ResponseBody
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
        ServiceInstance instance = client.getLocalServiceInstance();
        Integer r = a + b;
        logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
        userInfoService.getAllUser();
        return r;
    }
    
    @ApiOperation(value="获取名称", notes="根据参数,查询名称",produces = "application/json")
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "name", value = "名称", required = true, dataType = "String",paramType="query")
	})
    @ResponseBody
    @RequestMapping(value = "/getName" ,method = RequestMethod.GET)
    public String getName(@RequestParam String name) {
        return "get Name :"+name;
    }
    
    @ApiOperation(value="获取用户", notes="根据名称,模糊查询相关用户",produces = "application/json")
	@ApiImplicitParam(paramType="path",name = "name", value = "名称", required = false, dataType = "String")
    @ResponseBody
    @RequestMapping(value = "/getAllUser/{name}" ,method = RequestMethod.GET)
    public List<UserInfo> getAllUser(@PathVariable String name) {
        return userInfoService.getAllUser();
    }
}
