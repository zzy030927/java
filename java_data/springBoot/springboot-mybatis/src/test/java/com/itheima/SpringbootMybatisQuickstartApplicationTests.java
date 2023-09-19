package com.itheima;

import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest //springboot整合单元测试的注解
class SpringbootMybatisQuickstartApplicationTests {
    @Autowired
    private EmpMapper em;

    @Test
    public void testDelete() {
        em.delete(17);
    }

    @Test
    public void testInsert() {
        Emp emp = new Emp(null, "Tom", null, "汤姆", (short)1, "17.jpg", (short)1, LocalDate.of(2000, 1, 1), 1, LocalDate.now(), LocalDate.now());
        em.insert(emp);     // emp 表的主键为 id，因为有 @Options 注解，所以会返回主键的值，并封装到 Emp类的 id属性中
        System.out.println(emp.getId());
    }

    @Test
    public void testUpdate() {
        Emp emp = new Emp(20, "Tom1", null, "汤姆1", (short)1, "20.jpg", (short)1, LocalDate.of(2000, 1, 1), 1, LocalDate.now(), LocalDate.now());
        em.update(emp);
    }

    @Test
    public void testSelect() {
        List<Emp> emps = em.select(5, "张");
        for (Emp emp : emps) {
            System.out.println(emp);
        }
    }

    @Test
    public void testSelectUseXml() {
        List<Emp> emps = em.selectInXml(1, "张");   // 动态 sql 实现 当 name 为空时，还可以查询到结果，在 xml文件中配置
        for (Emp emp : emps) {
            System.out.println(emp);
        }
    }

    @Test
    public void testDeleteByIds() {
        em.deleteByIds(Arrays.asList(15, 16, 20));
    }
}
