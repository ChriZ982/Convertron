package eu.convertron.core.tabs;

import eu.convertron.core.Control;
import eu.convertron.interlib.config.GeneralConfigFile;
import eu.convertron.interlib.interfaces.View;

public class OverviewControl
{
    private final OverviewView view;
    private final GeneralConfigFile config;

    private final Control control;

    public OverviewControl(Control control)
    {
        this.control = control;
        view = new OverviewView();

        config = new GeneralConfigFile(control.getGlobalCoreConfig(), Control.MOTD_SAVEFILE);

        config.addConfigFileListener((val) -> loadMotdText());

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
        config.save(view.getMotdText());
        control.exportMotd();
    }

    public void loadMotdText()
    {
        view.setMotdText(config.loadString());
    }

    public View getView()
    {
        return view;
    }
}
