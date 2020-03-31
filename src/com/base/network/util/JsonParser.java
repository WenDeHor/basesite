package com.base.network.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Reader;
import java.io.Writer;

public class JsonParser {
    private static Gson GSON = new GsonBuilder()
//            .registerTypeAdapter(Section.class, new JsonSectionAdapter())
            .create();

    public static <T> T reader(Reader reader, Class<T> clazz) {
        return GSON.fromJson(reader, clazz);
    }

    public static <T> void writer(T object, Writer writer) {
        GSON.toJson(object, writer);
    }
}
