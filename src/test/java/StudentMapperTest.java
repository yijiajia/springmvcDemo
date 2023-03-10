import com.example.mapper.StudentMapper;
import com.example.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 使用SpringJUnit4ClassRunner前需要注释 WebMvcConfig 中的EnableWebMvc注解，听说是会冲突
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
@ActiveProfiles("dev")
public class StudentMapperTest {

    @Autowired(required = true)
//    @Qualifier("studentMapper")
    private StudentMapper studentMapper;

    @Test
    public void getStudentById() {
        Student student = studentMapper.getStudentById(1);
        System.out.println(student);
    }

}
