package eu.convertron.core.tabs;

import eu.convertron.core.Control;
import eu.convertron.interlib.data.Configuration;
import eu.convertron.interlib.data.SingleConfigurationListener;
import eu.convertron.interlib.interfaces.View;
import java.nio.charset.StandardCharsets;
import javax.swing.JTextField;

public class OverviewControl
{
    private OverviewView view;
    private JTextField motdTxt;
    private Configuration config;

    private Control control;

    public OverviewControl(Control control)
    {
        this.control = control;
        view = new OverviewView();

        motdTxt = view.getMotdTextField();
        config = control.getCoreConfig();

        config.addConfigListener(new SingleConfigurationListener(Control.MOTD_SAVEFILE, (value) -> loadMotdText()));

        loadMotdText();

        initializeListeners();
    }

    private void initializeListeners()
    {
        view.addGenAllListener(() -> genAllAction());
        view.addImportListener(() -> importAction());
        view.addExportListener(() -> exportAction());
        view.addBackupListener(() -> backupAction());
        view.addSaveMotdListener(() -> saveMotdText());
    }

    private void genAllAction()
    {
        control.genAll();
    }

    private void importAction()
    {
        control.importLessons();
    }

    private void exportAction()
    {
        control.exportLessonsAndMotd();
    }

    private void backupAction()
    {
        control.createBackup();
    }

    public void saveMotdText()
    {
        config.setConfig(Control.MOTD_SAVEFILE, motdTxt.getText().getBytes(StandardCharsets.UTF_8));
    }

    public void loadMotdText()
    {
        motdTxt.setText(new String(config.getOrCreateConfig(Control.MOTD_SAVEFILE), StandardCharsets.UTF_8));
    }

    public View getView()
    {
        return view;
    }
}
