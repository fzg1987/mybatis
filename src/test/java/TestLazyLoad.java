import com.fzg.entity.Order;
import com.fzg.entity.Student;
import com.fzg.repository.CustomerRepository;
import com.fzg.repository.OrderRepository;
import com.fzg.repository.StudentRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class TestLazyLoad {
    public static void main(String[] args) {
        InputStream inputStream = TestOneToMultiple.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderRepository orderRepository = sqlSession.getMapper(OrderRepository.class);
        Order order = orderRepository.findById(1);
        System.out.println(order.getCustomer().getName());
        sqlSession.close();
    }
}
