package id.co.javan.news.controller;

import java.io.Console;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import id.co.javan.news.entity.Berita;
import id.co.javan.news.entity.Field;
import id.co.javan.news.services.BeritaService;
import id.co.javan.news.services.FormService;
import id.co.javan.news.utils.TableUtils;

public class BeritaController {

    BeritaService beritaService;

    public BeritaController() {
        this.beritaService = new BeritaService();
    }

    private void rendertable(List<Berita> beritaList) {

        TableUtils tableUtils = new TableUtils();
        tableUtils.setShowVerticalLines(true);
        tableUtils.setHeaders("Id", "Judul", "Slug", "Content", "Created By", "Published");
        System.out.println();
        for (Berita berita : beritaList) {
            tableUtils.addRow(berita.getId().toString(), berita.getJudul(), berita.getSlug(), berita.getContent(),
                    berita.getCreatedBy(), (berita.getPublished() == 1 ? "Published" : "Not Published")

            );

        }
        tableUtils.print();
    }

    public void index() {
        List<Berita> beritaList = this.beritaService.getAllBerita();
        this.rendertable(beritaList);
        
    }

    public void createBerita() {
        FormService formService = FormService.createBeritaForm();
        formService.renderForm();
        HashMap<String, Object> data = formService.getFormData();
        Berita berita = new Berita();
        berita.setJudul((String) data.get("judul"));
        berita.setContent((String) data.get("content"));
        berita.setCreatedBy((String) data.get("created_by"));
        berita.setPublished(1);
        if (this.beritaService.saveBerita(berita)) {
            System.out.println("Data Berita Berhasil Di Tambahkan");
        } else {

            System.out.println("Terjadi kesalahan ketika menambahkan berita");
        }

    }

    public void unPublishBerita() {
        List<Berita> beritaList = this.beritaService.getAllBerita();
        this.rendertable(beritaList);

        Boolean responseInvalid = true;
        String data = "";

        Berita berita = null;
        while (responseInvalid) {

            System.out.print("Silahkan masukan id yang akan diunpublish / dipublish : ");

            Scanner myObj = new Scanner(System.in); // Create a Scanner object
            data = myObj.nextLine(); // Read user input

            for (Berita berita2 : beritaList) {
                if (berita2.getId().toString().equals(data)) {
                    berita = berita2;
                    continue;
                }
            }
            if (berita != null) {

                responseInvalid = false;
            }
            // TODO: Validate inputdata

        }
        if (this.beritaService.publishUnpublishBerita(berita)) {
            System.out.println("Berhasil mengubah status publish berita");
        } else {

            System.out.println("Gagal mengubah status publish berita");
        }

    }

    public void deleteBerita() {
        List<Berita> beritaList = this.beritaService.getAllBerita();
        this.rendertable(beritaList);

        Boolean responseInvalid = true;
        String data = "";

        Berita berita = null;
        while (responseInvalid) {

            System.out.print("Silahkan masukan id yang akan dihapus : ");

            Scanner myObj = new Scanner(System.in); // Create a Scanner object
            data = myObj.nextLine(); // Read user input

            for (Berita berita2 : beritaList) {
                if (berita2.getId().toString().equals(data)) {
                    berita = berita2;
                    continue;
                }
            }
            if (berita != null) {

                responseInvalid = false;
            }
            // TODO: Validate inputdata

        }
        if (this.beritaService.deleteBerita(berita)) {
            System.out.println("Berhasil menghapus berita");
        } else {

            System.out.println("Gagal menghapus berita");
        }

    }

    public void updateBerita() {
        List<Berita> beritaList = this.beritaService.getAllBerita();
        this.rendertable(beritaList);

        Boolean responseInvalid = true;
        String data = "";

        Berita berita = null;
        while (responseInvalid) {

            System.out.print("Silahkan masukan id yang akan diunpublish / dipublish : ");

            Scanner myObj = new Scanner(System.in); // Create a Scanner object
            data = myObj.nextLine(); // Read user input

            for (Berita berita2 : beritaList) {
                if (berita2.getId().toString().equals(data)) {
                    berita = berita2;
                    continue;
                }
            }
            if (berita != null) {

                responseInvalid = false;
            }
            // TODO: Validate inputdata

        }

        FormService formService = FormService.createBeritaForm();
        HashMap<String, Object> beritaMap = this.beritaService.getBeritaHashmap(berita);
        formService.renderForm(beritaMap);
        HashMap<String, Object> updatedMap = formService.getFormData();
        berita.setJudul((String) updatedMap.get("judul"));
        berita.setContent((String) updatedMap.get("content"));
        berita.setCreatedBy((String) updatedMap.get("created_by"));

        if (this.beritaService.updateBerita(berita)) {
            System.out.println("Berhasil mengubah  berita");
        } else {

            System.out.println("Gagal mengubah berita");
        }

    }
}
