package com.example.labb4.view;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

import java.util.ArrayList;

public class MenuView {
    private MenuBar menuBar;

    public MenuView() {
        Menu fileMenu = new Menu("File");
        MenuItem loadGame = new MenuItem("Load Game");
        MenuItem saveGame = new MenuItem("Save Game");
        MenuItem exitGame = new MenuItem("Exit Game");
        fileMenu.getItems().addAll(loadGame, saveGame, exitGame);

        Menu gameMenu = new Menu("Game");
        MenuItem newGame = new MenuItem("New Game");
//        MenuItem difficulty = new MenuItem("Difficulty");

        Menu difficultyMenu = new Menu("Difficulty");
        ArrayList<MenuItem> difficultyItems = new ArrayList<>();
        difficultyItems.add(new MenuItem("Easy"));
        difficultyItems.add(new MenuItem("Medium"));
        difficultyItems.add(new MenuItem("Hard"));
        difficultyMenu.getItems().addAll(difficultyItems);

        gameMenu.getItems().addAll(newGame, difficultyMenu);

        Menu helpMenu = new Menu("Help");
        MenuItem clear = new MenuItem("Clear");
        MenuItem check = new MenuItem("Check");
        MenuItem about = new MenuItem("About");
        helpMenu.getItems().addAll(clear, check, about);

        menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, gameMenu, helpMenu);
    }

    public MenuBar getMenuBar() {
        return menuBar;
    }
}
