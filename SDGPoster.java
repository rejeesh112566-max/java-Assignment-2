package hellofx;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class SDGPoster extends Application {

    @Override
    public void start(Stage stage) {

        Label sdg = new Label("UN SUSTAINABLE DEVELOPMENT GOAL");
        sdg.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        sdg.setTextFill(Color.WHITE);

        Label number = new Label("SDG 4");
        number.setFont(Font.font("Arial", FontWeight.BOLD, 42));
        number.setTextFill(Color.WHITE);

        Label title = new Label("QUALITY EDUCATION");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        title.setTextFill(Color.WHITE);

        Label message = new Label(
            "Ensure inclusive and equitable quality education\n" +
            "and promote lifelong learning opportunities for all.");
        message.setFont(Font.font("Arial", 15));
        message.setTextFill(Color.WHITE);
        message.setWrapText(true);

        Label slogan = new Label(
            "\"Education is the key to a better future!\"");
        slogan.setFont(Font.font("Arial", FontWeight.BOLD, 17));
        slogan.setTextFill(Color.WHITE);

        Label progressLabel = new Label(
            "My commitment to lifelong learning");
        progressLabel.setTextFill(Color.WHITE);

        ProgressBar progress = new ProgressBar(0.7);
        progress.setPrefWidth(300);

        Label result = new Label("");
        result.setTextFill(Color.WHITE);
        result.setFont(Font.font("Arial", 14));

        Button learnButton = new Button("Start Learning");
        learnButton.setOnAction(e -> {
            result.setText(
                "Great! Keep learning something new every day.");
        });

        Button goalButton = new Button("My Learning Goal");
        goalButton.setOnAction(e -> {
            result.setText(
                "Goal: Learn one new skill every week!");
        });

        HBox buttons = new HBox(15, learnButton, goalButton);
        buttons.setAlignment(Pos.CENTER);

        VBox root = new VBox(
            18, sdg, number, title, message,
            slogan, progressLabel, progress, buttons, result
        );

        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(30));
        root.setStyle(
            "-fx-background-color: #B3262D;"
        );

        Scene scene = new Scene(root, 650, 600);

        stage.setTitle("SDG 4 - Quality Education");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

