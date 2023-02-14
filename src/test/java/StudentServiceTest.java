import com.example.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")  // 运行上下文配置
public class StudentServiceTest {

    @Autowired
    private StudentService service;

    @Test
    public void testGetStudentById() {
        System.out.println("测试执行结果：" + service.getStudentById(1));
    }
}
