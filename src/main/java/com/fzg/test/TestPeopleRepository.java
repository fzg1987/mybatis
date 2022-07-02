package com.fzg.test;

import com.fzg.entity.People;
import com.fzg.repository.PeopleRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class TestPeopleRepository {
    public static void main(String[] args) {
        InputStream inputStream = TestPeopleRepository.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取实现了自定义接口的代理对象
        PeopleRepository peopleRepository = sqlSession.getMapper(PeopleRepository.class);
        //增加
        /*
        People people = new People();
        people.setName("小杨");
        people.setMoney(Double.parseDouble("6000"));
        int row = peopleRepository.save(people);
        sqlSession.commit();
        */
//        People people = peopleRepository.findById(4);
//        people.setName("小红");
//        people.setMoney(Double.parseDouble("800"));
//        peopleRepository.update(people);
//        peopleRepository.deleteById(4);
//        sqlSession.commit();
//        List<People> peopleList =  peopleRepository.findAll();
//        for (People people : peopleList) {
//            System.out.println(people);
//        }
//        People people = peopleRepository.findById2(3);
//        System.out.println(people);
//        people = peopleRepository.findByName("张三");
//        System.out.println(people);
//        people = peopleRepository.findByIdName(2,"李四");
//        System.out.println(people);
        int count = peopleRepository.count();
        System.out.println("count = "+count);
        String name = peopleRepository.findName(2);
        System.out.println("name[2] = " + name);
        sqlSession.close();
    }
}
