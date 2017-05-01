package com.chongdashu.game.gdxspatial.spatialos;

import com.badlogic.gdx.utils.async.AsyncExecutor;
import com.badlogic.gdx.utils.async.AsyncResult;
import com.badlogic.gdx.utils.async.AsyncTask;
import improbable.worker.*;

import java.io.IOException;
import java.util.UUID;

public class WorkerConnection {

    static AsyncExecutor asyncExecutor = new AsyncExecutor(10);
    static AsyncResult<Void> connectTask;
    private static Connection connection;
    private static boolean isConnected;
    private static Dispatcher dispatcher;

    public static void connect() throws IOException {

        ConnectionParameters parameters = new ConnectionParameters();
        parameters.workerType = "LibGdxClient";
        parameters.workerId = parameters.workerType + UUID.randomUUID();
        parameters.networkParameters.type = NetworkConnectionType.Tcp;
        parameters.networkParameters.useExternalIp = false;

        String hostname = "localhost";
        short port = 7777;

        System.out.println("Making connection to SpatialOS...");
        System.out.println("    workerType: " + parameters.workerType);
        System.out.println("    workerType: " + parameters.workerId);



        //create our async task that runs our async method
        connectTask = asyncExecutor.submit(new AsyncTask<Void>() {
            public Void call() {

                connection = Connection.connectAsync(hostname, port, parameters).get();
                isConnected = connection.isConnected();

                if (connection.isConnected()) {
                    System.out.println("Successfully connected to SpatialOS");
                    dispatcher = new Dispatcher();
                }
                else {
                    System.out.println("Failed to connect to SpatialOS");
                }
                return null;
            }
        });

    }

    public static boolean isConnectedToSpatialOS()
    {
        return connectTask.isDone() && dispatcher != null;
    }

    public static void update() throws InterruptedException {
            try (OpList opList = connection.getOpList(0 /* non-blocking */)) {
                // Invoke user-provided callbacks.
                dispatcher.process(opList);
                Thread.sleep(30);
            }
    }
}
