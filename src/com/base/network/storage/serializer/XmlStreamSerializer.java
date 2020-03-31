package com.base.network.storage.serializer;

import com.base.network.model.*;
import com.base.network.util.XmlParser;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class XmlStreamSerializer implements StreamSerializer {

    private XmlParser xmlParser;

    public XmlStreamSerializer() {
       xmlParser = new XmlParser(Resume.class, Organization.class, Link.class,
               OrganizationSections.class, TextSection.class,ListSection.class, Organization.Position.class);
    }

    @Override
    public void doWrite(Resume r, OutputStream os) throws IOException {
         try(Writer writer = new OutputStreamWriter(os, StandardCharsets.UTF_8)) {
             xmlParser.marshall(r, writer);
         }
    }

    @Override
    public Resume doRead(InputStream is) throws IOException {
        try(Reader reader=new InputStreamReader(is, StandardCharsets.UTF_8)){
            return xmlParser.unmarshall(reader);
        }

    }
}
