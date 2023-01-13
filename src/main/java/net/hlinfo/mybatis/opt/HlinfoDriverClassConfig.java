package net.hlinfo.mybatis.opt;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="spring.datasource",ignoreInvalidFields=true, ignoreUnknownFields=true)
public class HlinfoDriverClassConfig {
	private String driverClassName;

	public String getDriverClassName() {
		return driverClassName;
	}

	/**
	 * 
	 * @param driverClassName 数据库驱动名
	 */
	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}
	
	public boolean isoracle() {
		if(driverClassName.indexOf("oracle")>=0) {
			return true;
		}
		return false;
	}
}
