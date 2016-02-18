package domain;

/**
 * Created by Tim on 14/02/2016.
 */
public class Review {

    private String reviewerName;
    private String gameName;
    private double score;
    private String body;

    public Review(String reviewerName, String gameName, double score, String body) {
        setReviewerName(reviewerName);
        setGameName(gameName);
        setScore(score);
        setBody(body);
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        if (gameName != null && !gameName.isEmpty()) {
            this.gameName = gameName;
        } else {
            throw new DomainException("The game name must be filled in");
        }
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        if (reviewerName != null && !reviewerName.isEmpty()) {
            this.reviewerName = reviewerName;
        } else {
            throw new DomainException("The reviewer name must be filled in");
        }
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        if (score >= 0 && score <= 10) {
            this.score = score;
        } else {
            throw new DomainException("The score must be between 0 and 10");
        }
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        if(body!=null&&!body.isEmpty()) {
            this.body = body;
        }else{
            throw new DomainException("The review body may not be empty");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Review) {
            Review a = (Review) o;
            if (this.getGameName().equals(a.getGameName()) && this.getReviewerName().equals(a.getReviewerName()) && this.getScore() == a.getScore() && this.getBody().equals(a.getBody())) {
                return true;
            }
        }
        return false;
    }
}
