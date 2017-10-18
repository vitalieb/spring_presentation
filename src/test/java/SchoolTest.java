import com.endava.ConfigurationClass;
import com.endava.School;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ConfigurationClass.class)
public class SchoolTest {


    @Autowired
    ApplicationContext context;

    @Test
    public void assertNumberOfStudents(){
        School school = context.getBean(School.class);
        MatcherAssert.assertThat(school.getStudentList().size(),is(2));
    }

}
