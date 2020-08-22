import com.self.learning.springBootAppWithTDD.service.ToDoService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class ToDoControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ToDoService toDoService;

}
