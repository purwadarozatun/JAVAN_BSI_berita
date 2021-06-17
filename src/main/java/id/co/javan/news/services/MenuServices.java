package id.co.javan.news.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import id.co.javan.news.entity.Menu;

/**
 * MenuServices
 */
public class MenuServices {
    private List<Menu> listMenu;

    public void setListMenu(List<Menu> listMenu) {
        this.listMenu = listMenu;
    }

    public List<Menu> getListMenu() {
        return listMenu;
    }
    
    public static MenuServices createHomeMenu() {
        MenuServices menuServices = new MenuServices();
        List<Menu> currentListMenu = new ArrayList<Menu>();
        currentListMenu = new ArrayList<>();
        currentListMenu.add(new Menu("Home", "HOME"));
        currentListMenu.add(new Menu("Tambah Berita", "TAMBAH_BERITA"));
        currentListMenu.add(new Menu("List Berita", "LIST_BERITA"));
        currentListMenu.add(new Menu("Update Berita", "UPDATE_BERITA"));
        currentListMenu.add(new Menu("Hapus Berita", "REMOVE_BERITA"));
        currentListMenu.add(new Menu("Publish Unpublish Berita", "PUB_UNPUB_BERITA"));
        currentListMenu.add(new Menu("Exit", "EXIT"));
        menuServices.setListMenu(currentListMenu);
        return menuServices;
    }

    public String renderMenu() {
        String renderedMenu = "";
        Integer menuIndex = 1;
        for (Menu menu : this.listMenu) {
            renderedMenu += menuIndex.toString() + " : " + menu.getName() + "\n";
            menuIndex++;
        }
        return renderedMenu;
    }

    public static Menu askMenu(String message, List<Menu> menuData) {
        Boolean responseInvalid = true;
        Menu currentSelectedMenu = null;
        while (responseInvalid) {

            System.out.print(message +  " : ");

            Scanner myObj = new Scanner(System.in); // Create a Scanner object
            String itemIndex = myObj.nextLine(); // Read user input
            try {
                Integer selected = Integer.parseInt(itemIndex);
                System.out.println(selected);
                Menu selectedMenu = menuData.get(selected - 1);
                if (selectedMenu != null) {
                    currentSelectedMenu = selectedMenu;
                    responseInvalid = false;
                }

            } catch (Exception e) {
                System.out.println("Menu tidak valid atau tidak ditemukan.");
            }
        }
        return currentSelectedMenu;

    }

}