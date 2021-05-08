# hlinfo-MyBatis-Dao是什么？

hlinfo-MyBatis-Dao是能够在Spring Boot中快速使用mybatis的工具，是mybatis的SqlSessionTemplate深度集成整合操作实现，无需写Mapper类，只需要写xml文件即可，不对MyBatis做任何改变 

# 快速使用

### 1.引入pom:

``` xml
<dependency>
    <groupId>net.hlinfo</groupId>
    <artifactId>hlinfo-mybatis-dao</artifactId>
    <version>Latest Version</version>
</dependency>
```

** 注意：此pom已经包含了MyBatis的内容，请勿在单独引入Mybatis的pom **

### 2.配置bean

在您的项目的配置文件目录新建MybatisConfig.java，内容如下：

``` java
package net.hlinfo.example.etc;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.hlinfo.mybatis.dao.MybatisDao;
import net.hlinfo.mybatis.dao.impl.MybatisDaoImpl;
import net.hlinfo.mybatis.service.MybatisService;
import net.hlinfo.mybatis.service.impl.MybatisServiceImpl;

@Configuration
public class MybatisConfig{
	
	/**
	 * 配置MybatisDao，注入SqlSessionTemplate
	 * @param sqlSessionTemplate
	 * @return
	 */
    @Bean
    public MybatisDao mybatisDao(SqlSessionTemplate sqlSessionTemplate){
    	MybatisDao mybatisDao = new MybatisDaoImpl(sqlSessionTemplate);
    	return mybatisDao;
    }
    
    /**
     * 配置MybatisService，对MybatisDao的一些操作的扩展
     * @param mybatisDao
     * @return
     */
    @Bean
    public MybatisService mybatisService(MybatisDao mybatisDao){
    	MybatisService mybatisService = new MybatisServiceImpl(mybatisDao);
    	return mybatisService;
    }
}

```

### 3.在application.yml或application.properties配置MyBatis的mapper的相关路径
application.yml配置示例：

``` yml
mybatis:
  config-location: classpath:mybatis/mybatis-config.xml
  mapper-locations: classpath*:mybatis/mapper/*.xml
  type-aliases-package: net.hlinfo.swagger.entity

```
**注：**

**config-location：** MyBatis xml配置文件的位置

**mapper-locations：** MyBatis mapper文件的位置（注意：在classpath后面的 \* 必不可少，本程序路径为mybatis/mapper[也就是resources下的mybatis目录下的mapper]，如果您程序需要改为其他路径,如mappers[也就是resources下的mappers目录],需要保留本程序的mapper文件路径[classpath*:mybatis/mapper/ \*.xml]，则mybatis.mapper-locations=classpath:mappers/\*.xml,classpath\*:mybatis/mapper/\*.xml）

**type-aliases-package：** 要搜索类型别名的包（也就是实体类的包名）

### 4.在Controller使用

```

package net.hlinfo.example.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.hlinfo.mybatis.opt.QueryResult;
import net.hlinfo.mybatis.service.MybatisService;
import net.hlinfo.swagger.entity.UserInfo;
import net.hlinfo.swagger.opt.Funs;
import net.hlinfo.swagger.opt.Resp;

//@Api(tags="首页")
@RequestMapping("/")
@RestController
public class IndexController {

	private MybatisService mybatisService;
	
	public IndexController(MybatisService mybatisService) {
		super();
		this.mybatisService = mybatisService;
	}

	/**
	*管理员列表
	*/
	@GetMapping("/list")
	public Resp<QueryResult<UserInfo>> list(){
		 List<Map> list = mybatisService.queryList("select_userinfo_list", Map.class);
		return new Resp<>().ok("ok", new QueryResult<>(list));
	}
	
}

```

Mapper文件如下：

``` xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"  
"http://mybatis.org/dtd/mybatis-3-mapper.dtd">  
<mapper namespace="net.hlinfo.example.entity.UserInfo">
  <select id="select_userinfo_list" resultType="Map">
  select * from user_info 
  </select>
</mapper>

```

# 参考资料
* mybatis-plus
* Nutz
* https://blog.csdn.net/StarryaSky/article/details/83687757

# 许可证
MIT License 
