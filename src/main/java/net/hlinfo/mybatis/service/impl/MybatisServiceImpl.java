package net.hlinfo.mybatis.service.impl;

import java.util.List;
import java.util.Map;


import org.springframework.stereotype.Service;

import net.hlinfo.mybatis.dao.MybatisDao;
import net.hlinfo.mybatis.opt.HlinfoDriverClassConfig;
import net.hlinfo.opt.Func;
import net.hlinfo.opt.QueryResult;
import net.hlinfo.opt.pager.MPager;
import net.hlinfo.mybatis.service.MybatisService;

@Service
public class MybatisServiceImpl implements MybatisService {
    private MybatisDao mybatisDao;
    private HlinfoDriverClassConfig driverClassConfig;
	public MybatisDao getMybatisDao() {
		return mybatisDao;
	}
	public void setMybatisDao(MybatisDao mybatisDao) {
		this.mybatisDao = mybatisDao;
	}
	public HlinfoDriverClassConfig getDriverClassConfig() {
		return driverClassConfig;
	}
	public void setDriverClassConfig(HlinfoDriverClassConfig driverClassConfig) {
		this.driverClassConfig = driverClassConfig;
	}
	public MybatisServiceImpl(MybatisDao mybatisDao) {
		super();
		this.mybatisDao = mybatisDao;
	}
	public MybatisServiceImpl(MybatisDao mybatisDao,HlinfoDriverClassConfig driverClassConfig) {
		super();
		this.mybatisDao = mybatisDao;
		this.driverClassConfig = driverClassConfig;
	}

	@Override
	public <T> List<T> queryList(String mybitsSqlId, Class<T> classOfT, Object object) {
		return this.mybatisDao.queryList(mybitsSqlId, classOfT, object);
	}

	@Override
	public <T> List<T> queryList(String mybitsSqlId, Class<T> classOfT, Map<String, Object> map) {
		return this.mybatisDao.queryList(mybitsSqlId, classOfT, map);
	}

	@Override
	public <T> List<T> queryList(String mybitsSqlId,Class<T> classOfT) {
		return this.mybatisDao.queryList(mybitsSqlId,classOfT);
	}

	@Override
	public int count(String mybitsSqlId) {
		// TODO Auto-generated method stub
		return this.mybatisDao.count(mybitsSqlId);
	}

	@Override
	public int count(String mybitsSqlId, Object object) {
		// TODO Auto-generated method stub
		return this.mybatisDao.count(mybitsSqlId, object);
	}

	@Override
	public <T> T find(String mybitsSqlId, Class<T> classOfT) {
		// TODO Auto-generated method stub
		return this.mybatisDao.find(mybitsSqlId, classOfT);
	}

	@Override
	public <T> T find(String mybitsSqlId, Class<T> classOfT, Map<String, Object> map) {
		// TODO Auto-generated method stub
		return this.mybatisDao.find(mybitsSqlId, classOfT, map);
	}

	@Override
	public <T> T find(String mybitsSqlId, Class<T> classOfT, Object object) {
		// TODO Auto-generated method stub
		return this.mybatisDao.find(mybitsSqlId, classOfT, object);
	}

	@Override
	public boolean save(String mybitsSqlId, Object object) {
		// TODO Auto-generated method stub
		return this.mybatisDao.insert(mybitsSqlId, object);
	}
	
	@Override
	public boolean save(String mybitsSqlId) {
		// TODO Auto-generated method stub
		return this.mybatisDao.insert(mybitsSqlId);
	}

	@Override
	public boolean update(String mybitsSqlId, Object object) {
		// TODO Auto-generated method stub
		return this.mybatisDao.update(mybitsSqlId, object);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public <T> QueryResult pageList(String mybitsSqlId,String mybitsCountSqlId, Class<T> classOfT, Map<String,Object> map, int page, int limit) {
		// TODO Auto-generated method stub
		page = (page==0)?1:page;
		limit = (limit==0)?20:limit;
		int start = (page-1)*limit;
		map.put("start", start);
		map.put("limit", limit);
		List<T> list = this.mybatisDao.queryList(mybitsSqlId, classOfT, map);
		int count = this.mybatisDao.count(mybitsCountSqlId, map);
		MPager pager = new MPager(page, limit);
		pager.setRecordCount(count);
		return new QueryResult(list, pager);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public <T> QueryResult pageList(String mybitsSqlId, String mybitsCountSqlId, Class<T> classOfT, String fields,
			Map<String, Object> map, int page, int limit) {
		page = (page==0)?1:page;
		limit = (limit==0)?20:limit;
		int start = (page-1)*limit;
		map.put("start", start);
		map.put("limit", limit);
		map.put("TableField", Func.isBlank(fields)?"*":fields);
		List<T> list = this.mybatisDao.queryList(mybitsSqlId, classOfT, map);
		int count = this.mybatisDao.count(mybitsCountSqlId, map);
		MPager pager = new MPager(page, limit);
		pager.setRecordCount(count);
		return new QueryResult(list, pager);
	}

	@Override
	public <T> T find(String mybitsSqlId, Class<T> classOfT, String fields, Map<String, Object> map) {
		// TODO Auto-generated method stub
		map.put("TableField", Func.isBlank(fields)?"*":fields);
		return this.mybatisDao.find(mybitsSqlId, classOfT, map);
	}

	@Override
	public <T> List<T> queryList(String mybitsSqlId, Class<T> classOfT, String fields, Map<String, Object> map) {
		// TODO Auto-generated method stub
		map.put("TableField", Func.isBlank(fields)?"*":fields);
		return this.mybatisDao.queryList(mybitsSqlId, classOfT, map);
	}

	@Override
	public boolean delete(String mybitsSqlId) {
		// TODO Auto-generated method stub
		return this.mybatisDao.delete(mybitsSqlId);
	}

	@Override
	public boolean delete(String mybitsSqlId, Object object) {
		// TODO Auto-generated method stub
		return this.mybatisDao.delete(mybitsSqlId, object);
	}

}
