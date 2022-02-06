package com.yash.coronavirusrecovertracker.service;


import com.yash.coronavirusrecovertracker.model.CoronaVirusRecordsTableModel;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class CoronavirusRecordsService {
    private static String url = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
    List<CoronaVirusRecordsTableModel> allRecords = new ArrayList<>();

    public List<CoronaVirusRecordsTableModel> getRecordsFromUrl() throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        List<CoronaVirusRecordsTableModel> currentRecords = new ArrayList<>();
        StringReader reader = new StringReader(response.body());
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader);
        for (CSVRecord record : records) {
            CoronaVirusRecordsTableModel model = new CoronaVirusRecordsTableModel();
            model.setState(record.get("Province/State"));
            model.setCountry(record.get("Country/Region"));
            model.setCasesToday(record.get(record.size() - 1));
            currentRecords.add(model);
        }
        allRecords.clear();
        allRecords.addAll(currentRecords);
        return allRecords;
    }
}
