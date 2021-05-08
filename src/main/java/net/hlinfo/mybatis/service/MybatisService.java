package net.hlinfo.mybatis.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import net.hlinfo.mybatis.opt.QueryResult;

/**
 *
 * @author cy
 *
 */

@Service
public interface MybatisService {
	/**
     * 查询列表，有参数，参数为pojo对象
     * @param mybitsSqlId
     * @param object
     * @return list
     */
	<T> List<T> queryList(String mybitsSqlId,Class<T> classOfT, Object object);

    /**
     * 查询列表，参数为Map对象
     * @param mybitsSqlId
     * @param object
     * @return list
     */
	<T> List<T> queryList(String mybitsSqlId,Class<T> classOfT, Map<String,Object> map);
	/**
     * 查询列表，参数为Map对象
     * @param mybitsSqlId
     * @param fields SQL的XML变量名为:TableField
     * @param object
     * @return list
     */
	<T> List<T> queryList(String mybitsSqlId,Class<T> classOfT,String fields, Map<String,Object> map);
	/**
	 * 查询列表，无参数
	 * @param <T>
	 * @param mybitsSqlId
	 * @param classOfT 对象类型
	 * @return
	 */
	<T> List<T> queryList(String mybitsSqlId,Class<T> classOfT);
	/**
	 * 分页查询列表，有参数，参数为对象
	 * @param <T>
	 * @param mybitsSqlId  查询列表数据的mybitsSqlId
	 * @param mybitsCountSqlId 查询数量的mybitsSqlId
	 * @param classOfT 对象类型
	 * @param map 参数
	 * 	@param page 第几页 ，从 1 开始。
	 * @param limit 每页可以有多少条记录
	 * @return QueryResult:一个分页查询的结果集合，包括本页数据列表以及分页信息
	 */
	<T> QueryResult pageList(String mybitsSqlId,String mybitsCountSqlId,Class<T> classOfT, Map<String,Object> map,int page,int limit);
	/**
	 * 分页查询列表，有参数，参数为对象
	 * @param <T>
	 * @param mybitsSqlId 查询列表数据的mybitsSqlId
	 * @param mybitsCountSqlId 查询数量的mybitsSqlId
	 * @param classOfT 对象类型
	 * @param fields 需要查询的字段：推荐使用 Func.vo2mysqlField或Func.vo2PgsqlField 生成
	 * @param map 参数
	 * @param page 第几页 ，从 1 开始。
	 * @param limit 每页可以有多少条记录
	 * @return QueryResult:一个分页查询的结果集合，包括本页数据列表以及分页信息
	 */
	<T> QueryResult pageList(String mybitsSqlId,String mybitsCountSqlId,Class<T> classOfT,String fields, Map<String,Object> map,int page,int limit);
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
    public abstract boolean save(String mybitsSqlId, Object object);
    
    /**
     * 新增
     * @param mybitsSqlId
     * @return
     */
    public abstract boolean save(String mybitsSqlId);

    /**
     * 修改
     * @param mybitsSqlId
     * @param object
     * @return
     */
    public abstract boolean update(String mybitsSqlId, Object object);
    /**
     * 查询一条数据，有条件
     * @param <T>
     * @param mybitsSqlId
     * @param classOfT
     * @param map
     * @return
     */
    public <T> T find(String mybitsSqlId,Class<T> classOfT,String fields, Map<String,Object> map);

    /**
     * 删除，无参数
     * @param mybitsSqlId
     * @return
     */
    public abstract boolean delete(String mybitsSqlId);
    /**
     * 删除，带参数
     * @param mybitsSqlId
     * @param object
     * @return
     */
    public abstract boolean delete(String mybitsSqlId, Object object);
}
