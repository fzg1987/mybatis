package com.fzg.test;

import com.fzg.entity.Classes;
import com.fzg.entity.Student;
import com.fzg.repository.ClassesRepository;
import com.fzg.repository.PeopleRepository;
import com.fzg.repository.StudentRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class TestOneToMultiple {
    public static void main(String[] args) {
        InputStream inputStream = TestOneToMultiple.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取实现了自定义接口的代理对象
        StudentRepository studentRepository = sqlSession.getMapper(StudentRepository.class);
        Student student = studentRepository.findById(1);
        System.out.println(student);
        ClassesRepository classesRepository = sqlSession.getMapper(ClassesRepository.class);
        Classes classes = classesRepository.findById(1);
        System.out.println(classes);
    }
}
