package com.uniondrug.serviceedu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.uniondrug.serviceedu.pojo.EduTeacher;
import com.uniondrug.serviceedu.mapper.EduTeacherMapper;
import com.uniondrug.serviceedu.pojo.vo.TeacherQuery;
import com.uniondrug.serviceedu.service.EduTeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author saobai
 * @since 2020-08-06
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {

}
