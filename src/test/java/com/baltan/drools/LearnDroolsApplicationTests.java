package com.baltan.drools;

import com.baltan.drools.pojo.*;
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

    /**
     * rule1
     */
    @Test
    public void test1() {
        obj = 0d;
    }

    /**
     * rule2
     */
    @Test
    public void test2() {
        User user = new User("Baltan", 30, null, null);
        obj = user;
    }

    /**
     * rule3
     */
    @Test
    public void test3() {
        User user = new User("Baltan", 29, Arrays.asList("football", "sleeping", "wandering"), null);
        obj = user;
    }

    /**
     * rule4
     */
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

    /**
     * rule5
     */
    @Test
    public void test5() {
        User user = new User("Baltan", 28, Arrays.asList("football", "wandering", "sleeping"), null);
        obj = user;
    }

    /**
     * rule6
     */
    @Test
    public void test6() {
        User user = new User("Baltan", 28, Arrays.asList("table tennis", "wandering", "sleeping"), null);
        obj = user;
    }

    /**
     * rule7
     */
    @Test
    public void test7() {
        User user = new User("Zhang San", 30, null, null);
        obj = user;
    }

    /**
     * rule8
     */
    @Test
    public void test8() {
        User user = new User("Baltan", 28, Arrays.asList("coding", "wandering", "sleeping"), null);
        obj = user;
    }

    /**
     * rule9、rule10、rule11
     */
    @Test
    public void test9() {
        Lover lover = new Lover();
        obj = lover;
    }

    /**
     * rule12、rule13、rule14
     */
    @Test
    public void test10() {
        Lover lover = new Lover("A");
        obj = lover;
    }

    /**
     * rule15、rule16
     */
    @Test
    public void test11() {
        session.getAgenda().getAgendaGroup("group3").setFocus();
        Lover lover = new Lover("C");
        obj = lover;
    }

    /**
     * rule17
     */
    @Test
    public void test12() {
        Loser loser = new Loser("A");
        obj = loser;
    }

    /**
     * rule18、rule19
     */
    @Test
    public void test13() {
        Loser loser = new Loser("B");
        obj = loser;
    }

    /**
     * rule19
     */
    @Test
    public void test14() {
        Loser loser = new Loser("C");
        obj = loser;
    }

    /**
     * rule20、rule21
     */
    @Test
    public void test15() {
        Loser loser = new Loser("D");
        obj = loser;
    }

    /**
     * rule22、rule23
     */
    @Test
    public void test16() {
        Loser loser = new Loser("F");
        obj = loser;
    }

    /**
     * rule24、rule25
     */
    @Test
    public void test17() {
        Context context = new Context();
        obj = context;
    }

    /**
     * rule26、rule27、rule28、rule29、rule30、rule31
     */
    @Test
    public void test18() {
        Random random = new Random();
        obj = random;
    }

    /**
     * rule32
     */
    @Test
    public void test19() {
        Loser loser = new Loser("G");
        obj = loser;
    }

    @AfterEach
    public void after() {
        session.insert(obj);
        session.fireAllRules();
        session.dispose();
    }
}
