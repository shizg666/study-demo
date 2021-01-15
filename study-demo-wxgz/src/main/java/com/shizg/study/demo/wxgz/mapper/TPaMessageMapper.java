package com.shizg.study.demo.wxgz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shizg.study.demo.wxgz.domain.entry.TPaMessage;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 项目户型表 Mapper 接口
 * </p>
 *
 * @author wenyilu
 * @since 2020-08-11
 */
public interface TPaMessageMapper extends BaseMapper<TPaMessage> {


    @Select("select t.text from t_pa_message t where t.type = #{type} and t.id > #{idNo} ORDER BY  t.id asc limit 100")
    List<String> getList(@Param("type") Integer type,@Param("idNo") Long idNo);
}
