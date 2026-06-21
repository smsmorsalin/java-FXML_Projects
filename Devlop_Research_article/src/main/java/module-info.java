module com.example.devlop_research_article {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.devlop_research_article to javafx.fxml;
    exports com.example.devlop_research_article;
}