/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverwofacade;

/**
 *
 * @author emotions
 */
public class ServerFacade {

    private static ServerFacade server;

    private ServerFacade() {
    }

    public static ServerFacade getServer() {
        if (server == null) {
            server = new ServerFacade();
        }
        return server;
    }

    public void startServer() {
        ScheduleServer scheduleServer = new ScheduleServer();
        scheduleServer.startBooting();
        scheduleServer.readSystemConfigFile();
        scheduleServer.init();
        scheduleServer.initializeContext();
        scheduleServer.initializeListeners();
        scheduleServer.createSystemObjects();
        System.out.println("Start working......");
    }

    public void stopServer() {
        ScheduleServer scheduleServer = new ScheduleServer();
        System.out.println("After work done.........");
        scheduleServer.releaseProcesses();
        scheduleServer.destory();
        scheduleServer.destroySystemObjects();
        scheduleServer.destoryListeners();
        scheduleServer.destoryContext();
        scheduleServer.shutdown();
    }
}
