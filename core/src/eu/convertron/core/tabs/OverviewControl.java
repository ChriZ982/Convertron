package eu.convertron.core.tabs;

import eu.convertron.core.Control;
import eu.convertron.interlib.interfaces.View;

public class OverviewControl
{
    private final OverviewView view;

    private final Control control;

    public OverviewControl(Control control)
    {
        this.control = control;
        view = new OverviewView();

        control.getMotdConfigFile().addConfigFileListener((val) -> loadMotdText());

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
        control.getMotdConfigFile().save(view.getMotdText());
        control.exportMotd();
    }

    public void loadMotdText()
    {
        view.setMotdText(control.getMotdConfigFile().loadString());
    }

    public View getView()
    {
        return view;
    }
}
