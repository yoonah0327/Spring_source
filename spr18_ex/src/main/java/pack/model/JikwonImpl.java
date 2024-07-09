package pack.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import pack.mybatis.SqlMapConfig;

@Repository
public class JikwonImpl implements JikwonInter {
	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();

	@Override
	public List<JikwonDto> selectDataAll() {
		SqlSession sqlSession = factory.openSession();
		List<JikwonDto> list = null;

		try {
			SqlMapperInter mapperInter = (SqlMapperInter) sqlSession.getMapper(SqlMapperInter.class);
			list = mapperInter.selectDataAll();
		} catch (Exception e) {
			System.out.println("selectDataAll err: " + e);
		} finally {
			if (sqlSession != null)
				sqlSession.close();
		}

		return list;
	}

	@Override
	public List<JikwonDto> selectDataBuser() {
		SqlSession sqlSession = factory.openSession();
		List<JikwonDto> list = null;

		try {
			SqlMapperInter mapperInter = (SqlMapperInter) sqlSession.getMapper(SqlMapperInter.class);
			list = mapperInter.selectDataBuser();
		} catch (Exception e) {
			System.out.println("selectDataBuser err: " + e);
		} finally {
			if (sqlSession != null)
				sqlSession.close();
		}

		return list;
	}

	@Override
	public List<JikwonDto> selectDataBuserMax() {
		SqlSession sqlSession = factory.openSession();
		List<JikwonDto> list = null;

		try {
			SqlMapperInter mapperInter = (SqlMapperInter) sqlSession.getMapper(SqlMapperInter.class);
			list = mapperInter.selectDataBuserMax();
		} catch (Exception e) {
			System.out.println("selectDataBuserMax err: " + e);
		} finally {
			if (sqlSession != null)
				sqlSession.close();
		}

		return list;
	}
}
