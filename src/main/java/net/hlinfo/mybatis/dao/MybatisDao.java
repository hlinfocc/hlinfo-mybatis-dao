package net.hlinfo.mybatis.dao;

import java.util.List;
import java.util.Map;

public interface MybatisDao {
	/**
     * 查询列表，有条件
     * @param mybitsSqlId
     * @param object
     * @return list
     */
	<T> List<T> queryList(String mybitsSqlId,Class<T> classOfT, Object object);

    /**
     * 查询列表，有条件
     * @param mybitsSqlId
     * @param object
     * @return list
     */
	<T> List<T> queryList(String mybitsSqlId,Class<T> classOfT, Map<String,Object> map);
    /**
     * 查询列表，无条件
     * @param mybitsSqlId
     * @return list
     */
	<T> List<T> queryList(String mybitsSqlId,Class<T> classOfT);

    /**
     * 查询数量，无条件
     * @param mybitsSqlId
     * @return int
     */
    public abstract int count(String mybitsSqlId);

    /**
     * 查询数量，有条件
     * @param mybitsSqlId
     * @param object
     * @return int
     */
    public abstract int count(String mybitsSqlId, Object object);

    /**
     * 查询一条数据，无条件
     * @param <T>
     * @param mybitsSqlId
     * @return Object
     */
    public <T> T find(String mybitsSqlId,Class<T> classOfT);

    /**
     * 查询一条数据，有条件
     * @param <T>
     * @param mybitsSqlId
     * @param classOfT
     * @param map
     * @return
     */
    public <T> T find(String mybitsSqlId,Class<T> classOfT, Map<String,Object> map);

    /**
     * 查询一条数据，有条件
     * @param mybitsSqlId
     * @param object
     * @return Object
     */
    public <T> T find(String mybitsSqlId,Class<T> classOfT, Object object);

    /**
     * 新增
     * @param mybitsSqlId
     * @param object
     * @return
     */
    public abstract boolean insert(String mybitsSqlId, Object object);
    
    /**
     * 新增
     * @param mybitsSqlId
     * @return
     */
    public abstract boolean insert(String mybitsSqlId);

    /**
     * 修改
     * @param mybitsSqlId
     * @param object
     * @return
     */
    public abstract boolean update(String mybitsSqlId, Object object);
    
    /**
     * 修改
     * @param mybitsSqlId
     * @return
     */
    public abstract boolean update(String mybitsSqlId);

    /**
     * 删除
     * @param mybitsSqlId
     * @param object
     * @return
     */
    public abstract boolean delete(String mybitsSqlId, Object object);

    /**
     * 删除
     * @param mybitsSqlId
     * @param object
     * @return
     */
    public abstract boolean delete(String mybitsSqlId);
}
