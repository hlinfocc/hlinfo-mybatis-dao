package net.hlinfo.mybatis.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import net.hlinfo.mybatis.dao.MybatisDao;


@Repository
public class MybatisDaoImpl implements MybatisDao {
	private SqlSessionTemplate sqlSessionTemplate;

	public MybatisDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		super();
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public <T> List<T> queryList(String mybitsSqlId, Class<T> classOfT, Object object) {
		return this.sqlSessionTemplate.selectList(mybitsSqlId,object);
	}

	@Override
	public <T> List<T> queryList(String mybitsSqlId, Class<T> classOfT, Map<String, Object> map) {
		return this.sqlSessionTemplate.selectList(mybitsSqlId, map);
	}

	@Override
	public <T> List<T> queryList(String mybitsSqlId,Class<T> classOfT) {
		return this.sqlSessionTemplate.selectList(mybitsSqlId);
	}

	@Override
	public int count(String mybitsSqlId) {
		Integer qc = this.sqlSessionTemplate.selectOne(mybitsSqlId);
       return qc==null?0:qc;
	}

	@Override
	public int count(String mybitsSqlId, Object object) {
		Integer qc = this.sqlSessionTemplate.selectOne(mybitsSqlId,object);
       return qc==null?0:qc;
	}

	@Override
	public <T> T find(String mybitsSqlId, Class<T> classOfT) {
		return this.sqlSessionTemplate.selectOne(mybitsSqlId);
	}

	@Override
	public <T> T find(String mybitsSqlId, Class<T> classOfT, Object object) {
		return this.sqlSessionTemplate.selectOne(mybitsSqlId,object);
	}

	@Override
	public <T> T find(String mybitsSqlId, Class<T> classOfT, Map<String,Object> map) {
		return this.sqlSessionTemplate.selectOne(mybitsSqlId,map);
	}

	@Override
	public boolean insert(String mybitsSqlId, Object object) {
		int rs = this.sqlSessionTemplate.insert(mybitsSqlId,object);
		return rs>0?true:false;
	}
	
	@Override
	public boolean insert(String mybitsSqlId) {
		int rs = this.sqlSessionTemplate.insert(mybitsSqlId);
		return rs>0?true:false;
	}

	@Override
	public boolean update(String mybitsSqlId, Object object) {
		int rs = this.sqlSessionTemplate.update(mybitsSqlId,object);
       return rs>0?true:false;
	}
	
	@Override
	public boolean update(String mybitsSqlId) {
		int rs = this.sqlSessionTemplate.update(mybitsSqlId);
       return rs>0?true:false;
	}

	@Override
	public boolean delete(String mybitsSqlId, Object object) {
		int rs = this.sqlSessionTemplate.delete(mybitsSqlId, object);
		return rs>0?true:false;
	}

	@Override
	public boolean delete(String mybitsSqlId) {
		int rs = this.sqlSessionTemplate.delete(mybitsSqlId);
		return rs>0?true:false;
	}

}
