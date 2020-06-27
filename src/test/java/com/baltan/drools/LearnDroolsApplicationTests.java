package com.baltan.drools;

import com.baltan.drools.pojo.Lover;
import com.baltan.drools.pojo.User;
import com.drools.core.KieTemplate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@RunWith(SpringRunner.class)
class LearnDroolsApplicationTests {
    @Autowired
    private KieTemplate kieTemplate;
    private KieSession session;
    private Object obj;

    @BeforeEach
    public void before() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        session = kieTemplate.getKieSession("rule.drl");
    }

    @Test
    public void test1() {
        obj = 0d;
    }

    @Test
    public void test2() {
        User user = new User("Baltan", 30, null, null);
        obj = user;
    }

    @Test
    public void test3() {
        User user = new User("Baltan", 29, Arrays.asList("football", "sleeping", "wandering"), null);
        obj = user;
    }

    @Test
    public void test4() {
        Map<String, Object> tags = new HashMap<>();
        tags.put("姓名", "唐寅");
        tags.put("字", "伯虎");
        tags.put("别名", "华安");
        tags.put("终生代号", 9527);
        User user = new User("Baltan", 28, Arrays.asList("sleeping", "football", "wandering"), tags);
        obj = user;
    }

    @Test
    public void test5() {
        User user = new User("Baltan", 28, Arrays.asList("football", "wandering", "sleeping"), null);
        obj = user;
    }

    @Test
    public void test6() {
        User user = new User("Baltan", 28, Arrays.asList("table tennis", "wandering", "sleeping"), null);
        obj = user;
    }

    @Test
    public void test7() {
        User user = new User("Zhang San", 30, null, null);
        obj = user;
    }

    @Test
    public void test8() {
        User user = new User("Baltan", 28, Arrays.asList("coding", "wandering", "sleeping"), null);
        obj = user;
    }

    @Test
    public void test9() {
        Lover lover = new Lover();
        obj = lover;
    }

    @Test
    public void test10() {
        session.getAgenda().getAgendaGroup("group3").setFocus();
        Lover lover = new Lover();
        obj = lover;
    }

    @AfterEach
    public void after() {
        session.insert(obj);
        session.fireAllRules();
        session.dispose();
    }
}
