// src/main/java/com/yourpackage/model/Question.java
public class Question {
    private int question_id;
    private String level;
    private String question;
    private List<String> options;
    private String correct_answer;

    // Constructors, getters, and setters

    public Question() {
        // Default constructor
    }

    public Question(int question_id, String level, String question, List<String> options, String correct_answer) {
        question_id = id;
        this.level = level;
        this.question = question;
        this.options = options;
        correct_answer = answer;
    }

    // Getter and Setter methods for each field

    public int getId() {
        return question_id;
    }

    public void setId(int question_id) {
        question_id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public String getAnswer() {
        return correct_answer;
    }

    public void setAnswer(String correct_answer) {
        correct_answer = answer;
    }
}
