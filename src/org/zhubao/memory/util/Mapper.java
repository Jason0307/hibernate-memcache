/**
 * 
 */
package org.zhubao.memory.util;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

import org.zhubao.memory.vo.ChildVo;
import org.zhubao.memory.vo.ParentDto;
import org.zhubao.memory.vo.ParentVo;

import com.google.common.collect.ImmutableList;

/**
 * @author jason.zhu
 * @date 2014-10-20
 * @email jasonzhu@augmentum.com.cn
 */
public class Mapper extends ConfigurableMapper {

	@Override
	protected void configure(MapperFactory factory) {
		factory.classMap(ParentVo.class, ParentDto.class).field("childVos{name}", "childInfo{[0]}")
		.field("childVos{gender}", "childInfo{[1]}").byDefault().register();
	}
	
	public static void main(String[] args) {
		ParentVo parentVo = new ParentVo();
		parentVo.setName("jasonzhu");
		parentVo.setAge(12);
		ChildVo childVo = new ChildVo();
		childVo.setName("c1");
		childVo.setGender(1);
		
		ChildVo childVo2 = new ChildVo();
		childVo2.setName("c2");
		childVo2.setGender(0);
		parentVo.setChildVos(ImmutableList.of(childVo,childVo2));
		
		Mapper mapper = new Mapper();
		ParentDto dto = mapper.map(parentVo, ParentDto.class);
		for(String[] ss : dto.getChildInfo()){
			for(String s : ss){
				System.out.println(s);
			}
			
		}
		System.out.println(dto);
	}
}
