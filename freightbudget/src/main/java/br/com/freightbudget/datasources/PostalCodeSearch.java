package br.com.freightbudget.datasources;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.stereotype.Service;

@Service
public class PostalCodeSearch {
	
	public PostalCodeSearch() {
	}
	
	public String getPostalCodeInfo (String CEP) {
		String resp = "";
		HttpRequest request;
		HttpResponse<String> response;
		try {
			request = HttpRequest.newBuilder()
				  .uri(new URI("http://viacep.com.br/ws/" + CEP + "/json/"))
				  .version(HttpClient.Version.HTTP_2)
				  .GET()
				  .build();
			response = HttpClient.newHttpClient()
					  .send(request, HttpResponse.BodyHandlers.ofString());
			resp = response.body();
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}
		catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		return resp;
	}
	
	public static void main (String [] args) {
		PostalCodeSearch p = new PostalCodeSearch();
		System.out.println(p.getPostalCodeInfo("53401150"));
	}
}
