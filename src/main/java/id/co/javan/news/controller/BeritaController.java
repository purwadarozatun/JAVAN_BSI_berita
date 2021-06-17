package id.co.javan.news.controller;

import java.util.List;

import id.co.javan.news.entity.Berita;
import id.co.javan.news.services.BeritaService;
import id.co.javan.news.utils.TableUtils;

public class BeritaController {

    BeritaService beritaService;

    public BeritaController() {
        this.beritaService = new BeritaService();
    }

    public void index() {

        List<Berita> beritaList = this.beritaService.getAllBerita();

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

}
