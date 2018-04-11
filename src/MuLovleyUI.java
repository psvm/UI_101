import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MuLovleyUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    int count = 0;
    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Count me!");
        Button button = new Button("Click me");
        Slider sliderNew = new Slider();
        FlowPane pane  = new FlowPane(10, 10);

                primaryStage.setScene(new Scene(pane, 300,400));

                //по центру
        pane.setAlignment(Pos.CENTER);
                button.setOnAction(new EventHandler<ActionEvent>() {

            @Override
                public void handle(ActionEvent event) {
                count++;

                button.setText("Button's clicked "+count+" times");
                sliderNew.setValue(count);


            }
        });
                // Создаем два радио батона
        RadioButton onLight = new RadioButton("On");
        RadioButton offLight = new RadioButton("Off");

        // Создаем группу радио батонов
        ToggleGroup tg = new ToggleGroup();

        // Вводим радио батоны в группу
        onLight.setToggleGroup(tg);
        offLight.setToggleGroup(tg);
        // Обработка событий от радио батонов
        onLight.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                count++;
                button.setText("Button's clicked "+count+" times");
                sliderNew.setValue(count);
            }
        });
        offLight.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                count++;
                button.setText("Button's clicked "+count+" times");
                sliderNew.setValue(count);
            }
        });
        offLight.fire();

        // создаем текстовое поле
        Label scrollText = new Label(
                "dsgadgeagmefklgaeklrgnklaer\n"+
                "sjavnijdsvnasdjv\n"+
                "godgnoaegn\n"+
                "fadkofwejgoaergorkgkgroqrgk\n"+
                "woieoiweioior\n");
        ScrollPane newText = new ScrollPane(scrollText);

        newText.setPrefViewportHeight(60);
        newText.setPrefViewportWidth(150);
        newText.setPannable(true);

        //slider

        sliderNew.setMin(0);
        sliderNew.setMax(255);
        sliderNew.setShowTickLabels(true);
        sliderNew.setShowTickMarks(true);
        System.out.println((int)sliderNew.getValue());
        sliderNew.valueProperty().addListener(property->{count = (int)sliderNew.getValue(); button.setText("Button's clicked "+count+" times");});
        pane.getChildren().addAll(onLight, offLight, button,newText,sliderNew);
        primaryStage.show();
    }
}
