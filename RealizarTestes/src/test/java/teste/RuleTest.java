package teste;

import org.junit.jupiter.api.Test;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;


import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RuleTest {

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    @Test
    void shouldCreateNewFileInTemporaryFolder() throws IOException {
        File created = tempFolder.newFile("file.txt");

        assertTrue(created.isFile());       // Verifica se o arquivo foi criado
        assertEquals(tempFolder.getRoot(), created.getParentFile());
    }
}
