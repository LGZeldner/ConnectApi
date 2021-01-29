package com.example.connectapi;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ApiKeysList {
    @SerializedName("apiKeys")
    List<ApiKey> apiKey;
}
