package dearBug;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class Controller implements Initializable{

    SecureRandom random=new SecureRandom();
    ArrayList<String> prize1List=new ArrayList<>();
    ArrayList<String> prize2List=new ArrayList<>();
    ArrayList<String> prize3List=new ArrayList<>();

    public Button prize1button;
    public Label prize1number;
    public Button prize2button;
    public Label prize2number;
    public ListView<String> prize2numberlist;
    public Button prize3button;
    public Label prize3number1;
    public Label prize3number2;
    public Label prize3number3;
    public Label prize3number4;
    public Label prize3number5;
    public Label prize3number6;
    public Label prize3number7;
    public Label prize3number8;
    public Label prize3number9;
    public Label prize3number10;
    public Label prize3LabelArray[]=new Label[10];
    public ListView<String> prize3numberlist;
    public TextField prize3add;


    Task taskprize1;
    Thread thprize1;

    public void drawPrize1(){

        if(prize1button.getText().equals("开始")){
            prize1button.setText("停止");
            taskprize1= new Task<Void>() {
                @Override
                public Void call() throws Exception {
                    while (true) {
                        String str = String.format("%04d", random.nextInt(2200));
                        Platform.runLater(() -> prize1number.setText(str));

                        if(isCancelled()){

                            updateMessage("Cancelled!");
                            break;
                        }
                        Thread.sleep(10);
                    }
                    return null;
                }
                @Override protected void cancelled() {
                    super.cancelled();
                    updateMessage("Cancelled!");
                }

            };
            thprize1 = new Thread(taskprize1);
            thprize1.setDaemon(true);
            thprize1.start();
         }else{
            prize1button.setText("开始");
            taskprize1.cancel();
            prize1List.add(prize1number.getText().toString());
            
        }


    }
    Task taskprize2;
    Thread thprize2;

    public void drawPrize2(){
        if(prize2button.getText().equals("开始")){
            prize2button.setText("停止");
            taskprize2= new Task<Void>() {
                @Override
                public Void call() throws Exception {
                    while (true) {
                        String str = String.format("%04d", random.nextInt(2200));
                        Platform.runLater(() -> prize2number.setText(str));

                        if(isCancelled()){

                            updateMessage("Cancelled!");
                            break;
                        }
                        Thread.sleep(10);
                    }
                    return null;
                }
                @Override protected void cancelled() {
                    super.cancelled();
                    updateMessage("Cancelled!");
                }

            };
            thprize2 = new Thread(taskprize2);
            thprize2.setDaemon(true);
            thprize2.start();
        }else{
            prize2button.setText("开始");
            taskprize2.cancel();
            thprize2.interrupt();
            prize2List.add(prize2number.getText().toString());
            prize2numberlist.setItems(FXCollections.observableArrayList (prize2List));

        }
    }

    Task taskprize3;
    Thread thprize3;

    public void drawPrize3(){
        int number = 10;
        if(prize3add.getText().trim().isEmpty()){
            number = 10;
        }else{
            try{
                number = Integer.parseInt(prize3add.getText().trim());
            } catch (NumberFormatException e){
                number = 0;
            }
        }
        if(number>10){
            number=10;
        }else if(number < 0){
            number=0;
        }
        if(prize3button.getText().equals("开始")){
            prize3button.setText("停止");
            int finalNumber = number;
            taskprize3 = new Task<Void>() {
                @Override
                public Void call() throws Exception {
                    while (true) {
                        Platform.runLater(() -> {
                            for(int i = 0; i< finalNumber; i++){
                                prize3LabelArray[i].setText(String.format("%04d", random.nextInt(2200)));
                            }
                            for(int i=finalNumber;i<10;i++){
                                prize3LabelArray[i].setText(String.format("0000"));
                            }
                        });

                        if(isCancelled()){
                            updateMessage("Cancelled!");
                            break;
                        }
                        Thread.sleep(10);
                    }
                    return null;
                }
                @Override protected void cancelled() {
                    super.cancelled();
                    updateMessage("Cancelled!");
                }

            };
            thprize3 = new Thread(taskprize3);
            thprize3.setDaemon(true);
            thprize3.start();
        }else{
            prize3button.setText("开始");
            taskprize3.cancel();
            thprize3.interrupt();
            for(int i=0;i<number;i++){
                prize3List.add(prize3LabelArray[i].getText());
            }
            ObservableList<String> data=FXCollections.observableArrayList (prize3List);
            prize3numberlist.setItems(data);
        }
    }

    public void drawLuckPrize(){

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        prize2numberlist.setOnMouseClicked(click -> {
            if(click.getClickCount() == 2){
                ObservableList<String> currentItem = prize2numberlist.getSelectionModel().getSelectedItems();
                prize2List.remove(currentItem.get(0));
                prize2numberlist.setItems(FXCollections.observableArrayList (prize2List));
            }
        });
        prize3LabelArray[0]=prize3number1;
        prize3LabelArray[1]=prize3number2;
        prize3LabelArray[2]=prize3number3;
        prize3LabelArray[3]=prize3number4;
        prize3LabelArray[4]=prize3number5;
        prize3LabelArray[5]=prize3number6;
        prize3LabelArray[6]=prize3number7;
        prize3LabelArray[7]=prize3number8;
        prize3LabelArray[8]=prize3number9;
        prize3LabelArray[9]=prize3number10;
        prize3numberlist.setOnMouseClicked(click -> {
            if(click.getClickCount() == 2){
                ObservableList<String> currentItem = prize3numberlist.getSelectionModel().getSelectedItems();
                prize3List.remove(currentItem.get(0));
                prize3numberlist.setItems(FXCollections.observableArrayList (prize3List));
            }
        });
    }
}


