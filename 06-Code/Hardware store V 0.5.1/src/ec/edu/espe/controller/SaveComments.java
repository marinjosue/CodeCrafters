/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.controller;

/**
 *
 * @author Mesias Mariscal, CodeCrafters; DCCO-ESPE
 */
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ec.edu.espe.model.Comment;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SaveComments {
    private static final String FILE_NAME = "comments.json";

    public static void save(List<Comment> newComments) {
        List<Comment> comments = new ArrayList<>();
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Comment>>() {}.getType();

        try (FileReader reader = new FileReader(FILE_NAME)) {
            comments = gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        comments.addAll(newComments);
        String json = gson.toJson(comments, listType);

        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Comment> load() {
        List<Comment> comments = new ArrayList<>();
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Comment>>() {}.getType();

        try (FileReader reader = new FileReader(FILE_NAME)) {
            comments = gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return comments;
    }
}




