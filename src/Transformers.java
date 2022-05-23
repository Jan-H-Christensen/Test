import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Transformers extends Application {

    Button btnTurnLeft, btnTurnRight;
    Slider changeSize;
    Label sliderText;
    Rectangle rec;
    ImageView iv;
    Image image;

    @Override
    public void start(Stage stage) throws Exception {

        Pane UIRoot = new Pane();
        Scene scene = new Scene(UIRoot,750, 750);
        scene.getStylesheets().add("Change.css");

        btnTurnLeft = new Button("Turn Left!");
        btnTurnLeft.setLayoutX(150);
        btnTurnLeft.setLayoutY(700);
        btnTurnLeft.setOnAction(this::rotationLeft);

        btnTurnRight = new Button("Turn Right!");
        btnTurnRight.setLayoutX(500);
        btnTurnRight.setLayoutY(700);
        btnTurnRight.setOnAction(event -> rotationRight());

        changeSize = new Slider();
        changeSize.setLayoutX(300);
        changeSize.setLayoutY(50);
        changeSize.setMin(-100);
        changeSize.setMax(100);
        changeSize.setValue(0);

        sliderText = new Label();
        sliderText.setLayoutX(325);
        sliderText.setLayoutY(25);
        sliderText.setText("Change Size!");

        //image = new Image("test.jpg");
        //iv = new ImageView(image);
        //iv.setLayoutX(25);
        //iv.setLayoutY(25);

        rec = new Rectangle(4, 2);
        rec.setLayoutX(375);
        rec.setLayoutY(400);
        rec.setFill(Color.YELLOW);

        changeSize.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                rec.setScaleX((double) newValue);  //scale
                rec.setScaleY((double) newValue);  //scale

            }
        });

        UIRoot.getChildren().addAll(btnTurnLeft,btnTurnRight,changeSize,sliderText,rec);

        stage.setScene(scene);
        stage.setTitle("Transform time!");
        stage.show();
    }

    public void rotationLeft(ActionEvent event){
        rec.setRotate(rec.getRotate() - 90.0);
    }

    public void rotationRight(){
        rec.setRotate(rec.getRotate() + 90.0);
    }

}
