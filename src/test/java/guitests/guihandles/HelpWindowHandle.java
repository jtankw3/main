package guitests.guihandles;

import java.net.MalformedURLException;
import java.net.URL;

import guitests.GuiRobot;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * A handle to the {@code HelpWindow} of the application.
 */
public class HelpWindowHandle extends StageHandle {

    public static final String HELP_WINDOW_TITLE = "Help";

    private static final String HELP_WINDOW_BROWSER_ID = "#browser";

    public HelpWindowHandle(Stage helpWindowStage) {
        super(helpWindowStage);
    }

    /**
     * Returns true if a help window is currently present in the application.
     */
    public static boolean isWindowPresent() {
        return new GuiRobot().isWindowShown(HELP_WINDOW_TITLE);
    }

    /**
     * Returns the {@code URL} of the currently loaded page.
     */
    public URL getLoadedUrl() {
        try {
            WebView webView = getChildNode(HELP_WINDOW_BROWSER_ID);
            return new URL(webView.getEngine().getLocation());
        } catch (MalformedURLException mue) {
            throw new AssertionError("Invalid URL.", mue);
        }
    }
}
