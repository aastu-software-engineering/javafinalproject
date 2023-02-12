package io.ruth.quizapp.DTO;
;

import java.util.List;

public class ScoreResponseDto {

    public List<Checks> checks;

    public String comment;
    public double score;

    public void setScore(double score) {
        this.score = score;
    }

    public static class Checks {

        public int weight;

        public String correctAnswer;

        public boolean isRight;

        public int questionId;
    }
}
