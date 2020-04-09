package com.base.network.util;

import com.base.network.model.Resume;
import com.base.network.model.Section;
import com.base.network.model.TextSection;
import org.junit.Assert;
import org.junit.Test;

import static com.base.network.TestData.R1;

public class JsonParserTest {

    @Test
    public void read() throws Exception {
        String json=JsonParser.write(R1);
        System.out.println(json);
        Resume resume=JsonParser.read(json, Resume.class);
        Assert.assertEquals(R1, resume);
    }

    @Test
    public void write() throws Exception{
        Section section1=new TextSection("Objective1");
        String json=JsonParser.write(section1, Section.class);
        Section section2=JsonParser.read(json, Section.class);
        Assert.assertEquals(section1, section2);
    }
}