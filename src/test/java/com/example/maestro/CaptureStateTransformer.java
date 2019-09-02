package com.example.maestro;

import com.github.tomakehurst.wiremock.common.FileSource;
import com.github.tomakehurst.wiremock.extension.Parameters;
import com.github.tomakehurst.wiremock.extension.ResponseDefinitionTransformer;
import com.github.tomakehurst.wiremock.http.HttpHeaders;
import com.github.tomakehurst.wiremock.http.Request;
import com.github.tomakehurst.wiremock.http.ResponseDefinition;

public class CaptureStateTransformer extends ResponseDefinitionTransformer {
    private String state = null;

    @Override
    public ResponseDefinition transform(Request request, ResponseDefinition responseDef, FileSource files, Parameters parameters) {
        // Capture the state parameter from the /oauth/authorize request
        if (state == null && request.queryParameter("state") != null) {
            state = request.queryParameter("state").firstValue();
        }

        // Add the state parameter to the /login redirect
        HttpHeaders headers = responseDef.getHeaders();
        if (headers!=null && headers.getHeader("Location").isPresent()) {
            String redirectLocation = headers.getHeader("Location").firstValue();
            return ResponseDefinition.redirectTo(redirectLocation.replace("${state-key}", this.state));
        }

        return responseDef;
    }

    @Override
    public String getName() {
        return "CaptureStateTransformer";
    }
}
