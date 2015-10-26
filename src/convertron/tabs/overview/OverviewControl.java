package convertron.tabs.overview;

import convertron.core.Control;
import convertron.settings.ComponentSetting;

public class OverviewControl
{
    private OverviewView view;
    private ComponentSetting motdHandler;

    public OverviewControl()
    {
        view = new OverviewView();
        motdHandler = view.createMotdSettingHandler();
        loadMotdText();

        initializeListeners();
        Control.addViewToWindow(view);
    }

    private void initializeListeners()
    {
        view.addGenAllListener(() ->
        {
            genAllAction();
        });

        view.addImportListener(() ->
        {
            importAction();
        });

        view.addExportListener(() ->
        {
            exportAction();
        });

        view.addBackupListener(() ->
        {
            backupAction();
        });

        view.addSaveMotdListener(() ->
        {
            saveMotdText();
        });
    }

    private void genAllAction()
    {
        Control.genAll();
    }

    private void importAction()
    {
        Control.importLessons();
    }

    private void exportAction()
    {
        Control.exportLessonsAndMotd();
    }

    private void backupAction()
    {
        Control.createBackup();
    }

    public void saveMotdText()
    {
        motdHandler.save();
    }

    public void loadMotdText()
    {
        motdHandler.load();
    }
}
