package com.uniondrug.serviceedu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.uniondrug.commonutils.R;
import com.uniondrug.serviceedu.pojo.EduTeacher;
import com.uniondrug.serviceedu.pojo.vo.TeacherQuery;
import com.uniondrug.serviceedu.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author saobai
 * @since 2020-08-06
 */
@Api(description = "讲师管理")
@RestController
@RequestMapping("/serviceedu/edu-teacher")
public class EduTeacherController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EduTeacherController.class);
    //注入service
    @Autowired
    private EduTeacherService service;

    //查所有讲师
    @ApiOperation("分页展示所有讲师")
    @PostMapping("{page}/{limit}")    //
    public R pageList(
        @ApiParam(name = "page",value = "当前页码",required = true)
        @PathVariable Long page,
        @ApiParam(name = "limit",value = "每页记录",required = true)
        @PathVariable Long limit,
        //返回json格式，required=false表示支持null值【请求必须改为Post，get请求会报错】
        @RequestBody(required = false) TeacherQuery teacherQuery){
        Page<EduTeacher> page1 = new Page<>(page, limit);
        //构建条件
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        //多条件组合
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();
        //判断条件是否为空，不为空就拼接
        if(!StringUtils.isEmpty(name)){
            wrapper.eq("name",name);
        }
        if(!StringUtils.isEmpty(level.toString())){
            wrapper.eq("level",level);
        }
        if(!StringUtils.isEmpty(begin)){
            wrapper.ge("gmt_create",begin);
        }
        if(!StringUtils.isEmpty(end)){
            wrapper.le("gmt_create",end);
        }

        //将数据封装到Page对象中
        service.page(page1, wrapper);
        //从Page对象中获取值
        List<EduTeacher> records = page1.getRecords();
        long total = page1.getTotal();
        return R.ok().data("page",records).data("total",total);
    }

    //删除
    @ApiOperation("逻辑删除讲师")
    @DeleteMapping("{id}")
    public R removeTeach(@PathVariable @ApiParam("讲师ID") String id){
        boolean b = service.removeById(id);
        return R.ok();
    }

    //新增
    @ApiOperation("新增讲师")
    @PostMapping
    public R save(@ApiParam(name = "teach",value = "讲师对象",required = false)
                      @RequestBody EduTeacher eduTeacher){
        boolean save = service.save(eduTeacher);
        if(save){
            return R.ok();
        }else {
            return R.error();
        }
    }

    //根据id插讲师
    @ApiOperation("根据id查讲师")
    @GetMapping("getTeacher/{id}")
    public R findOne(@PathVariable @ApiParam("讲师ID")String id){
        EduTeacher teacher = service.getById(id);
        return R.ok().data("teacher",teacher);
    }

    //修改讲师
    @ApiOperation("修改讲师")
    @PostMapping("updateTeacher")
    public R update(@RequestBody EduTeacher eduTeacher){
        boolean b = service.updateById(eduTeacher);
        if(b){
            return R.ok();
        }else {
            return R.error();
        }
    }
}

