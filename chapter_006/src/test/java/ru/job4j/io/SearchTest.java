package ru.job4j.io;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class SearchTest {

    @Test
    public void whenExistsOnePptThenOnePpt() throws IOException {
        final File startDir = new File(System.getProperty("java.io.tmpdir")
                                + "searchTest1"
                                + System.currentTimeMillis());
        final File file1 = new File(startDir, "file1.pdf");
        final File file2 = new File(startDir, "file2.ppt");
        final File dir1 = new File(startDir + System.getProperty("file.separator") + "dir1");
        final File dir2 = new File(startDir + System.getProperty("file.separator") + "dir2");
        final File file3 = new File(dir2, "file3.pdf");
        final File file4 = new File(dir2, "file4.pdf");
        startDir.mkdir();
        file1.createNewFile();
        file2.createNewFile();
        dir1.mkdir();
        dir2.mkdir();
        file3.createNewFile();
        file4.createNewFile();
        Search search = new Search();
        List<String> exts = new ArrayList<>();
        exts.add("ppt");
        List<File> expected = new ArrayList<>();
        expected.add(file2);
        assertThat(search.files(startDir.toString(), exts), is(expected));
    }

    @Test
    public void whenExists3PdfThen3Ppt() throws IOException {
        final File startDir = new File(System.getProperty("java.io.tmpdir")
                + "searchTest2"
                + System.currentTimeMillis());
        final File file1 = new File(startDir, "file1.pdf");
        final File file2 = new File(startDir, "file2.ppt");
        final File dir1 = new File(startDir + System.getProperty("file.separator") + "dir1");
        final File dir2 = new File(startDir + System.getProperty("file.separator") + "dir2");
        final File file3 = new File(dir2, "file3.pdf");
        final File file4 = new File(dir2, "file4.pdf");
        startDir.mkdir();
        file1.createNewFile();
        file2.createNewFile();
        dir1.mkdir();
        dir2.mkdir();
        file3.createNewFile();
        file4.createNewFile();
        Search search = new Search();
        List<String> exts = new ArrayList<>();
        exts.add("pdf");
        List<File> expected = new ArrayList<>();
        expected.add(file1);
        expected.add(file3);
        expected.add(file4);
        assertThat(search.files(startDir.toString(), exts), is(expected));
    }

    @Test
    public void whensearchXMLandNoXmlThenReturEmpyList() throws IOException {
        final File startDir = new File(System.getProperty("java.io.tmpdir")
                + "searchTest3"
                + System.currentTimeMillis());
        final File file1 = new File(startDir, "file1.pdf");
        final File file2 = new File(startDir, "file2.ppt");
        final File dir1 = new File(startDir + System.getProperty("file.separator") + "dir1");
        final File dir2 = new File(startDir + System.getProperty("file.separator") + "dir2");
        final File file3 = new File(dir2, "file3.pdf");
        final File file4 = new File(dir2, "file4.pdf");
        startDir.mkdir();
        file1.createNewFile();
        file2.createNewFile();
        dir1.mkdir();
        dir2.mkdir();
        file3.createNewFile();
        file4.createNewFile();
        Search search = new Search();
        List<String> exts = new ArrayList<>();
        exts.add("xml");
        List<File> expected = new ArrayList<>();
        assertThat(search.files(startDir.toString(), exts), is(expected));
    }
}