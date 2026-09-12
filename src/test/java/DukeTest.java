import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

/** Tests Duke's response API. */
public class DukeTest {
    @Test
    public void getResponse_textInput_echoesInput() throws Exception {
        Method responseMethod = Duke.class.getMethod("getResponse", String.class);

        assertNotNull(responseMethod);
        assertEquals("Duke said: hello",
                responseMethod.invoke(new Duke(), "hello"));
    }
}
