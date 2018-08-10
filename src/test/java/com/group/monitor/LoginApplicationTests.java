package com.group.monitor;

import com.group.monitor.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginApplicationTests {
	@Autowired
	private UserService userService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void save(){
		/*UserPO user=new UserPO();
		user.setAge(21);
		user.setPassword("123456");
		user.setName("易酒批");
		user.setSex("女");
		userService.save(user);*/
	}

	@Test
	public void login(){
		/*UserPO user=userService.getUser("张三","123456");
		Assert.assertEquals(new Integer(21),user.getAge());*/
	}

}
