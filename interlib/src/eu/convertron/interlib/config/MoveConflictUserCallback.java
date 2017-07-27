package eu.convertron.interlib.config;

import java.util.function.Consumer;

public interface MoveConflictUserCallback
{
    public byte[] resolveConflictSynchron(ConflictInfo conflict);

    public void resolveConflict(Consumer<byte[]> resultConsumer, ConflictInfo conflict);
}
