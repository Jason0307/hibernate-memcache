/**
 * 
 */
package org.zhubao.memory.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

/**
 * @author jason.zhu
 * @date 2014-10-18
 * @email jasonzhu@augmentum.com.cn
 */
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)  
@Data
@Entity
@Table(name = "User")
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	private String userId;
	private String username;
	private String password;
	private String emailAddress;
	private int age;

}
