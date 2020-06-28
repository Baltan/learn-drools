package com.baltan.drools;

import com.baltan.drools.constant.City;
import com.baltan.drools.constant.Type;
import com.baltan.drools.pojo.ItemCity;
import org.drools.core.impl.InternalKnowledgeBase;
import org.drools.core.impl.KnowledgeBaseFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.io.ResourceType;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderErrors;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.StatefulKnowledgeSession;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * Description: 引用：
 * <a href="https://www.yiibai.com/drools/drools_sample_drools_program.html#article-start"></a>
 *
 * @author Baltan
 * @date 2020-06-27 21:40
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DroolsTest {
    @Test
    public void test1() {
        StatefulKnowledgeSession session = null;

        try {
            InternalKnowledgeBase base = readKnowledgeBase();
            /**
             * 获取有状态的知识会话
             */
            session = (StatefulKnowledgeSession) base.newKieSession();

            ItemCity itemCity1 = new ItemCity();
            itemCity1.setPurchaseCity(City.PUNE);
            itemCity1.setTypeofItem(Type.MEDICINES);
            itemCity1.setSellPrice(new BigDecimal(10));
            session.insert(itemCity1);

            ItemCity itemCity2 = new ItemCity();
            itemCity2.setPurchaseCity(City.PUNE);
            itemCity2.setTypeofItem(Type.GROCERIES);
            itemCity2.setSellPrice(new BigDecimal(10));
            session.insert(itemCity2);

            ItemCity itemCity3 = new ItemCity();
            itemCity3.setPurchaseCity(City.NAGPUR);
            itemCity3.setTypeofItem(Type.MEDICINES);
            itemCity3.setSellPrice(new BigDecimal(10));
            session.insert(itemCity3);

            ItemCity itemCity4 = new ItemCity();
            itemCity4.setPurchaseCity(City.NAGPUR);
            itemCity4.setTypeofItem(Type.GROCERIES);
            itemCity4.setSellPrice(new BigDecimal(10));
            session.insert(itemCity4);

            session.fireAllRules();

            System.out.println(itemCity1);
            System.out.println(itemCity2);
            System.out.println(itemCity3);
            System.out.println(itemCity4);
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            session.dispose();
        }
    }

    /**
     * 创建规则库
     *
     * @return
     */
    private InternalKnowledgeBase readKnowledgeBase() {
        KnowledgeBuilder builder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        builder.add(ResourceFactory.newClassPathResource("rules/Pune.drl"), ResourceType.DRL);
        builder.add(ResourceFactory.newClassPathResource("rules/Nagpur.drl"), ResourceType.DRL);
        /**
         * 获取所有编译过程中产生的错误
         */
        KnowledgeBuilderErrors errors = builder.getErrors();
        /**
         * 如果存在编译错误，打印所有错误，并且抛出异常
         */
        if (!errors.isEmpty()) {
            errors.stream().forEach(System.out::println);
            throw new IllegalArgumentException("Could not parse knowledge.");
        }

        InternalKnowledgeBase base = KnowledgeBaseFactory.newKnowledgeBase();
        /**
         * 将编译得到的规则包都添加到规则库中
         */
        base.addPackages(builder.getKnowledgePackages());
        return base;
    }
}
