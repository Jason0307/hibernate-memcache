/**
 * 
 */
package org.zhubao.memory.util;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.ConverterFactory;
import ma.glasnost.orika.metadata.ClassMapBuilder;
import ma.glasnost.orika.metadata.FieldMapBuilder;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zhubao.memory.vo.UserDto;
import org.zhubao.memory.vo.UserVo;

import com.google.common.collect.ImmutableList;

/**
 * @author jason.zhu
 * @date 2014-10-20
 * @email jasonzhu@augmentum.com.cn
 */
public class BeanMappingUtil {
	private static MapperFacade mapper = null;

	public static MapperFactory getMapperFactory() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		MapperFactory factory = (MapperFactory) ac.getBean("mapperFactory");
		ac.close();
		return factory;
	}

	public static <T, K> T map(Class<K> sourceClazz, Class<T> descClazz,
			K source, List<String[]> fields) {
		MapperFactory mapperFactory = getMapperFactory();
		ConverterFactory converterFactory = mapperFactory.getConverterFactory();
		converterFactory
				.registerConverter("dateConverter", new DateConverter());
		ClassMapBuilder<K, T> classBuilder = mapperFactory
				.classMap(sourceClazz, descClazz).mapNulls(false)
				.mapNullsInReverse(false);
		if (null != fields) {
			for (String[] fieldArr : fields) {
				FieldMapBuilder<K, T> fieldBuilder = classBuilder.fieldMap(
						fieldArr[0], fieldArr[1]);
				if (2 < fieldArr.length) {
					//String convert = fieldArr[2];
					//if (null != convert && !"".equals(convert)) {
						//boolean convertable = Boolean.parseBoolean(convert);
						//if (convertable) {
							fieldBuilder.converter(fieldArr[2]);
					//	}
				//	}
				}
				fieldBuilder.add();
				// classBuilder.field(fieldArr[0], fieldArr[1]);
			}
		}
		mapperFactory.registerClassMap(classBuilder.mapNulls(true).byDefault()
				.toClassMap());
		return mapperFactory.getMapperFacade().map(source, descClazz);
	}

	public static void init() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		MapperFactory factory = (MapperFactory) ac.getBean("mapperFactory");
		factory.registerClassMap(factory.classMap(UserDto.class, UserVo.class)
				.mapNulls(false).mapNullsInReverse(false)
				.field("username", "name").field("items{}", "itemIds{}")
				.mapNulls(true).byDefault().toClassMap());
		mapper = factory.getMapperFacade();
		ac.close();
	}

	public static void main(String[] args) {

		BeanMappingUtil.init();
		UserDto userDto = new UserDto();
		String userId = UUID.randomUUID().toString();
		userDto.setUserId(userId);
		userDto.setUsername("Jason");
		userDto.setItems(ImmutableList.of(1, 2, 3));
		userDto.setBirthDate(new Date());
		UserVo userVo = mapper.map(userDto, UserVo.class);
		System.out.println(userVo);

		UserDto userDto2 = new UserDto();
		String userId2 = UUID.randomUUID().toString();
		userDto2.setUserId(userId2);
		userDto2.setUsername("Jason");
		userDto2.setBirthDate(new Date());
		userDto2.setItems(ImmutableList.of(1, 2, 3, 5));
		List<String[]> fields = ImmutableList.of(new String[] { "username",
				"name" }, new String[] { "items{}", "itemIds{}" },new String[]{"birthDate","birthDate","dateConverter"});
		UserVo userMapperVo = map(UserDto.class, UserVo.class, userDto2, fields);
		System.out.println(userMapperVo);

	}
}
