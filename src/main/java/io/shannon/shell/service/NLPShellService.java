package io.shannon.shell.service;


import io.shannon.shell.entity.NLPResult;
import io.shannon.shell.entity.nlpserver.Response;
import io.shannon.shell.entity.nlpserver.Sentences;
import io.shannon.shell.entity.nlpserver.Tokens;
import lombok.AllArgsConstructor;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.alibaba.fastjson.JSONArray;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@AllArgsConstructor
public class NLPShellService {

    private final String host;
    private final String port;

    public NLPResult nlpProcess(String input) {

        String targetServer = "http://" + host + ":" + port + "/?properties=";
        String parameters = "{\"annotators\":\"tokenize,ssplit,truecase,pos,lemma,ner\",\"outputFormat\":\"json\"}";

        try {
            String encodeParameters = URLEncoder.encode(parameters, StandardCharsets.UTF_8.toString());
            String targetUrl = targetServer + encodeParameters;

            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(targetUrl);
            httpPost.setHeader("Content-Type", "application/json;charset=utf-8");
            StringEntity postString = new StringEntity(input, "utf-8");
            httpPost.setEntity(postString);
            HttpResponse response = httpClient.execute(httpPost);

            String content = EntityUtils.toString(response.getEntity());
            //System.out.println(content);
            Response nlpResponse = JSONArray.parseObject(content, Response.class);
            System.out.println(nlpResponse);

            return parseResponse(nlpResponse);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private NLPResult parseResponse(Response response) {

        //System.out.println(response);
        ArrayList<String> nnList = new ArrayList<>();
        ArrayList<String> nerList = new ArrayList<>();

        List<Sentences> sentencesList = response.getSentences();
        Sentences sentences = sentencesList.get(0);
        List<Tokens> tokens = sentences.getTokens();
        for (Tokens token : tokens) {
            String pos = token.getPos();
            String pattern = "NN.*";
            if (Pattern.matches(pattern, pos)) {
                nnList.add(token.getWord());
            }
        }

        System.out.println(nnList);
        NLPResult resultList = new NLPResult();
        resultList.setListOfNN(nnList);
        resultList.setListOfNER(nerList);

        return resultList;
    }
}
