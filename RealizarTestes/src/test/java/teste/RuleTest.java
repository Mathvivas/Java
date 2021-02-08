package teste;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;


import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RuleTest {

    @Rule       // Garante que a pasta será criada antes do test
    public TemporaryFolder tempFolder = new TemporaryFolder();

    @Test
    public void shouldCreateNewFileInTemporaryFolder() throws IOException {
        File created = tempFolder.newFile("file.txt");

        assertTrue(created.isFile());       // Verifica se o arquivo foi criado
        assertEquals(tempFolder.getRoot(), created.getParentFile());
    }
}
