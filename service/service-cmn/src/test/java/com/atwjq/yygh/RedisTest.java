package com.atwjq.yygh;

import com.atwjq.yygh.cmn.ServiceCmnApplication;
import com.atwjq.yygh.cmn.service.DictService;
import com.atwjq.yygh.model.cmn.Dict;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @Auther:Administrator
 * @Description:
 * @CreateTime:2021-07-17-15:59
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceCmnApplication.class)
public class RedisTest {
    @Autowired
    private DictService dictService;

    @Autowired
    private ApplicationContext appContext;


    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Test
    public void test1() {
        //hello——world
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ops.set("hello", "world" + UUID.randomUUID().toString());
        //查询
        String hello = ops.get("hello");

        System.out.println(hello);
    }

    @Test
    public void testBean() {
        List<Dict> chlidData = dictService.findChlidData(1l);
        System.out.println(chlidData);
    }

    @Test
    public void run() {
        String[] beans = appContext.getBeanDefinitionNames();
        Arrays.sort(beans);
        for (String bean : beans) {
            System.out.println(bean + " of Type :: " + appContext.getBean(bean).getClass());
        }
    }

}
