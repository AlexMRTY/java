package com.example.labb4;

import com.example.labb4.view.GridView;
import com.example.labb4.view.MenuView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        BorderPane root = new BorderPane();

        MenuBar menuBar = new MenuView().getMenuBar();
        root.setTop(menuBar);

        int[][][] levelData = SudokuUtilities.generateSudokuMatrix(SudokuUtilities.SudokuLevel.EASY);

        GridView gridView = new GridView(levelData);
        TilePane numberPane = gridView.getNumberPane();
        root.setCenter(numberPane);

        Scene scene = new Scene(root, 500, 500);

        stage.setTitle("Sudoku");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.setResizable(false);
        stage.show();
    }
}
