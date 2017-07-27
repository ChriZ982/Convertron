package eu.convertron.core.usercallback;

import eu.convertron.applib.CallbackControl;
import eu.convertron.core.Control;
import eu.convertron.interlib.config.ConflictInfo;
import eu.convertron.interlib.io.TextFile;
import eu.convertron.interlib.logging.LogPriority;
import eu.convertron.interlib.logging.Logger;
import java.awt.EventQueue;
import java.util.function.Consumer;
import javax.swing.JFrame;

public class MoveConflictControl extends CallbackControl<byte[]>
{
    private final byte[] globalVersion;
    private final byte[] localVersion;

    private final Control control;
    private final MoveConflictDialog dialog;

    private TextFile mergedFile;

    public MoveConflictControl(Consumer<byte[]> resultConsumer, ConflictInfo conflict, JFrame owner, Control control)
    {
        super(resultConsumer);
        this.localVersion = conflict.getLocalVersion();
        this.globalVersion = conflict.getGlobalVersion();

        this.control = control;
        this.dialog = new MoveConflictDialog(owner, conflict.getModule(), conflict.getConfigName());

        initListeners();
    }

    private void initListeners()
    {
        dialog.addAbortListener(() -> abort());
        dialog.addDiscardLocalListener(() -> discardLocal());
        dialog.addOverrideGlobalBtn(() -> overrideGlobal());
        dialog.addStartMeldListener(() -> startMeld());
        dialog.addUseMeldResultListener(() -> useMeldResult());
    }

    private void abort()
    {
        finishDialog(null);
    }

    private void discardLocal()
    {
        finishDialog(globalVersion);
    }

    private void overrideGlobal()
    {
        finishDialog(localVersion);
    }

    private void startMeld()
    {
        try
        {
            dialog.setMeldStarted(true);
            mergedFile = control.startMeld("LOKALE_VERSION", localVersion, "GLOBALE_VERSION", globalVersion);
        }
        catch(Exception ex)
        {
            Logger.logError(LogPriority.WARNING, "Fehler beim Starten von Meld", ex);
            dialog.setMeldStarted(false);
        }
    }

    private void useMeldResult()
    {
        try
        {
            finishDialog(control.finishMeld(mergedFile));
        }
        catch(Exception ex)
        {
            Logger.logError(LogPriority.WARNING, "Fehler beim Auslesen des Ergebnisses des Merges. Läuft Meld noch?", ex);
        }
    }

    @Override
    protected void finishDialog(byte[] result)
    {
        dialog.dispose();
        super.finishDialog(result);
    }

    @Override
    public byte[] waitForResult(int timeout) throws InterruptedException
    {
        if(EventQueue.isDispatchThread())
        {
            throw new UnsupportedOperationException("The Dispatch-Thread cannot wait for Dialog to be finished");
        }

        return super.waitForResult(timeout);
    }

    public MoveConflictControl showDialog()
    {
        dialog.setVisible(true);

        return this;
    }
}
