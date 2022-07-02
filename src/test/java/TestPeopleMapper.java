import com.fzg.entity.People;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class TestPeopleMapper {
    public static void main(String[] args) {
        // 加载MyBatis配置文件
        InputStream inputStream = TestPeopleMapper.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        // 获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 调用 MyBatis 原生接口执行 SQL 语句
        String statement = "com.fzg.mapper.PeopleMapper.findById";
        People people = sqlSession.selectOne(statement,1);
        System.out.println(people);
        sqlSession.close();
    }
}
