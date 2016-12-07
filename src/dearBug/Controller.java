package dearBug;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.security.SecureRandom;

import static java.lang.Thread.sleep;


public class Controller {

    SecureRandom random=new SecureRandom();
    int prize1List[];
    int prize2List[];
    int prize3List[];
    int prizeLuckList[];

    public Button prize1button;
    public Label prize1number;


    public void drawPrize1(ActionEvent actionEvent){

        if(prize1button.getText().equals("开始")){
            prize1button.setText("停止");
            Platform.runLater(() -> {
                while (true){
                    prize1number.setText(""+random.nextInt(3000));
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

                prize1number.setText("0280");

         }else{
            prize1button.setText("开始");
            //p1s.interrupt();
        }

    }

    void draw1Prize(){

    }

    void draw2Prize(){

    }

    void draw3Prize(){

    }

    void drawLuckPrize(){

    }

}
