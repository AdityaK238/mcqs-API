import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class QuestionLoader {
    @Value("${questions.json.path}")
    private String jsonFilePath;

    private List<Question> questions;

    @PostConstruct
    public void loadQuestions() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            questions = objectMapper.readValue(new File(jsonFilePath), new TypeReference<List<Question>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
