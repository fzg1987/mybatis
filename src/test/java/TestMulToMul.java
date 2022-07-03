import com.fzg.entity.Account;
import com.fzg.entity.Course;
import com.fzg.repository.AccountRepository;
import com.fzg.repository.CourseRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class TestMulToMul {
    public static void main(String[] args) {
        InputStream inputStream = TestOneToMultiple.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        AccountRepository accountRepository = sqlSession.getMapper(AccountRepository.class);
        Account account = accountRepository.findById(1);
        System.out.println(account);
        CourseRepository courseRepository = sqlSession.getMapper(CourseRepository.class);
        Course course = courseRepository.findById(1);
        System.out.println(course);
        sqlSession.close();
    }

}
