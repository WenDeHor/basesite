package com.base.network.storage.serializer;

import com.base.network.model.Resume;
import com.base.network.util.JsonParser;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class JsonStreamSerializor implements StreamSerializer {
    @Override
    public void doWrite(Resume r, OutputStream os) throws IOException {
        try(Writer writer=new OutputStreamWriter(os, StandardCharsets.UTF_8)) {
            JsonParser.writer(r, writer);
        }
    }

    @Override
    public Resume doRead(InputStream is) throws IOException {
        try (Reader reader=new InputStreamReader(is, StandardCharsets.UTF_8)){
            return JsonParser.reader(reader, Resume.class);
        }

    }
}
