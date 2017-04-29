package com.chongdashu.game.gdxspatial.desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.chongdashu.game.gdxspatial.entity.EntityTemplateFactory;
import improbable.collections.Option;
import improbable.worker.EntityId;
import improbable.worker.Snapshot;
import improbable.worker.SnapshotEntity;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class SnapshotGenerator {
    public static void main (String[] arg) {
        CreateDefaultSnapshot();
    }

    private static void CreateDefaultSnapshot()
    {
        System.out.println("[Generating snapshot...");

        // EntityId counter.
        long currentEntityId = 1;

        // Snapshot file name.
        String snapshotFilename = "../../snapshots/default.snapshot";

        // Load a snapshot from a file.
        Map<EntityId, SnapshotEntity> entities = new HashMap<EntityId, SnapshotEntity>();

        // Add all entities
        entities.put(new EntityId(currentEntityId), EntityTemplateFactory.CreatePlayerEntity());

        // Prepare location for snapshot.
        File snapshot = new File(snapshotFilename);
        if (snapshot.exists()) {
            System.out.println("  * Detected old snapshot. Attempting to delete it. Result=" + snapshot.delete());
        }
        else {
            System.out.println("  * No previous snapshot found. Check if we need to make the folder. Result=" + snapshot.getParentFile().mkdirs());
        }

        // Save the snapshot.
        Option<String> errorOpt = Snapshot.save(snapshotFilename, entities);
        if (errorOpt.isPresent()) {
            throw new RuntimeException("Error saving snapshot: " + errorOpt.get());
        }

        System.out.print("Successfully wrote to: " + snapshotFilename);
    }
}
