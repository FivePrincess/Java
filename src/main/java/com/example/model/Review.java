package main.java.com.example.model;

public class Review {
    private String guesthouseName;
    private String visitDates;
    private int rating;
    private String content;

    public Review(String guesthouseName, String visitDates, int rating, String content) {
        this.guesthouseName = guesthouseName;
        this.visitDates = visitDates;
        this.rating = rating;
        this.content = content;
    }

    @Override
    public String toString() {
        return "<html>" +
                "<strong>게스트하우스:</strong> " + guesthouseName + "<br>" +
                "<strong>방문 기간:</strong> " + visitDates + "<br>" +
                "<strong>평점:</strong> " + rating + " / 5<br>" +
                "<strong>리뷰 내용:</strong> " + content +
                "</html>";
    }
}
