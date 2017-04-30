package com.chongdashu.game.gdxspatial.worker;

import improbable.WorkerAttribute;
import improbable.WorkerAttributeSet;
import improbable.WorkerRequirementSet;
import improbable.collections.Option;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CommonWorkerRequirements {
    public static WorkerRequirementSet UnityClientOnly() {
        return CreateWorkerRequirementSet("visual");
    }

    public static WorkerRequirementSet UnityWorkerOnly() {
        return CreateWorkerRequirementSet("physics");
    }

    public static WorkerRequirementSet UnrealClientOnly() {
        return CreateWorkerRequirementSet("UnrealClient");
    }

    public static WorkerRequirementSet UnrealWorkerOnly() {
        return CreateWorkerRequirementSet("UnrealWorker");
    }

    public static WorkerRequirementSet LibGdxClientOnly() {
        return CreateWorkerRequirementSet("libgdx_client");
    }

    public static WorkerRequirementSet LibGdxWorkerOnly() {
        return CreateWorkerRequirementSet("libgdx_worker");
    }

    public static WorkerRequirementSet SpecificWorkerId(String workerId) {
        return CreateWorkerRequirementSet(("workerId:"+workerId));
    }

    public static WorkerRequirementSet AllCommonWorkers() {

        List<WorkerAttributeSet> attributeSets = Arrays.asList(
                CreateWorkerAttributeSet("visual"), // UnityClient
                CreateWorkerAttributeSet("physics"), // UnityWorker
                CreateWorkerAttributeSet("UnrealClient"), // UnrealClient
                CreateWorkerAttributeSet("UnrealWorker"), // UnrealWorker
                CreateWorkerAttributeSet("libgdx_client"), // libGDXClient
                CreateWorkerAttributeSet("libgdx_worker") // libGDXWorker
        );

        return new WorkerRequirementSet(attributeSets);
    }

    private static List<WorkerAttribute> CreateWorkerAttributes(String singleAttribute) {
        return Collections.singletonList(new WorkerAttribute(Option.of(singleAttribute)));
    }

    private static WorkerAttributeSet CreateWorkerAttributeSet(String singleAttribute) {
        return new WorkerAttributeSet(CreateWorkerAttributes((singleAttribute)));
    }

    private static WorkerRequirementSet CreateWorkerRequirementSet(String singleAttribute)
    {
        improbable.WorkerAttribute attribute = new improbable.WorkerAttribute(Option.of(singleAttribute));
        List<WorkerAttribute> attributes = Collections.singletonList(attribute);

        improbable.WorkerAttributeSet attributeSet = new improbable.WorkerAttributeSet(attributes);
        List<improbable.WorkerAttributeSet> attributeSets = Collections.singletonList((attributeSet));

        return new WorkerRequirementSet(attributeSets);
    }
}
