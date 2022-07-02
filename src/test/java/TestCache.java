import com.fzg.entity.MyClass;
import com.fzg.repository.MyClassRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class TestCache {
    public static void main(String[] args) {
        InputStream inputStream = TestOneToMultiple.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        MyClassRepository myClassRepository = sqlSession.getMapper(MyClassRepository.class);
        MyClass myClass = myClassRepository.findById(1);
        System.out.println(myClass);
        // 关闭SQLSession
        sqlSession.close();
        // 开启新的SQLSession
        sqlSession = sqlSessionFactory.openSession();
        myClassRepository = sqlSession.getMapper(MyClassRepository.class);
        MyClass myClass2 = myClassRepository.findById(1);
        System.out.println(myClass2);
        sqlSession.close();
    }
}
