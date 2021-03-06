package com.tsc.iorder;

import com.tsc.iorder.service.UserService;
import com.tsc.iorder.util.UUID16;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IorderApplicationTests {
    @Autowired
    UserService userService;
    @Test
    public void contextLoads() {
        String uuid8 = UUID16.getUUID16();
        System.out.println(uuid8);
    }

}
