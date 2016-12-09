package dearBug;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.io.*;
import java.net.URL;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    SecureRandom random=new SecureRandom();
    ArrayList<String> prize1List =new ArrayList<>();
    ArrayList<String> prize2List =new ArrayList<>();
    ArrayList<String> prize3List =new ArrayList<>();
    ArrayList<String> prize4List =new ArrayList<>();

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

    public Button prizeLuckyButton;
    public Label prizeLucky1;
    public Label prizeLucky2;
    public Label prizeLucky3;
    public Label prizeLucky4;
    public Label prizeLucky5;
    public Label prizeLucky6;
    public Label prizeLucky7;
    public Label prizeLucky8;
    public Label prizeLucky9;
    public Label prizeLucky10;
    public Label prize4LabelArray[]=new Label[10];
    public ListView<String> prizeLuckyList;
    public TextField prizeLuckyAdd;

    public Tab recordTab;
    public Label r1l;

    public Label r2l1;
    public Label r2l2;
    public Label r2l3;
    public Label prize2RecordArray[]=new Label[3];

    public Label r3l1;
    public Label r3l2;
    public Label r3l3;
    public Label r3l4;
    public Label r3l5;
    public Label r3l6;
    public Label r3l7;
    public Label r3l8;
    public Label r3l9;
    public Label r3l10;
    public Label prize3RecordArray[]=new Label[10];

    public Label r4l1;
    public Label r4l2;
    public Label r4l3;
    public Label r4l4;
    public Label r4l5;
    public Label r4l6;
    public Label r4l7;
    public Label r4l8;
    public Label r4l9;
    public Label r4l10;
    public Label r4l11;
    public Label r4l12;
    public Label r4l13;
    public Label r4l14;
    public Label r4l15;
    public Label r4l16;
    public Label r4l17;
    public Label r4l18;
    public Label r4l19;
    public Label r4l20;
    public Label r4l21;
    public Label r4l22;
    public Label r4l23;
    public Label r4l24;
    public Label r4l25;
    public Label r4l26;
    public Label r4l27;
    public Label r4l28;
    public Label r4l29;
    public Label r4l30;
    public Label prize4RecordArray[]=new Label[30];

    public Label record1Label;
    public Label record2Label;
    public Label record3Label;
    public Label record4Label;



    public static void deletFile(String fileName){
        File file=new File(fileName);
        file.delete();
    }
    public static void writeFile(String fileName,ArrayList<String> arrayList) {
        try {
            FileWriter writer=new FileWriter(fileName);
            for(int i=0;i<arrayList.size();i++){
                writer.write(arrayList.get(i)+"\n");
            }
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
         }
    }

    public static ArrayList<String> readFile(String fileName){
        String line;
        ArrayList<String> record = new ArrayList<>();
        File file=new File(fileName);
        if(file.exists()){
            try {
                BufferedReader in=new BufferedReader(new FileReader(fileName));
                line=in.readLine();
                while (line!=null){
                    record.add(line);
                    line=in.readLine();
                }
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return record;
        }else{
            return new ArrayList<>();
        }

    }

    Task taskprize1;
    Thread thprize1;

    public void drawPrize1(){

        if(prize1button.getText().equals("开始")){
            prize1button.setText("停止");
            taskprize1= new Task<Void>() {
                @Override
                public Void call() throws Exception {
                    while (true) {
                        String str = String.format("%04d", random.nextInt(Config.SUM_NUMBER));
                        String finalStr = str;
                        Platform.runLater(() -> prize1number.setText(finalStr));

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
            thprize1.interrupt();
            try {
                thprize1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            prize1List.add(prize1number.getText());
            ArrayList<String> record1=new ArrayList<>();
            record1.add(prize1number.getText());
            writeFile("./1",record1);
            
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
                        String str = String.format("%04d", random.nextInt(Config.SUM_NUMBER));
                        String finalStr = str;
                        Platform.runLater(() -> prize2number.setText(finalStr));

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
            try {
                thprize2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            prize2List.add(prize2number.getText());
            prize2numberlist.setItems(FXCollections.observableArrayList (prize2List));
            writeFile("./2",prize2List);

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
                                prize3LabelArray[i].setTextFill(Color.web("#000000"));
                                prize3LabelArray[i].setText(String.format("%04d", random.nextInt(Config.SUM_NUMBER)));
                            }
                            for(int i=finalNumber;i<Config.PRIZE_3_NUMBER;i++){
                                prize3LabelArray[i].setTextFill(Color.web("#383838"));
                                prize3LabelArray[i].setText(String.format("0000"));
                            }
                        });

                        if(isCancelled()){
//                            for(int i=0;i<finalNumber;i++){
//                                String strtemp=prize3LabelArray[i].getText();
//                                while(prize3List.contains(strtemp)){
//                                    strtemp = String.format("%04d", random.nextInt(Config.SUM_NUMBER));
//                                    String finalStr1 = strtemp;
//                                    int finalI = i;
//                                    Platform.runLater(() -> prize3LabelArray[finalI].setText(finalStr1));
//                                }
//                            }
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
            try {
                thprize3.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(int i=0;i<number;i++){
                prize3List.add(prize3LabelArray[i].getText());
            }
            ObservableList<String> data=FXCollections.observableArrayList (prize3List);
            prize3numberlist.setItems(data);
            writeFile("./3",prize3List);
        }
    }


    Task taskprize4;
    Thread thprize4;

    public void drawLuckPrize(){
        int number = 10;
        if(prizeLuckyAdd.getText().trim().isEmpty()){
            number = 10;
        }else{
            try{
                number = Integer.parseInt(prizeLuckyAdd.getText().trim());
            } catch (NumberFormatException e){
                number = 0;
            }
        }
        if(number>10){
            number=10;
        }else if(number < 0){
            number=0;
        }

        if(prizeLuckyButton.getText().equals("开始")){
            prizeLuckyButton.setText("停止");
            int finalNumber = number;
            taskprize4 = new Task<Void>() {
                @Override
                public Void call() throws Exception {
                    while (true) {
                        Platform.runLater(() -> {
                            for(int i = 0; i< finalNumber; i++){
                                prize4LabelArray[i].setTextFill(Color.web("#000000"));
                                prize4LabelArray[i].setText(String.format("%04d", random.nextInt(Config.SUM_NUMBER)));
                            }
                            for(int i=finalNumber;i<10;i++){
                                prize4LabelArray[i].setTextFill(Color.web("#383838"));
                                prize4LabelArray[i].setText(String.format("0000"));
                            }
                        });

                        if(isCancelled()){
//                            for(int i=0;i<finalNumber;i++){
//                                String strtemp= prize4LabelArray[i].getText();
//                                while(prize4List.contains(strtemp)){
//                                    strtemp = String.format("%04d", random.nextInt(Config.SUM_NUMBER));
//                                    String finalStr1 = strtemp;
//                                    int finalI = i;
//                                    Platform.runLater(() -> prize4LabelArray[finalI].setText(finalStr1));
//                                }
//                            }
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
            thprize4 = new Thread(taskprize4);
            thprize4.setDaemon(true);
            thprize4.start();
        }else{
            prizeLuckyButton.setText("开始");
            taskprize4.cancel();
            thprize4.interrupt();
            try {
                thprize4.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(int i=0;i<number;i++){
                prize4List.add(prize4LabelArray[i].getText());
            }
            ObservableList<String> data=FXCollections.observableArrayList (prize4List);
            prizeLuckyList.setItems(data);

            writeFile("./4",prize4List);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        prize1List =new ArrayList<>();
        prize2List =new ArrayList<>();
        prize3List =new ArrayList<>();
        prize4List =new ArrayList<>();

        prize2numberlist.setOnMouseClicked(click -> {
            if(click.getClickCount() == 2){
                ObservableList<String> currentItem = prize2numberlist.getSelectionModel().getSelectedItems();
                prize2List.remove(currentItem.get(0));
                prize2numberlist.setItems(FXCollections.observableArrayList (prize2List));
                writeFile("./2",prize2List);
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
                writeFile("./3",prize3List);
            }
        });

        prize4LabelArray[0]=prizeLucky1;
        prize4LabelArray[1]=prizeLucky2;
        prize4LabelArray[2]=prizeLucky3;
        prize4LabelArray[3]=prizeLucky4;
        prize4LabelArray[4]=prizeLucky5;
        prize4LabelArray[5]=prizeLucky6;
        prize4LabelArray[6]=prizeLucky7;
        prize4LabelArray[7]=prizeLucky8;
        prize4LabelArray[8]=prizeLucky9;
        prize4LabelArray[9]=prizeLucky10;

        prizeLuckyList.setOnMouseClicked(click -> {
            if(click.getClickCount() == 2){
                ObservableList<String> currentItem = prizeLuckyList.getSelectionModel().getSelectedItems();
                prize4List.remove(currentItem.get(0));
                prizeLuckyList.setItems(FXCollections.observableArrayList (prize4List));
                writeFile("./4",prize4List);
            }
        });

        //public Label r1l;

        prize2RecordArray[0]=r2l1;
        prize2RecordArray[1]=r2l2;
        prize2RecordArray[2]=r2l3;

        prize3RecordArray[0]=r3l1;
        prize3RecordArray[1]=r3l2;
        prize3RecordArray[2]=r3l3;
        prize3RecordArray[3]=r3l4;
        prize3RecordArray[4]=r3l5;
        prize3RecordArray[5]=r3l6;
        prize3RecordArray[6]=r3l7;
        prize3RecordArray[7]=r3l8;
        prize3RecordArray[8]=r3l9;
        prize3RecordArray[9]=r3l10;

        prize4RecordArray[0]=r4l1;
        prize4RecordArray[1]=r4l2;
        prize4RecordArray[2]=r4l3;
        prize4RecordArray[3]=r4l4;
        prize4RecordArray[4]=r4l5;
        prize4RecordArray[5]=r4l6;
        prize4RecordArray[6]=r4l7;
        prize4RecordArray[7]=r4l8;
        prize4RecordArray[8]=r4l9;
        prize4RecordArray[9]=r4l10;
        prize4RecordArray[10]=r4l11;
        prize4RecordArray[11]=r4l12;
        prize4RecordArray[12]=r4l13;
        prize4RecordArray[13]=r4l14;
        prize4RecordArray[14]=r4l15;
        prize4RecordArray[15]=r4l16;
        prize4RecordArray[16]=r4l17;
        prize4RecordArray[17]=r4l18;
        prize4RecordArray[18]=r4l19;
        prize4RecordArray[19]=r4l20;
        prize4RecordArray[20]=r4l21;
        prize4RecordArray[21]=r4l22;
        prize4RecordArray[22]=r4l23;
        prize4RecordArray[23]=r4l24;
        prize4RecordArray[24]=r4l25;
        prize4RecordArray[25]=r4l26;
        prize4RecordArray[26]=r4l27;
        prize4RecordArray[27]=r4l28;
        prize4RecordArray[28]=r4l29;
        prize4RecordArray[29]=r4l30;

        record1Label.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getClickCount() == 2){
                    deletFile("./1");
                    r1l.setText("");
                }
            }
        });
        record2Label.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getClickCount() == 2){
                    deletFile("./2");
                    for(int i=0;i<Config.PRIZE_2_NUMBER;i++){
                        prize2RecordArray[i].setText("");
                    }
                }
            }
        });
        record3Label.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getClickCount() == 2){
                    deletFile("./3");
                    for(int i=0;i<Config.PRIZE_3_NUMBER;i++){
                        prize3RecordArray[i].setText("");
                    }
                }
            }
        });
        record4Label.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getClickCount() == 2){
                    deletFile("./4");
                    for(int i=0;i<Config.PRIZE_LUCKY_NUMBER;i++){
                        prize4RecordArray[i].setText("");
                    }
                }
            }
        });
        recordTab.setOnSelectionChanged(new EventHandler < Event > () {

            @Override
            public void handle(Event event) {
                r1l.setText("");
                for(int i=0;i<Config.PRIZE_2_NUMBER;i++){
                    prize2RecordArray[i].setText("");
                }
                for(int i=0;i<Config.PRIZE_3_NUMBER;i++){
                    prize3RecordArray[i].setText("");
                }
                for(int i=0;i<Config.PRIZE_LUCKY_NUMBER;i++){
                    prize4RecordArray[i].setText("");
                }

                prize1List=readFile("./1");
                if(prize1List!=null && !prize1List.isEmpty()){
                    r1l.setText(prize1List.get(prize1List.size()-1));
                }

                prize2List=readFile("./2");
                if(prize2List!=null && !prize2List.isEmpty()){
                   for(int i=0;i<prize2List.size() && i<Config.PRIZE_2_NUMBER;i++){
                       prize2RecordArray[i].setText(prize2List.get(i));
                   }
                }
                prize3List=readFile("./3");
                if(prize3List!=null && !prize3List.isEmpty()){
                    for(int i=0;i<prize3List.size() && i<Config.PRIZE_3_NUMBER;i++){
                        prize3RecordArray[i].setText(prize3List.get(i));
                    }
                }
                prize4List=readFile("./4");
                if(prize4List!=null && !prize4List.isEmpty()){
                    for(int i=0;i<prize4List.size() && i<Config.PRIZE_LUCKY_NUMBER;i++){
                        prize4RecordArray[i].setText(prize4List.get(i));
                    }
                }
            }
        });
    }
}


