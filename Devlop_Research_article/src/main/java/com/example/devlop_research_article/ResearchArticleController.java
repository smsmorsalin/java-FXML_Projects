package com.example.devlop_research_article;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class ResearchArticleController
{
    @javafx.fxml.FXML
    private CheckBox fxid_citationStatusField;
    @javafx.fxml.FXML
    private ComboBox<String> fxid_searchArticleType;
    @javafx.fxml.FXML
    private Label fxid_messageField;
    @javafx.fxml.FXML
    private TextArea fxid_TextAreaToShowHightestAuthor;
    @javafx.fxml.FXML
    private TextField fxid_filterStartDate;
    @javafx.fxml.FXML
    private TableView<Article> fxid_TableView;
    @javafx.fxml.FXML
    private TableColumn<Article, String> fxid_TableViewColTitle;
    @javafx.fxml.FXML
    private TextField fxid_filterEndDate;
    @javafx.fxml.FXML
    private ComboBox<String> fxid_articleTypeField;
    @javafx.fxml.FXML
    private DatePicker fxid_publicationDateField;
    @javafx.fxml.FXML
    private CheckBox fxid_searchCitationStatus;
    @javafx.fxml.FXML
    private TableColumn<Article, Integer> fxid_TableViewNoOfAuthor;
    @javafx.fxml.FXML
    private TableColumn<Article, String> fxid_TableViewAuthorType;
    @javafx.fxml.FXML
    private TextField fxid_authorNameField;
    @javafx.fxml.FXML
    private TableColumn<Article, String> fxid_TableViewAuthorName;
    @javafx.fxml.FXML
    private TextField fxid_titleField;
    @javafx.fxml.FXML
    private TextField fxid_noOfAuthorField;

    ArrayList<Article> ArticleList;

    @javafx.fxml.FXML
    public void initialize() {
        ArticleList = new ArrayList<Article>();

        fxid_articleTypeField.getItems().addAll("review", "Book", "Case");
        fxid_searchArticleType.getItems().addAll("review", "Book", "Case");

        fxid_TableViewColTitle.setCellValueFactory(new PropertyValueFactory<Article, String>("Title"));
        fxid_TableViewAuthorName.setCellValueFactory(new PropertyValueFactory<Article, String>("Author"));
        fxid_TableViewAuthorType.setCellValueFactory(new PropertyValueFactory<Article, String>("Article_Type"));
        fxid_TableViewNoOfAuthor.setCellValueFactory(new PropertyValueFactory<Article, Integer>("No_of_Authors"));
    }

    @javafx.fxml.FXML
    public void addArticleButtonMouseOnClicked(ActionEvent actionEvent) {
        if(fxid_articleTypeField.getItems().isEmpty() || fxid_authorNameField.getText().isEmpty() || fxid_authorNameField.getText().isEmpty() || fxid_noOfAuthorField.getText().isEmpty() || fxid_publicationDateField.getValue() == null){
            fxid_messageField.setText("Text Filed Can't be Empty");
            return;
        }
        for(Article A: ArticleList){
            if(A.getTitle().equals(fxid_titleField.getText())){
                fxid_messageField.setText("Title already Exist");
                fxid_titleField.clear();
                return;
            }

        }

        ArticleList.add(new Article(
                fxid_titleField.getText(),
                fxid_authorNameField.getText(),
                fxid_articleTypeField.getValue(),
                fxid_publicationDateField.getValue(),
                fxid_citationStatusField.isSelected(),
                Integer.parseInt(fxid_noOfAuthorField.getText())
        ));

        fxid_messageField.setText("Article Created successfully");

        fxid_titleField.clear();
        fxid_authorNameField.clear();
        fxid_noOfAuthorField.clear();
    }

    @javafx.fxml.FXML
    public void SearchAirticleOnClick(ActionEvent actionEvent) {
        fxid_TableView.getItems().clear();
        for(Article A: ArticleList){
            if((A.getArticle_Type().equals(fxid_searchArticleType.getValue()) && A.isCitation_status()== fxid_searchCitationStatus.isSelected()) ){
                fxid_TableView.getItems().add(A);
                System.out.println(A.toString());
            }
        }
    }

    @javafx.fxml.FXML
    public void showArticleWithHighestAuthorButtonMouseOnClicked(ActionEvent actionEvent) {
        if (ArticleList.isEmpty()) {
            fxid_TextAreaToShowHightestAuthor.setText("No articles available.");
            return;
        }

        int maxAuthors = ArticleList.get(0).getNo_of_Authors();

        // Find maximum
        for (Article a : ArticleList) {
            if (a.getNo_of_Authors() > maxAuthors) {
                maxAuthors = a.getNo_of_Authors();
            }
        }

        // Show article titles with max authors
        StringBuilder result = new StringBuilder();

        for (Article a : ArticleList) {
            if (a.getNo_of_Authors() == maxAuthors) {
                result.append(a.getTitle())
                        .append(" (")
                        .append(maxAuthors)
                        .append(" authors)\n");
            }
        }

        fxid_TextAreaToShowHightestAuthor.setText(result.toString());
    }

    @javafx.fxml.FXML
    public void YearFilterButtonOnClick(ActionEvent actionEvent) {
        fxid_TableView.getItems().clear();

        int startYear = Integer.parseInt(fxid_filterStartDate.getText());
        int endYear = Integer.parseInt(fxid_filterEndDate.getText());

        for (Article a : ArticleList) {

            int articleYear = a.getPublication_date().getYear();

            if (articleYear >= startYear && articleYear <= endYear) {
                fxid_TableView.getItems().add(a);
            }
        }
    }
}