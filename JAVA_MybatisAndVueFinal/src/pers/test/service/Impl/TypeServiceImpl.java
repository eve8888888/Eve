package pers.test.service.Impl;

import org.apache.ibatis.session.SqlSession;
import pers.test.entity.Type;
import pers.test.mapper.TypeMapper;
import pers.test.service.ITypeService;
import pers.test.util.MybatisUtil;

import java.io.IOException;
import java.util.List;

/**
 * @Author: Eve
 * @Date: 2018/12/28 20:19
 * @Version 1.0
 */
public class TypeServiceImpl implements ITypeService {
    @Override
    public List<Type> findAllType() throws IOException {
        SqlSession session = MybatisUtil.getInstance().getSqlSession();
        TypeMapper typeMapper = session.getMapper(TypeMapper.class);
        List<Type> list = typeMapper.findAllType();
        session.commit();
        session.close();
        return list;
    }
}
