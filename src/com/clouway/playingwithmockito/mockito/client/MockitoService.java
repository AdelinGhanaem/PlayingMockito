package com.clouway.playingwithmockito.mockito.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("MockitoService")
public interface MockitoService extends RemoteService {
    // Sample interface method of remote interface
    String getMessage(String msg);

    /**
     * Utility/Convenience class.
     * Use MockitoService.App.getInstance() to access static instance of MockitoServiceAsync
     */
    public static class App {
        private static MockitoServiceAsync ourInstance = GWT.create(MockitoService.class);

        public static synchronized MockitoServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
