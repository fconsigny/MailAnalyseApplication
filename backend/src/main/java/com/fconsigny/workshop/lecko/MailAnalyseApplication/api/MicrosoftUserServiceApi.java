package com.fconsigny.workshop.lecko.MailAnalyseApplication.api;

import com.microsoft.graph.requests.GraphServiceClient;
import com.microsoft.graph.requests.MessageCollectionPage;
import com.microsoft.graph.requests.UserCollectionPage;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MicrosoftUserServiceApi {

    @Qualifier("apiMicrosoftClient")
    GraphServiceClient graphClient;

    public MicrosoftUserServiceApi(GraphServiceClient graphClient) {
        this.graphClient = graphClient;
    }

    public UserCollectionPage findUsers() {
        return graphClient.users()
                .buildRequest()
                .orderBy("displayName")
                .get();
    }

}
