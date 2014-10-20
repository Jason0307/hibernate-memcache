/**
 * 
 */
package org.zhubao.memory.util;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author jason.zhu
 * @date   2014-10-20
 * @email jasonzhu@augmentum.com.cn
 */
@Component("mapperFactory")
public class CustomerizeMapperFactory implements FactoryBean<MapperFactory> {

	@Override
	public MapperFactory getObject() throws Exception {
		return new DefaultMapperFactory.Builder().build();
	}

	@Override
	public Class<?> getObjectType() {
		return MapperFactory.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
