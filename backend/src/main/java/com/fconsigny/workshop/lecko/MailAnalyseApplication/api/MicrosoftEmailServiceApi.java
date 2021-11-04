package com.fconsigny.workshop.lecko.MailAnalyseApplication.api;

import com.microsoft.graph.requests.GraphServiceClient;
import com.microsoft.graph.requests.MessageCollectionPage;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MicrosoftEmailServiceApi {

    @Qualifier("apiMicrosoftClient")
    GraphServiceClient graphClient;

    public MicrosoftEmailServiceApi(GraphServiceClient graphClient) {
        this.graphClient = graphClient;
    }

    public MessageCollectionPage findEmailsByUserId(String id) {
        return graphClient.users().byId(id).messages()
                .buildRequest()
                .get();
    }
}
