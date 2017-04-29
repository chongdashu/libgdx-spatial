package com.chongdashu.game.gdxspatial.entity;


import com.chongdashu.WorldPosition;
import com.chongdashu.WorldPositionData;
import com.chongdashu.game.gdxspatial.worker.CommonWorkerRequirements;
import improbable.ComponentAcl;
import improbable.EntityAcl;
import improbable.EntityAclData;
import improbable.WorkerRequirementSet;
import improbable.collections.Option;
import improbable.math.Coordinates;
import improbable.worker.SnapshotEntity;

import java.util.HashMap;
import java.util.Map;

public class EntityTemplateFactory {

    public static SnapshotEntity CreatePlayerEntity() {
        SnapshotEntity entity = new SnapshotEntity("Player");

        // Read Authority
        WorkerRequirementSet readAccess = CommonWorkerRequirements.GdxClientOnly();

        // Write Authority
        Map<Integer, WorkerRequirementSet> write_access = new HashMap<>();

        // Components
        entity.add(WorldPosition.class, new WorldPositionData(new Coordinates(0,0,0)));

        // Component writers
        write_access.put(WorldPosition.COMPONENT_ID, CommonWorkerRequirements.GdxClientOnly());

        // -- Set ACLs and Requirements on the Entity
        entity.add(EntityAcl.class, new EntityAclData(
                Option.of(readAccess),
                Option.of(new ComponentAcl(write_access)
        )));

        return entity;
    }


}
