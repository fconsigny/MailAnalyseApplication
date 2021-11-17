package com.fconsigny.workshop.lecko.MailAnalyseApplication.api;

import com.microsoft.graph.requests.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import com.microsoft.graph.http.GraphServiceException;

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

    public String findUserProfile(String userId) throws IOException {

        try {
            ProfilePhotoStreamRequest request = graphClient.users().byId(userId).photo().content().buildRequest();
            byte[] s = request.get().readAllBytes();
            Path path = Path.of(userId + ".jpg");
            String str_path =   Files.write(path,s).toString();
            return str_path;


        } catch (GraphServiceException e) {
            Logger logger = LoggerFactory.getLogger(this.getClass());
            logger.info(e.getMessage());
            return null;
        }
    }

}
