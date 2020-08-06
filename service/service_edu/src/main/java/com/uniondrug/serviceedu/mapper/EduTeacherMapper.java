package com.uniondrug.serviceedu.mapper;

import com.uniondrug.serviceedu.pojo.EduTeacher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 讲师 Mapper 接口
 * </p>
 *
 * @author saobai
 * @since 2020-08-06
 */
@Repository
@Mapper
public interface EduTeacherMapper extends BaseMapper<EduTeacher> {

}
