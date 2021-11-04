package com.fconsigny.workshop.lecko.MailAnalyseApplication.config;

import com.azure.identity.ClientSecretCredential;
import com.azure.identity.ClientSecretCredentialBuilder;
import com.microsoft.graph.authentication.TokenCredentialAuthProvider;
import com.microsoft.graph.requests.GraphServiceClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MicrosoftApiConfiguration {

    @Value("${api.microsoft.auth.client_id}")
    private String CLIENT_ID;

    @Value("${api.microsoft.auth.client_secret}")
    private String CLIENT_SECRET;

    @Value("${api.microsoft.auth.scope}")
    private String DEFAULT_SCOPES;

    @Value("${api.microsoft.auth.tenant_id}")
    private String TENANT_GUID;

    private GraphServiceClient GRAPH_CLIENT_INSTANCE;

    @Bean
    public GraphServiceClient apiMicrosoftClient() {
        if (GRAPH_CLIENT_INSTANCE == null) {
            GRAPH_CLIENT_INSTANCE = initMicrosoftClientClient();
        }

        return GRAPH_CLIENT_INSTANCE;
    }

    private GraphServiceClient initMicrosoftClientClient() {
        final ClientSecretCredential clientSecretCredential = new ClientSecretCredentialBuilder()
                .clientId(CLIENT_ID)
                .clientSecret(CLIENT_SECRET)
                .tenantId(TENANT_GUID)
                .build();

        List<String> SCOPES = List.of(DEFAULT_SCOPES);

        final TokenCredentialAuthProvider tokenCredAuthProvider = new TokenCredentialAuthProvider(SCOPES, clientSecretCredential);

        return GraphServiceClient
                .builder()
                .authenticationProvider(tokenCredAuthProvider)
                .buildClient();
    }
}
