import domain.Config;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class XmlParserTest {
    @Test
    public void shouldParseXmlWhenValidInput() throws Exception {
        Config result = XmlParser.parse("src/test/resources/config.xml");

        assertNotNull(result);
        assertNotNull(result.getSubdomains());
        assertEquals(2, result.getSubdomains().getSubdomains().size());
        assertNotNull(result.getCookies());
        assertEquals(2, result.getCookies().getCookies().size());
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenNullPath() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            XmlParser.parse(null);
        });

        String expectedMessage = XmlParser.PATH_NULL_ERROR_MSG;
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenEmptyPath() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            XmlParser.parse("");
        });

        String expectedMessage = XmlParser.PATH_EMPTY_ERROR_MSG;
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
