package id.co.javan.news.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import id.co.javan.news.entity.Berita;
import id.co.javan.news.entity.Field;

/**
 * FieldServices
 */
public class FormService {
    private List<Field> listField;

    private HashMap<String, Object> formData;

    public void setListField(List<Field> listField) {
        this.listField = listField;
    }

    public void setFormData(HashMap<String, Object> formData) {
        this.formData = formData;
    }

    public List<Field> getListField() {
        return listField;
    }

    public HashMap<String, Object> getFormData() {
        return formData;
    }

    public static FormService createBeritaForm() {
        FormService FieldServices = new FormService();
        List<Field> currentListField = new ArrayList<Field>();
        currentListField = new ArrayList<>();
        currentListField.add(new Field("Judul", "judul"));
        currentListField.add(new Field("Content", "content"));
        currentListField.add(new Field("Created By", "created_by"));
        FieldServices.setListField(currentListField);
        return FieldServices;
    }

    public void renderForm() {

        this.formData = new HashMap<>();

        for (Field field : this.listField) {
            this.formData.put(field.getAction(), this.askForm(field));
        }
    }
    public void renderForm(HashMap<String,  Object> currentValue) {

        this.formData = new HashMap<>();

        for (Field field : this.listField) {
            this.formData.put(field.getAction(), this.askForm(field,  (String) currentValue.get(field.getAction())));
        }
    }

    public String askForm(Field field) {
        Boolean responseInvalid = true;
        String data = "";
        while (responseInvalid) {

            System.out.print(field.getName() + " : ");

            Scanner myObj = new Scanner(System.in); // Create a Scanner object
            data = myObj.nextLine(); // Read user input
            responseInvalid = false;
            // TODO: Validate inputdata
        }
        return data;

    }

    public String askForm(Field field, String currentValue) {
        Boolean responseInvalid = true;
        String data = "";
        while (responseInvalid) {
            if(currentValue == null) {
                currentValue = "";
            }

            System.out.print(field.getName() + "(" + (currentValue == "" ? "" : (currentValue)) + ")" + " : ");

            Scanner myObj = new Scanner(System.in); // Create a Scanner object
            data = myObj.nextLine(); // Read user input
            responseInvalid = false;
            // TODO: Validate inputdata
        }
        return data;

    }

}