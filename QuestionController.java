import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    private QuestionLoader questionLoader;

    @GetMapping("/{id}")
public ResponseEntity<Question> getQuestionById(@PathVariable int id) {
    // Use the QuestionLoader to retrieve the question by ID
    Question question = questionLoader.getQuestions().stream()
            .filter(q -> q.getId() == id)
            .findFirst()
            .orElse(null);

    if (question != null) {
        return ResponseEntity.ok(question); // Return the question if found
    } else {
        return ResponseEntity.notFound().build(); // Return 404 if not found
    }
}

@GetMapping("/level/{level}")
public ResponseEntity<List<Question>> getQuestionsByLevel(@PathVariable String level) {
    // Use the QuestionLoader to filter questions by level
    List<Question> filteredQuestions = questionLoader.getQuestions().stream()
            .filter(q -> q.getLevel().equalsIgnoreCase(level))
            .collect(Collectors.toList());

    if (!filteredQuestions.isEmpty()) {
        return ResponseEntity.ok(filteredQuestions); // Return filtered questions
    } else {
        return ResponseEntity.notFound().build(); // Return 404 if no questions found
    }
}

@GetMapping
public ResponseEntity<List<Question>> getAllQuestions() {
    // Use the QuestionLoader to get all questions
    List<Question> allQuestions = questionLoader.getQuestions();

    if (!allQuestions.isEmpty()) {
        return ResponseEntity.ok(allQuestions); // Return all questions
    } else {
        return ResponseEntity.noContent().build(); // Return 204 if no questions found
    }
}

@GetMapping("/{id}/options")
public ResponseEntity<List<String>> getOptionsForQuestion(@PathVariable int id) {
    // Use the QuestionLoader to find the question by ID
    Question question = questionLoader.getQuestions().stream()
            .filter(q -> q.getId() == id)
            .findFirst()
            .orElse(null);

    if (question != null) {
        List<String> options = question.getOptions();
        return ResponseEntity.ok(options); // Return options if question found
    } else {
        return ResponseEntity.notFound().build(); // Return 404 if question not found
    }
}

@PostMapping("/{id}/check-answer")
public ResponseEntity<Boolean> checkAnswer(@PathVariable int id, @RequestBody String submittedAnswer) {
    // Use the QuestionLoader to find the question by ID
    Question question = questionLoader.getQuestions().stream()
            .filter(q -> q.getId() == id)
            .findFirst()
            .orElse(null);

    if (question != null) {
        boolean isCorrect = submittedAnswer.equalsIgnoreCase(question.getAnswer());
        return ResponseEntity.ok(isCorrect); // Return true if answer is correct
    } else {
        return ResponseEntity.notFound().build(); // Return 404 if question not found
    }
}

}
