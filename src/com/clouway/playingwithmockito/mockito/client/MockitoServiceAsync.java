package com.clouway.playingwithmockito.mockito.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface MockitoServiceAsync {
    void getMessage(String msg, AsyncCallback<String> async);
}
