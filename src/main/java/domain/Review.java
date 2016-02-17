package domain;

/**
 * Created by Tim on 14/02/2016.
 */
public class Review {

    private String reviewerName;
    private String gameName;
    private int score;
    private String body;

    public Review(String reviewerName,String gameName, int score, String body) {
        setReviewerName(reviewerName);
        setGameName(gameName);
        setScore(score);
        setBody(body);
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Review) {
            Review a = (Review) o;
            if (this.getGameName().equals(a.getGameName())&&this.getReviewerName().equals(a.getReviewerName())) {
                return true;
            }
        }
        return false;
    }
}
