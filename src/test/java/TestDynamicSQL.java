import com.fzg.entity.MyClass;
import com.fzg.entity.User;
import com.fzg.repository.MyClassRepository;
import com.fzg.repository.UserRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class TestDynamicSQL {
    public static void main(String[] args) {
        InputStream inputStream = TestOneToMultiple.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserRepository userRepository = sqlSession.getMapper(UserRepository.class);
        User user = new User();
//        user.setId(1);
//        user.setUsername("张三");
//        user.setPassword("000");
//        user.setAge(24);
//        User user2 = userRepository.findByUser(user);
//        System.out.println(user2);
        user.setId(2);
        user.setUsername("李四");
        user.setAge(35);
        userRepository.update(user);
        sqlSession.commit();
        sqlSession.close();
    }
}
