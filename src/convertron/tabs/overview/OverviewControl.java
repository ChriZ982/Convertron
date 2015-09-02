package convertron.tabs.overview;

import convertron.core.Control;

public class OverviewControl
{
    private OverviewView view;

    public OverviewControl()
    {
        view = new OverviewView();

        Control.addViewToWindow(view);

        initializeListeners();
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
            saveMotdAction();
        });

        view.addShowInfosListener(() ->
        {
            showInfoStateChanged();
        });
    }

    private void genAllAction()
    {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    private void importAction()
    {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    private void exportAction()
    {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    private void backupAction()
    {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    private void saveMotdAction()
    {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    private void showInfoStateChanged()
    {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
