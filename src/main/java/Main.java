import id.co.javan.news.controller.BeritaController;
import id.co.javan.news.entity.Menu;
import id.co.javan.news.services.MenuServices;

class Main {

    public static void main(String args[]) {
        Menu selectedMenu = null;
        Boolean isAppRun = true;

        System.out.println("Hello Javan");
        MenuServices ms = MenuServices.createHomeMenu();

        while (isAppRun) {
            if (selectedMenu == null || selectedMenu.getAction() == "HOME") {
                System.out.println("Menu: ");
                System.out.println(ms.renderMenu());
                selectedMenu = MenuServices.askMenu("Silahkan Pilih Menu", ms.getListMenu());

            } else {

                if (selectedMenu.getAction() == "EXIT") {
                    isAppRun = false;
                } else if (selectedMenu.getAction() == "LIST_BERITA") {
                    new BeritaController().index();
                    selectedMenu = null;
                } else if (selectedMenu.getAction() == "TAMBAH_BERITA") {
                    new BeritaController().createBerita();
                    selectedMenu = null;
                } else if (selectedMenu.getAction() == "PUB_UNPUB_BERITA") {
                    new BeritaController().unPublishBerita();
                    selectedMenu = null;

                }  else if (selectedMenu.getAction() == "REMOVE_BERITA") {
                    new BeritaController().deleteBerita();
                    selectedMenu = null;

                } else if (selectedMenu.getAction() == "UPDATE_BERITA") {
                    new BeritaController().updateBerita();
                    selectedMenu = null;

                }
            }
        }

    }

}