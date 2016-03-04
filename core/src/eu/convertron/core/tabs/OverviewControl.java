package eu.convertron.core.tabs;

import eu.convertron.applib.settings.ComponentSetting;
import eu.convertron.core.Control;
import eu.convertron.interlib.interfaces.View;

public class OverviewControl
{
    private OverviewView view;
    private ComponentSetting motdHandler;

    private Control control;

    public OverviewControl(Control control)
    {
        this.control = control;
        view = new OverviewView();
        motdHandler = view.createMotdSettingHandler();
        loadMotdText();

        initializeListeners();
    }

    private void initializeListeners()
    {
        view.addGenAllListener(()
                ->
                {
                    genAllAction();
        });

        view.addImportListener(()
                ->
                {
                    importAction();
        });

        view.addExportListener(()
                ->
                {
                    exportAction();
        });

        view.addBackupListener(()
                ->
                {
                    backupAction();
        });

        view.addSaveMotdListener(()
                ->
                {
                    saveMotdText();
        });
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
        motdHandler.save();
    }

    public void loadMotdText()
    {
        motdHandler.load();
    }

    public View getView()
    {
        return view;
    }
}
