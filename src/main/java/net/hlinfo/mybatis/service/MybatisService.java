package net.hlinfo.mybatis.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import net.hlinfo.opt.QueryResult;

/**
 * MybatisService为对{@link net.hlinfo.mybatis.dao.MybatisDao}操作数据库的扩展
 * @author hlinfo.net
 *
 */

@Service
public interface MybatisService {
	/**
     * 查询列表，有参数，参数为pojo对象
     * @param <T> 对象
     * @param mybitsSqlId Mybatis的Xml的SQLId
     * @param classOfT 对象类型
     * @param object pojo对象参数
     * @return 列表
     */
	<T> List<T> queryList(String mybitsSqlId,Class<T> classOfT, Object object);

    /**
     * 查询列表，参数为Map对象
     * @param <T> 对象
     * @param mybitsSqlId Mybatis的Xml的SQLId
     * @param classOfT 对象类型
     * @param map 参数
     * @return 列表
     */
	<T> List<T> queryList(String mybitsSqlId,Class<T> classOfT, Map<String,Object> map);
	/**
     * 查询列表，参数为Map对象
     * @param <T> 对象
     * @param mybitsSqlId Mybatis的Xml的SQLId
     * @param classOfT 对象类型
     * @param fields SQL的XML变量名为:TableField
     * @param map 参数
     * @return 列表
     */
	<T> List<T> queryList(String mybitsSqlId,Class<T> classOfT,String fields, Map<String,Object> map);
	/**
	 * 查询列表，无参数
	 * @param <T> 对象
	 * @param mybitsSqlId Mybatis的Xml的SQLId
	 * @param classOfT 对象类型
	 * @return 列表
	 */
	<T> List<T> queryList(String mybitsSqlId,Class<T> classOfT);
	/**
	 * 分页查询列表，有参数，参数为对象
	 * @param <T> 对象
	 * @param mybitsSqlId Mybatis的Xml的SQLId  查询列表数据的mybitsSqlId
	 * @param mybitsCountSqlId 查询数量的mybitsSqlId
	 * @param classOfT 对象类型
	 * @param map 参数
	 * 	@param page 第几页 ，从 1 开始。
	 * @param limit 每页可以有多少条记录
	 * @return 一个分页查询的结果集合，包括本页数据列表以及分页信息
	 */
	<T> QueryResult pageList(String mybitsSqlId,String mybitsCountSqlId,Class<T> classOfT, Map<String,Object> map,int page,int limit);
	/**
	 * 分页查询列表，有参数，参数为对象
	 * @param <T> 对象
	 * @param mybitsSqlId Mybatis的Xml的SQLId 查询列表数据的mybitsSqlId
	 * @param mybitsCountSqlId 查询数量的mybitsSqlId
	 * @param classOfT 对象类型
	 * @param fields 需要查询的字段：推荐使用 Func.vo2mysqlField或Func.vo2PgsqlField 生成
	 * @param map 参数
	 * @param page 第几页 ，从 1 开始。
	 * @param limit 每页可以有多少条记录
	 * @return 一个分页查询的结果集合，包括本页数据列表以及分页信息
	 */
	<T> QueryResult pageList(String mybitsSqlId,String mybitsCountSqlId,Class<T> classOfT,String fields, Map<String,Object> map,int page,int limit);
    /**
     * 查询数量，无条件
     * @param mybitsSqlId Mybatis的Xml的SQLId
     * @return 数量
     */
    public abstract int count(String mybitsSqlId);

    /**
     * 查询数量，有条件
     * @param mybitsSqlId Mybatis的Xml的SQLId
     * @param object 对象参数
     * @return 数量
     */
    public abstract int count(String mybitsSqlId, Object object);

    /**
     * 查询一条数据，无条件
     * @param <T> 对象
     * @param mybitsSqlId Mybatis的Xml的SQLId
     * @param classOfT 对象类型
     * @return 对象本身
     */
    public <T> T find(String mybitsSqlId,Class<T> classOfT);

    /**
     * 查询一条数据，有条件
     * @param <T> 对象
     * @param mybitsSqlId Mybatis的Xml的SQLId 
     * @param classOfT 对象类型
     * @param map 参数
     * @return 对象本身
     */
    public <T> T find(String mybitsSqlId,Class<T> classOfT, Map<String,Object> map);

    /**
     * 查询一条数据，有条件
     * @param <T> 对象
     * @param mybitsSqlId Mybatis的Xml的SQLId
     * @param classOfT 对象类型
     * @param object 对象参数
     * @return 对象本身
     */
    public <T> T find(String mybitsSqlId,Class<T> classOfT, Object object);

    /**
     * 新增
     * @param mybitsSqlId Mybatis的Xml的SQLId
     * @param object 对象参数
     * @return 布尔类型
     */
    public abstract boolean save(String mybitsSqlId, Object object);
    
    /**
     * 新增
     * @param mybitsSqlId Mybatis的Xml的SQLId
     * @return 布尔类型
     */
    public abstract boolean save(String mybitsSqlId);

    /**
     * 修改
     * @param mybitsSqlId Mybatis的Xml的SQLId
     * @param object 对象参数
     * @return 布尔类型
     */
    public abstract boolean update(String mybitsSqlId, Object object);
    /**
     * 查询一条数据，有条件
     * @param <T> 对象
     * @param mybitsSqlId Mybatis的Xml的SQLId
     * @param classOfT 对象类型
     * @param fields 需要查询的字段：推荐使用 Func.vo2mysqlField或Func.vo2PgsqlField 生成
     * @param map 参数
     * @return 当前对象
     */
    public <T> T find(String mybitsSqlId,Class<T> classOfT,String fields, Map<String,Object> map);

    /**
     * 删除，无参数
     * @param mybitsSqlId Mybatis的Xml的SQLId
     * @return 布尔类型
     */
    public abstract boolean delete(String mybitsSqlId);
    /**
     * 删除，带参数
     * @param mybitsSqlId Mybatis的Xml的SQLId
     * @param object map或者pojo对象参数
     * @return 布尔类型
     */
    public abstract boolean delete(String mybitsSqlId, Object object);
    
}
