package com.clouway.playingwithmockito.mockito.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.clouway.playingwithmockito.mockito.client.MockitoService;

public class MockitoServiceImpl extends RemoteServiceServlet implements MockitoService {
    // Implementation of sample interface method
    public String getMessage(String msg) {
        return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
    }
}