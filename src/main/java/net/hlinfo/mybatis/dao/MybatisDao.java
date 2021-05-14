package net.hlinfo.mybatis.dao;

import java.util.List;
import java.util.Map;

/**
 * MybatisDao是Mybatis操作数据库的集成工具，集成{@link org.mybatis.spring.SqlSessionTemplate}，无需写mapper类，只需写xml即可快速操作数据库
 * @author hlinfo.net
 *
 */
public interface MybatisDao {
	/**
     * 查询列表，有条件
     * @param <T> 对象
     * @param mybitsSqlId Mybatis的Xml的SQLId
     * @param classOfT 对象类型
     * @param object map或者pojo对象参数
     * @return 列表
     */
	<T> List<T> queryList(String mybitsSqlId,Class<T> classOfT, Object object);

    /**
     * 查询列表，有条件
     * @param <T> 对象
     * @param mybitsSqlId Mybatis的Xml的SQLId
     * @param classOfT 对象类型
     * @param map 参数
     * @return 列表
     */
	<T> List<T> queryList(String mybitsSqlId,Class<T> classOfT, Map<String,Object> map);
    /**
     * 查询列表，无条件
	 * @param <T> 对象
	 * @param mybitsSqlId Mybatis的Xml的SQLId
	 * @param classOfT 对象类型
	 * @return 列表
	 */
	<T> List<T> queryList(String mybitsSqlId,Class<T> classOfT);

    /**
     * 查询数量，无条件
     * @param mybitsSqlId Mybatis的Xml的SQLId
     * @return 数量
     */
    public abstract int count(String mybitsSqlId);

    /**
     * 查询数量，有条件
     * @param mybitsSqlId Mybatis的Xml的SQLId
     * @param object map或者pojo对象参数
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
     * @param object map或者pojo对象参数
     * @return 对象本身
     */
    public <T> T find(String mybitsSqlId,Class<T> classOfT, Object object);

    /**
     * 新增
     * @param mybitsSqlId Mybatis的Xml的SQLId
     * @param object map或者pojo对象参数
     * @return 布尔类型
     */
    public abstract boolean insert(String mybitsSqlId, Object object);
    
    /**
     * 新增
     * @param mybitsSqlId Mybatis的Xml的SQLId
     * @return 布尔类型
     */
    public abstract boolean insert(String mybitsSqlId);

    /**
     * 修改
     * @param mybitsSqlId Mybatis的Xml的SQLId
     * @param object map或者pojo对象参数
     * @return 布尔类型
     */
    public abstract boolean update(String mybitsSqlId, Object object);
    
    /**
     * 修改
     * @param mybitsSqlId Mybatis的Xml的SQLId
     * @return 布尔类型
     */
    public abstract boolean update(String mybitsSqlId);

    /**
     * 删除
     * @param mybitsSqlId Mybatis的Xml的SQLId
     * @param object map或者pojo对象参数
     * @return 布尔类型
     */
    public abstract boolean delete(String mybitsSqlId, Object object);

    /**
     * 删除
     * @param mybitsSqlId Mybatis的Xml的SQLId
     * @return 布尔类型
     */
    public abstract boolean delete(String mybitsSqlId);
}
