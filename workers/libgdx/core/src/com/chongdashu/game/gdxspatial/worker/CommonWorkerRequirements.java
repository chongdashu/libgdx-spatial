package com.chongdashu.game.gdxspatial.worker;

import improbable.WorkerAttribute;
import improbable.WorkerRequirementSet;
import improbable.collections.Option;

import java.util.Collections;
import java.util.List;

/**
 * Created by chong-u on 29/04/2017.
 */
public class CommonWorkerRequirements {
    public static WorkerRequirementSet UnityClientOnly() {
        return SpecificWorkerType("Visual");
    }

    public static WorkerRequirementSet UnityWorkerOnly() {
        return SpecificWorkerType("Physics");
    }

    public static WorkerRequirementSet UnrealClientOnly() {
        return SpecificWorkerType("UnrealClient");
    }

    public static WorkerRequirementSet UnrealWorkerOnly() {
        return SpecificWorkerType("UnrealWorker");
    }

    public static WorkerRequirementSet GdxClientOnly() {
        return SpecificWorkerType("GdxClient");
    }

    public static WorkerRequirementSet GdxWorkerOnly() {
        return SpecificWorkerType("GdxWorker");
    }

    public static WorkerRequirementSet SpecificWorkerId(String workerId) {
        return SpecificWorkerType(("workerId:"+workerId));
    }

    private static WorkerRequirementSet SpecificWorkerType(String workerType)
    {
        improbable.WorkerAttribute attribute = new improbable.WorkerAttribute(Option.of(workerType));
        List<WorkerAttribute> attributes = Collections.singletonList(attribute);

        improbable.WorkerAttributeSet attributeSet = new improbable.WorkerAttributeSet(attributes);
        List<improbable.WorkerAttributeSet> attributeSets = Collections.singletonList((attributeSet));

        return new WorkerRequirementSet(attributeSets);
    }
}
