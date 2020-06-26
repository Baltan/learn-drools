package com.baltan.drools;

import com.drools.core.KieTemplate;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@SpringBootTest
@RunWith(SpringRunner.class)
class LearnDroolsApplicationTests {
    @Autowired
    private KieTemplate kieTemplate;

    @Before
    public void before() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
    }

    @Test
    public void test1() {
        KieSession session = kieTemplate.getKieSession("rule.drl");
        session.insert(0d);
        session.fireAllRules();
    }
}
